# i = 1
# n = int(input("Enter the Count for the While Loop:"))
# while i<= int(n):
#     print("*" * i)
#     i = i +1
#
number = 7
i = 0
while i < 3 :
    guess = int(input('Guess : '))
    i += 1
    if guess == number:
        print("Nice")
        break
    else:
        print("Try again")
