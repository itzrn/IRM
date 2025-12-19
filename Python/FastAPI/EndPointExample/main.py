from fastapi import FastAPI

app = FastAPI()


@app.get("/")  # this '/' means that you are hitting on home URL
def hello():
    return {'message': 'Hello World'}

# uvicorn main:app --reload
