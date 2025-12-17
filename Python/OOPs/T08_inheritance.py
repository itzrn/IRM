class Emp:
    company = "TCS"

    def show(self):
        print(f"The name is {self.name} and the salary is {self.salary}")


class Programmer(Emp):
    def show_language(self):
        print(f"The name is {self.name} and he is good in {self.language} language")
