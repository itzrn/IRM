try:
    a=int(input("Hey, Enter a number: "))
except Exception as e:
    print(e)
else:
    print("I am inside else")

# when try block runs successfully then it enters the else block,
# else in except block
