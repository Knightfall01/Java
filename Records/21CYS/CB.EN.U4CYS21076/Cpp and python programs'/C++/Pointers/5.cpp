

#include <iostream>

using namespace std;

class Data
{ 
public:
int f(int a) 
{ 
return (a+1); 
}
};

int main()
{
// Only Declaration
int (Data::*fp1) (int);
// Assignment inside main()
fp1 = &Data::f;
  Data obj1;
  cout<<(obj1.*fp1)(10)<<"\n";
  Data* p1=&obj1;
  cout<<(p1->*fp1)(20)<<"\n";
 
 // Declaration and assignment
int (Data::*fp2) (int) = &Data::f;
Data obj2;
  cout<<(obj2.*fp2)(30)<<"\n";
  Data* p2=&obj2;
  cout<<(p2->*fp2)(40)<<"\n";
 
}

/*
11
21
31
41
*/