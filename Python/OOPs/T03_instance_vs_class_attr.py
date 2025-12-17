class Employee:
    language="py"
    salary=700000

aryan = Employee()
aryan.language="Java" # the priority is always given to instance variable
print(aryan.language, aryan.salary)