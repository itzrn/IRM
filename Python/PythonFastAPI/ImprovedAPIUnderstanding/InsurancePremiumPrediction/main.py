from fastapi import FastAPI
from model.predict import predict_output, MODEL_VERSION, model
from fastapi.responses import JSONResponse
from schema.prediction_response import PredictionResponse
from schema.user_input import UserInput

app = FastAPI()


# human readable
@app.get('/')
def home():
    return {'message': 'Insurance Premium Prediction API'}


# machine readable
@app.get('/health')  # cloud services forces us to do this that is the reason for making this end point
def health_check():
    return {
        'status': 'OK',
        'version': MODEL_VERSION,
        'model_loaded': model is not None
    }


# what response model will do, on return it will validate the output and return
@app.post('/predict', response_model=PredictionResponse)
def predict_premium(data: UserInput):
    user_input = {
        'bmi': data.bmi,
        'age_group': data.age_group,
        'lifestyle_risk': data.lifestyle_risk,
        'city_tier': data.city_tier,
        'income_lpa': data.income_lpa,
        'occupation': data.occupation
    }

    try:
        prediction = predict_output(user_input)
        return JSONResponse(status_code=200, content={'response': prediction})
    except Exception as e:
        return JSONResponse(status_code=500, content=str(e))
