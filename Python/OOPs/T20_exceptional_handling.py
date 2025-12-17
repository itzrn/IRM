try:
    a = int(input("Hey, Enter a number: "))
except ValueError as v:
    print(v)
except Exception as e:
    print(e)

