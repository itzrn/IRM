class Number:
    def __init__(self, n):
        self.n = n

    def __add__(self, num):
        return self.n + num.n


n = Number(1)
m = Number(2)

print(n + m)

"""
__add__
__sub__
__mul__
__truediv__
__floordiv__


__str__ -> used tos et what gets displayed upon calling str(obj)
__len__ -> used to set what get displayed upon calling.__len__() or len(obj)
"""
