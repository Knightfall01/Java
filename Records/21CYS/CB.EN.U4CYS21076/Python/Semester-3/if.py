temperature=int(input("Enter the temperature :"))
if temperature > 30:
    print("Its a Hot day")
elif temperature > 20:
    print("It is a okay day")
elif temperature > 10:
    print("It is a very cold day")
else:
    print("Its too cold")

weight = input("Enter the weight:")
unit = input("Kg or Lbs:")
if unit.upper() == "K":
    print("Print weight in kg")
else:
    print("Print weight in lbs")
    
