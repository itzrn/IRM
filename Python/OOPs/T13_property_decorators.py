class Employee:
    a = 1

    def __init__(self):
        self.l_name = None
        self.f_name = None

    @classmethod
    def show(cls):
        print(f"The class attribute of a is {cls.a}")

    @property  # this makes the function as property of the class
    def name(self):
        # return f"{self.f_name} {self.l_name}. Hello Guys"
        pass

    @name.setter
    def name(self, value):
        self.f_name = value.split(" ")[0]
        self.l_name = value.split(" ")[1]


e = Employee()
e.a = 45

e.name = "Harry Khan"
print(e.f_name, e.l_name)

e.show()