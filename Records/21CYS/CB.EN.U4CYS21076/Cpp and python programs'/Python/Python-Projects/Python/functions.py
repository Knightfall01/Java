def function1(*y):
    for x in y:
        print(x)

z = int(input("Enter the numbers:"))
y = int(input("Enter the numbers:"))
x = int(input("Enter the numbers:"))
a = int(input("Enter the numbers:"))
function1(z, y , x ,a )

try:
    number = int(input("Enter the number:"))
    print (1/number)
except ValueError as error:
    print("Enter a number")
    print(error)
except ZeroDivisionError as error:
    print("Can't be divided by zero")
    print(error)
else:
    print("Nothing went wrong so it got executed sucessfully")
finally:
    print("The program has been executed.")
print('Hello') if 50 > 7 else print('Hi')
print('Hello')
