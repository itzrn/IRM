def fun():
    try:
        a = int(input("Hey, Enter a number: "))
        return a
    except Exception as e:
        print(e)
        return 10
    finally:
        print("Hey, I am inside the finally!")
        # still this section will work, though it above two sections have
        # return statement


fun()
# finally actual use comes in function
