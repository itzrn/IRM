from pydantic import BaseModel


class Patient(BaseModel):  # created a pydantic Model, where we described our schema

    # with the help of these attributes we will perform type validation
    name: str
    age: int


patient_info = {'name': 'aryan', 'age': 30}  # this is raw dictionary
# First this rules will get applied to the attributes of the model, if worked fine then will create the object of that

patient1 = Patient(**patient_info)  # to provide the data from dict to object we need to unpack using '**'


def insert_patient_data(patient: Patient):
    print(patient.name)
    print(patient.age)
    print("inserted")


insert_patient_data(patient1)
