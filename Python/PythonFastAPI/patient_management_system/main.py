import json
import PatientPydanticModel as patient_model
from fastapi import FastAPI, Path, HTTPException, Query
from fastapi.responses import JSONResponse

app = FastAPI()


def load_data():
    with open('../patient_management_system/patients.json', 'r') as f:
        data = json.load(f)
    return data


def save_data(data):
    with open('../patient_management_system/patients.json', 'w') as f:
        json.dump(data, f)


@app.get('/about')
def hello():
    return {'message': 'Patient Management System API'}


@app.get('/view')
def view():
    data = load_data()
    return data


@app.get('/patient/{patient_id}')
def view_patient(patient_id: str = Path(..., description='ID of the patient in the DB', example='P001')):
    """
    :param patient_id:
    :return: dict
    """
    # loading the data first
    data = load_data()
    if patient_id in data:
        return data[patient_id]
    raise HTTPException(status_code=404, detail='Patient Not Found')


@app.get('/sort')
def sort_patient(sort_by: str = Query(..., description='sort on the basis of height, weight or bmi'),
                 order: str = Query('asc', description='sort in asc or desc order')):
    valid_fields = ['height', 'weight', 'bmi']

    if sort_by not in valid_fields:
        raise HTTPException(status_code=400, detail=f'Invalid Field select from {valid_fields}')  # 400 means bad
        # request, something is not good provided from the client

    if order not in ['asc', 'desc']:
        raise HTTPException(status_code=400, detail=f'Invalid order select between asc and desc')

    data = load_data()
    sorted_data = sorted(data.values(), key=lambda x: x.get(sort_by, 0), reverse=True if order == 'desc' else False)

    return sorted_data


@app.post('/create')
def create_patient(
        patient: patient_model.Patient):  # the pydantic model will automatically apply all validations and if it's
    # all right then it will send inside the function

    # load the data
    data = load_data()

    # check if the patient already exists
    if patient.id in data:
        raise HTTPException(status_code=400, detail='Patient already exists')

    # else add new patient to the database
    data[patient.id] = patient.model_dump(exclude=['id'])

    # save into the json file
    save_data(data)

    # 201 is the status code for successful entry of new data to a database
    return JSONResponse(status_code=201, content={'message': 'Patient created successfully'})


@app.put('/edit/{patient_id}')
def update_patient(patient_id: str, patient_update: patient_model.PatientUpdate):

    data = load_data()

    if patient_id not in data:
        raise HTTPException(status_code=404,  detail='Patient Not Found')

    existing_patient_info = data[patient_id]

    updated_patient_info = patient_update.model_dump(exclude_unset=True)

    for key, value in updated_patient_info.items():
        existing_patient_info[key] = value

    # converting to a Patient object bcz bmi and verdict are two field which will get automatically calculated
    # this is bcz making the Patient object id is required
    existing_patient_info['id'] = patient_id
    patient_pydantic_object = patient_model.Patient(**existing_patient_info)
    existing_patient_info = patient_pydantic_object.model_dump(exclude=[id])

    # now add this dict to patient
    data[patient_id] = existing_patient_info

    # saving the data
    save_data(data)
    return JSONResponse(status_code=200, content={'message': 'Patient details got updated'})


@app.delete('/delete/{patient_id}')
def delete_patient(patient_id: str):
    data = load_data()

    if patient_id not in data:
        raise HTTPException(status_code=400, detail='Patient Not Found')

    del data[patient_id]

    save_data(data)

    return JSONResponse(status_code=200, content={'message': 'patient got delete'})

