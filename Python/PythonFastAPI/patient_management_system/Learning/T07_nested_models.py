"""
This allows pydantic model to use another model as field inside it

Better organization of related data (e.g., vitals, address, insurance)
Reusability: use vitals in multiple models (e.g., Patient, MedicalRecord)
Readability: Easier for developer and API consumers to understand
Validation: Nested models are validated automatically

"""
from pydantic import BaseModel


class Address(BaseModel):
    city: str
    state: str
    pin: str


class Patient(BaseModel):
    name: str
    gender: str
    age: int
    address: Address


address_dict = {'city': 'Bangalore', 'state': 'Karnataka', 'pin': '560006'}
address1 = Address(**address_dict)

patient_dict = {'name': 'Aryan', 'gender': 'Male', 'age': '24', 'address': address1}
patient1 = Patient(**patient_dict)

print(patient1)
print(patient1.name)
print(patient1.address.pin)



