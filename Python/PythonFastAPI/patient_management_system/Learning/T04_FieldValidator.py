from pydantic import BaseModel, field_validator
from typing import List, Dict, Optional


# Field Validator allows you to put custom validation and also allow transformation(like you want your patient name
# in capital always)
class Patient(BaseModel):
    name: str
    age: int
    email: str
    weight: float
    married: bool = False
    allergies: List[str]
    contact_details: Optional[Dict[str, str]] = None

    @field_validator('email')
    @classmethod
    def email_validator(cls, value):
        valid_domain = ['hdfc.com', 'icici.com']

        domain_name = value.split('@')[-1]

        if domain_name not in valid_domain:
            raise ValueError('Not a valid domain')

        return value

    @field_validator('name')
    @classmethod
    def transform_name(cls, value):
        return value.upper()

    @field_validator('age', mode='after')  # default value is after
    @classmethod
    def validate_age(cls, value):  # here 24 will come in the form of int (means after type coercion)
        if 0 < value < 100:
            return value
        raise ValueError('Age should be in between 0 and 100')

    # suppose if the age is more than 70 then in contact details the patient should have emergency number
    # if not present then patient will not get create
    # now here we can not use field_validator bcz it used on single field
    # now we have model validator


# created raw data
patient_info = {
    'name': 'Aryan',
    'age': '24',
    'email': 'abc@hdfc.com',
    'weight': 60.5,
    'married': False,
    'allergies': ['dust', 'sunlight'],
    'contact_details': {
        'phone': '1122334455'
    }
}

patient1 = Patient(**patient_info)


def insert_patient_data(patient: Patient):
    print(patient.name)
    print(patient.age)
    print("inserted")


insert_patient_data(patient1)

"""
field_validator operates in two mode
    1. before mode -> the value u get in parameter is before type coercion
    2. after mode -> the value u get in parameter is after type coercion
"""
