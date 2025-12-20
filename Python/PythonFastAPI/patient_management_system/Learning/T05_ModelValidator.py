from pydantic import BaseModel, EmailStr, model_validator
from typing import List, Dict, Optional


class Patient(BaseModel):
    name: str
    age: int
    email: EmailStr
    weight: float
    married: bool = False
    allergies: List[str]
    contact_details: Optional[Dict[str, str]] = None

    @model_validator(mode='after')
    def validate_emergency_contact(self):
        print("I am inside model validator")
        if self.age > 60 and 'emergency' not in self.contact_details:
            raise ValueError("Patient Older than 60 must have emergency contact")
        return self


patient_info = {
    'name': 'Aryan',
    'age': 76,
    'email':'abs@gmail.com',
    'weight': 60.5,
    'married': False,
    'allergies': ['dust', 'sunlight'],
    'contact_details': {
        'phone': '1122334455'
    }
}

patient1 = Patient(**patient_info)


# def insert_patient_data(patient: Patient):
#     print(patient.name)
#     print(patient.age)
#     print("inserted")
#
#
# insert_patient_data(patient1)

