from pydantic import BaseModel
from typing import List, Dict, Optional


class Patient(BaseModel):  # Pydantic Model
    # by default all the attributes are required
    name: str
    age: int
    weight: float
    married: bool = False  # default value and also if user won't provide this value then it will show default value
    allergies: List[str]  # why not list? List is used for 2 level validation, if we had used list then pydantic
    # just validated that allergies is a list not every element of the list is string
    contact_details: Optional[Dict[str, str]] = None # making this as optional if user won't provide then also it will work
    # when we make anything Optional we need to prove them a default value that is None


# created raw data
patient_info = {
    'name': 'Aryan',
    'age': 24,
    'weight': 60.5,
    'married': False,
    'allergies': ['dust', 'sunlight'],
    'contact_details': {
        'email': 'abc@gmail.com',
        'phone': '1122334455'
    }
}

patient1 = Patient(**patient_info)


def insert_patient_data(patient: Patient):
    print(patient.name)
    print(patient.age)
    print("inserted")


insert_patient_data(patient1)

