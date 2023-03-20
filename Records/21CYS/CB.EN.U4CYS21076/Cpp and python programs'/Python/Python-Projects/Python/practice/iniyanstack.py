class mystack:
    def _init_(self,maximum):
        self.a=[]
        self.t=-1
        self.max_size=maximum
    
    def push(self, value):
        
        self.value=value
        self.a.append(self.value)
        
    def pop(self):
        print(self.a.pop())
        
    def top(self):
        print()
    def size(self):
        print(len(self.a))
    def isEmpty(self):


obj = mystack()
