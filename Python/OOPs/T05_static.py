class Emp:
    language = "py"
    salary = 700000

    def get_info(self):
        print(self.language, self.salary)

    @staticmethod  # making method static bcz this is not specific to one object or one class
    def greet():
        print("Good Morning")


aryan = Emp()
aryan.greet()
