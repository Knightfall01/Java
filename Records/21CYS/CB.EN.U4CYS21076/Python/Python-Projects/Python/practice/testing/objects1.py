class superclass:
    def __init__(self,firstname,):
        self.firstname = firstname 
    
    def printit(self):
        print("My first name is " + self.firstname)  
    
    def methodoverride(self):
        print("I am going to override this class") 

class child(superclass):
    def __init__(self,firstname,lastname):
        super().__init__(lastname)
        self.lastname = lastname
    
    def printshit(self):
        print("My last name is " + self.lastname)
    
    def methodoverride(self):
        print("I overrided this child class") 

        
x = child("Suganth","Sarvesh")
y = superclass("Knightfall")
x.methodoverride()
y.methodoverride()