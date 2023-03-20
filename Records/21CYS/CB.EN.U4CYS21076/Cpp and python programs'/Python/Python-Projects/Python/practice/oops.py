class sentence:
    def __init__(self , name , age ):
        self.name = name 
        self.age = age 
    def printing(self):
        print("Hello my name is " + self.name + " and my age is " , self.age)

    def __del__(self):
        print("Class deleted")

name = input("Enter the name:")
age = input("Enter your age:")

mysentence = sentence(name , age)
mysentence.printing()
print(getattr(mysentence , 'name' , 'age'))
print(setattr(mysentence , 'name' , 'knightfall'))
mysentence.printing()
print(hasattr(mysentence,''))
