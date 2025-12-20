from pydantic import BaseModel, EmailStr, AnyUrl, Field
from typing import List, Dict, Optional, Annotated


# data validator used from pydantic is used in common use cases
class Patient(BaseModel):
    height: Annotated[float, Field(gt=40.0,
                                   lt=80.5,
                                   title="Height of the Patient",
                                   description="Give the height between the given range",
                                   examples=[55.4, 76.9],
                                   strict=True)]  # this will not allow pydantic for automatic type conversion
    name: str = Field(max_length=50)
    email: EmailStr  # this will also validate the email
    linkedin_url: AnyUrl
    age: int = Field(gt=0, lt=120)
    weight: float = Field(gt=0)  # putting custom validation
    married: Annotated[bool, Field(default=False, description="Is the patient married or not")]
    allergies: List[str] = Field(max_length=5)  # this won't allow more than 5 allergies
    contact_details: Optional[Dict[str, str]] = None


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
