class Emp:
    language = "PY"
    name = "Aryan"
    salary = 700000

    def __init__(self, name, salary, language):
        self.language = language
        self.salary = salary
        self.name = name


aryan = Emp("Aryan", 1200000, "Java")