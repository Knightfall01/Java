class mystack():
    def __init__(self):
        self.a=[]
        self.t=-1
    def push(self,value):
        self.a[self.t+1]=value
        self.t=self.t+1
    def pop(self):
        self.a.pop()
    def top(self):
        print(self.a[self.t+1])
    def size(self):
        print(len(self.a))

