class Person:
    def __init__ (self , fname , sname):
        self.firstname = fname 
        self.secondname = sname 

    def helloworld(self):
        print("Hello My Name is " + self.firstname + " " + self.secondname)

class Child(Person):
    def __init__ (self , fname , sname , date):
        Person.__init__ (self , fname , sname)
        self.FIRSTNAME = fname
        self.SECONDNAME = sname
        self.DATE = date

    def printshit(self):
        print("Hello My Name is " + self.FIRSTNAME + " " + self.SECONDNAME + "and I am " + self.DATE)

class childofchild(Child):
    def __init__ (self , fname , sname , date , randomnumber):
        Child.__init__ (self , fname , sname , date)
        self.name1 = fname
        self.name2 = sname
        self.dAte = date
        self.Randomnumber = randomnumber

    def printingsomething(self):
        print("Hello there My name is " + self.name1 + " " + self.name2 + " and I am" + self.dAte + "My random number is " + self.Randomnumber)
x = input("Enter your First Name :")
y = input("Enter your Second Name :")
object = Person(x,y)
object.helloworld()
z = "18"
childclass = Child(x,y,z)
childclass.printshit()
a = input("Enter your Random number :")
grandchildclass = childofchild(x,y,z,a)
grandchildclass.printingsomething()
