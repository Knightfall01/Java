#include <iostream>

using namespace std;

class Base {
int x;
public:
Base()
{
cout << "Base\n";
}

Base(int i)
{
cout << "Base parameterized constructor "<<i<<"\n";
}

};

class Derived : public Base
{
int y;
public:
Derived():Base(30)
{
cout << "Derived constructor\n";
}
// parameterized constructor
Derived(int i):Base(20)
{
cout << "Derived parameterized constructor "<<i<<"\n";
}
};

int main() {
Base b1;
Base b2(20);
Derived d1;
Derived d2(10);
}
/*
Base
Base parameterized constructor 20
Base parameterized constructor 30
Derived constructor
Base parameterized constructor 20
Derived parameterized constructor 10
*/

