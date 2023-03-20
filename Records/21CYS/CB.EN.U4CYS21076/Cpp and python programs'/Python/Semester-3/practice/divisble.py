# number = int(input("Enter the number :"))
# a = number % 6
# if a == 0:
#     print("The number is divisible by 6")
# else :
#     print("The number is not divisible by 6")

# x=int(input("enter the no: "))
# for i in range(1,x):
#     print(x*i);

# n = int(input("Enter the value for n :"))
# count = 0 
# while (n>0):
#     rem = n % 10
#     n //= 10
#     if rem % 2 == 0:
#         count += 1
# print("number of even digits is :" ,  count)

# n = int(input("Enter the number to be reversed:"))
# reversed = 0
# while n > 0 :
#     a = n % 10
#     reversed = reversed * 10 + a
#     n //= 10 
# print(reversed)
#
# a = int(input("Enter the Number in binary to convert it to Decimal :"))
# c = 0
# i = 0 
# while a > 0 :
#     binary = a % 10 
#     c = c + (2**i)*binary
#     i += 1
#     a = a // 10
# print(c)

# g = eval(input("Enter the number of rows:"))
# for i in range(g):
#     for j in range(g-i):
#         print("*", end="")
#     print()
#
# x = eval(input("Enter the number you want to check whethere divisble by 2:"))
# if ( x % 2 == 0):
#     print("This is a number that is divisible by 2 ")
# elif ( x % 3 == 0):
#     print("This is a number that is divisible by 3 ")
# elif ( x % 6 == 0):
#     print("This is a number that is divisible by 6")
# else :
#     print("This is a number that is not divisible by 2 , 3 and 6 ")
#
# i = 1
# while i <= 10:
#     print((i))
#     i = i + 1 
#
# for i in range(20,0,-1):
#     if i % 2 == 0:
#         print(i,end = '')
# for i in range(1,5):
#     print(i,end ='')
# #

print("print somethign")
x = 'Knightfall is Awesome'
y = 'cool'
print(x[::-1])
print(x.upper())
print(x.lower())
print(x.strip())
print(x.split())
print(x.replace('awesome','cool'))
print(x)
print(type(x))
print(x.replace('awesome','cool')+ 'and awesome')
print(x.endswith('e'))
# print(x.index('hi'))
print(x.join(y))
x2 = 'iiiiiiiiiiknightfalliiiiiii'
print(x2.strip('i'))
print(x2.lstrip('i'))
print(x2.rstrip('i'))
print(x.swapcase())
print(x.title())


# a = "dance"
# b = "hands"
# c = "head"
# sentence = 'I will %s , %s , %s with my %s in air above %s , %s ' %(a , a , a , b , c , c)
# print(sentence)
# print("I am {} , and I am {}" .format('knightfall' , 18))
# print('I am {1} and I am {0}' .format(18 , 'knightfall'))
# print('I am {x} and I am {y} ' .format(x = 'KNIGHTFALL' , y = 18))
# a = 'knightfall'
# b = 18
# c = 'amrita'
# d = 10
# e = int(input("Enter the number u want to see whether it is divisble by 2"))
# print(f"I am {a} , I am {b} , I am studying at {c} , the product of 10 squared is {d**d} and the number u have given is { True if e%2 ==0 else False}")
#
