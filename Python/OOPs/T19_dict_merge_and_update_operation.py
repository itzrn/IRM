dict1 = {'a': 1, 'b': 2}
dict2 = {'b': 3, 'c': 4}

merged = dict1 | dict2
print(merged)

# we can use multiple context magaer in a single with statement
with(
    open("file1.txt") as f1,
    open("file2.txt") as f2
):
    pass



