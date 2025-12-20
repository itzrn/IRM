from pydantic import BaseModel


class Address(BaseModel):
    city: str
    state: str
    pin: str


class Patient(BaseModel):
    name: str
    gender: str = 'Male'  # keeping default
    age: int
    address: Address


address_dict = {'city': 'Bangalore', 'state': 'Karnataka', 'pin': '560006'}
address1 = Address(**address_dict)

patient_dict = {'name': 'Aryan', 'gender': 'Male', 'age': '24', 'address': address1}
patient1 = Patient(**patient_dict)

# this wil convert your pydantic model to python dictionary
tmp = patient1.model_dump()
print(tmp, type(tmp))

# on exporting in dictionary we will get only those fields mentioned in list
tmp = patient1.model_dump(include=['name', 'age'])
print(tmp, type(tmp))

# we have the options to exclude
tmp = patient1.model_dump(exclude=['name', 'age'])
print(tmp, type(tmp))

tmp = patient1.model_dump(exclude={'address':['state']})
print(tmp, type(tmp))

# those fields not given by the user will not get export, means if gender is not given in patient_dict then gender will not get export
tmp = patient1.model_dump(exclude_unset=True)
print(tmp, type(tmp))

# this will convert pyandtic model to python json
tmp = patient1.model_dump_json()
print(tmp, type(tmp))
