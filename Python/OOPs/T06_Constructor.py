"""
__init__() is a special method which is first run as soon as the object is created
known as constructor

It takes self argument and can also take further arguments
"""


class Emp:
    def __init__(self):
        """
        the methods starting with __ as called as dunder methods

        this method is called as init dunder method
        """
        print("This is the function which get automatically get call when there is an object creation")


aryan = Emp()
