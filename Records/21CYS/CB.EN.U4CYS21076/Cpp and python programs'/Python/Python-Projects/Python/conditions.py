# good = True
# bad = False
#
# if good and bad :
#     print ("Nice")
name = input("Enter Your Name:")
if len(name) < 3:
    print("Name must be longer than at least 3 Characters")
elif len(name) > 50:
    print("Name is too long")
else:
    print("Name Looks Good")
