#include <iostream>

using namespace std;
class Triangle
{
  private:
    int h;
    int b;
    float a;
    char name[10];
    float Area()
    {    a=0.5*h*b;
        return(a);
    }
    
    void printing();
    
  public:
  
  Triangle()
    {
        h=2;
        b=7;
    }
    
    Triangle(const Triangle &O)
    {
        h=O.h;
        b=O.b;
    }
    
    Triangle(int x,int y)
    {
        h=x;
        b=y;
    }
   void read()
   {
       cout<<"Read name"<<endl;
       cin>>name;
       cout<<"Read height"<<endl;
       cin>>h;
       cout<<"Read breadth"<<endl;
       cin>>b;
   }
   float display()
   {
    return(Area());   
   }
   void compare(Triangle);
   void Add(Triangle t1,Triangle t2)
   {
       cout<<"Total Area"<<t1.Area()+t2.Area()<<endl;
   }
   
   void tAdd(Triangle t1)
   {
       this->a=this->a+t1.a;
       cout<<"Total Area"<<this->a<<endl;
       printing();
   }
};

void Triangle::printing()
    {
        cout<<"Printing"<<endl;
    }

void Triangle::compare(Triangle t)
   {
       if(this->Area()>t.Area())
       {cout<<this->name <<"is greater than"<< t.name<<endl;}
       else if((this->Area()<t.Area()))
       {cout<<this->name<< "is less than" <<t.name<<endl;}
       else
       cout<<this->name<<" is equal to" <<t.name<<endl<<"ok compleated";
   }

int main()
{
    Triangle T[2],F,C,X(10,20),M=X;
    Triangle N = Triangle(20,30);
    for(int i=0;i<2;i++)
    {
    T[i].read();
    cout<<T[i].display();
    cout<<endl;
    }
    T[0].compare(T[1]);
    F.Add(T[0],T[1]);
    T[0].tAdd(T[1]);
    cout<<endl;
    cout<<C.display()<<endl;
    cout<<X.display()<<endl;
    cout<<N.display()<<endl;
    cout<<M.display()<<endl;
    return 0;
}
