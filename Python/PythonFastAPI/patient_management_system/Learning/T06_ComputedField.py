from pydantic import BaseModel, EmailStr, computed_field
from typing import List, Dict, Optional


# any field which is required to put in the model and can be calculated
# using some of the field present then that field is called Computed Field
class Patient(BaseModel):
    name: str
    email:EmailStr
    age: int
    weight: float  # kg
    height: float  # m
    married: bool = False
    allergies: List[str]
    contact_details: Optional[Dict[str, str]] = None

    @computed_field
    @property
    def bmi(self) -> float:  # so the name used for function name that name get acquire by the attribute also
        bmi = round(self.weight/(self.height**2), 2)
        return bmi


patient_info = {
    'name': 'Aryan',
    'email': 'abs@gmail.com',
    'age': 24,
    'weight': 60.5,
    'height': 2.5,
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
    print(patient.bmi)
    print("inserted")


insert_patient_data(patient1)

