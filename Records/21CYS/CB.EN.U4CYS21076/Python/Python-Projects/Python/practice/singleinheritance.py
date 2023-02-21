class inhertiance:
    def __init__ (self , Name1 , Name2):
        self.firstname = Name1
        self.lastname = Name2

    def somefunction(self):
        print('The first name is :' + self.firstname)

class child(inhertiance):
    def __init__ (self , firstname , lastname ):
        super().__init__ (firstname , lastname)
        year = 23
        self.year = year

    def childfunction(self):
        print(self.firstname , self.lastname , self.year)

names1 = input("Enter your first name : ")
names2 = input("Enter your second name : ")
object = inhertiance(names1 , names2)
object.somefunction()
anotherobject = child(names1 , names2)
anotherobject.childfunction()

