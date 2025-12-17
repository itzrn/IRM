class Employee:
    language = "py"
    salary = 100000

    def get_info(self):
        print(f"The language is {self.language}. The salary is {self.salary}")


aryan = Employee()
aryan.get_info()  # -> Employee.get_info(aryan) it automatically get convert to something like this
