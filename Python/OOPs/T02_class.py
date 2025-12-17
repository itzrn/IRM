class Employee:  # this is the blueprint
    language = "py"
    salary = 700000


aryan = Employee()  # this is when memory get allocated to object
aryan.name = "Aryan"
print(aryan.name, aryan.language, aryan.salary)

"""
Here name is instance Attribute
Salary and language is class Attribute as they directly belong to class 
"""
