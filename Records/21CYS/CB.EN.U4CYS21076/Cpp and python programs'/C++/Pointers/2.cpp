#include <iostream>
using namespace std;

class A {
  private:
  int P1;
  protected:
  int Aa;
  public:
  int Ab;
    A() {
        P1=100;
        Aa=10;
        Ab=20;
      cout << "Inside class A" << endl;
    }
    void display()
    {
       cout << "Value of private varaible P1 is " <<P1<< endl;
       cout << "Value of protected varaible Aa is " <<Aa<< endl;
       cout << "Value of public varaible Ab is " <<Ab<< endl;
    }
};

class B {
  private:
  int P2;
  protected:
  int Ba;
  public:
  int Bb;
    B() {
        P2=200;
        Ba=30;
        Bb=40;
      cout << "Inside class B" << endl;
    }
    void display()
    {
       cout << "Value of private varaible P2 is " <<P2<< endl;
       cout << "Value of protected varaible Ba is " <<Ba<< endl;
       cout << "Value of public varaible Bb is " <<Bb<< endl;
    }
};

class C {
  private:
  int P3;
  protected:
  int Ca;
  public:
  int Cb;
    C() {
        P3=300;
        Ca=30;
        Cb=40;
      cout << "Inside class C" << endl;
    }
    void display()
    {
       cout << "Value of private varaible P3 is " <<P3<< endl;
       cout << "Value of protected varaible Ca is " <<Ca<< endl;
       cout << "Value of public varaible Cb is " <<Cb<< endl;
    }
};

class D: public A, protected B, private C {
    public:
    D() {
      cout << "Inside class D" << endl;
    }
    void sum()
    {
        cout<<"Sum of all accessible attributes derived from base classes A,B and C is "<<Aa+Ab+Ba+Bb+Ca+Cb<<endl;
    }
    void display()
    {
       cout << "Private varaible P1 derived from class A not accessible in class D"<< endl;
       cout << "Protected varaible Aa derived from class A is protected in class D"<< endl;
       cout << "Public varaible Ab derived from class A is public in class D" << endl;
       
       cout << "Private varaible P2 derived from class B not accessible in class D"<< endl;
       cout << "Protected varaible Ba derived from class B is protected in class D"<< endl;
       cout << "Public varaible Bb derived from class B is protected in class D" << endl;
       
       cout << "Private varaible P3 derived from class C not accessible in class D"<< endl;
       cout << "Protected varaible Ca derived from class C is private in class D"<< endl;
       cout << "Public varaible Cb derived from class C is private in class D" << endl;
    }
};

int main() {
    A a;
    a.display();
    B b;
    b.display();
    C c;
    c.display();
    D d;
    d.display();
    d.sum();
    cout<<"Public varaible Ab derived from class A is public in class D and is allowed to access from Main() function "<< d.Ab<<endl;
    return 0;
}
/*
Inside class A
Value of private varaible P1 is 100
Value of protected varaible Aa is 10
Value of public varaible Ab is 20
Inside class B
Value of private varaible P2 is 200
Value of protected varaible Ba is 30
Value of public varaible Bb is 40
Inside class C
Value of private varaible P3 is 300
Value of protected varaible Ca is 30
Value of public varaible Cb is 40
Inside class A
Inside class B
Inside class C
Inside class D
Private varaible P1 derived from class A not accessible in class D
Protected varaible Aa derived from class A is protected in class D
Public varaible Ab derived from class A is public in class D
Private varaible P2 derived from class B not accessible in class D
Protected varaible Ba derived from class B is protected in class D
Public varaible Bb derived from class B is protected in class D
Private varaible P3 derived from class C not accessible in class D
Protected varaible Ca derived from class C is private in class D
Public varaible Cb derived from class C is private in class D
Sum of all accessible attributes derived from base classes A,B and C is 170
Public varaible Ab derived from class A is public in class D and is allowed to access from Main() function 20
*/



















