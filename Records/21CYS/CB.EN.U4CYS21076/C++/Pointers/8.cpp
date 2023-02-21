#include <iostream>
using namespace std;

class Base {
   public:
    void print() {
        cout << "Base Function" << endl;
    }
};

class Derived : public Base {
   public:
    void print() {
       cout << "Derived Function" << endl;
       Base::print(); 
    }
};

int main() {
    Derived derived1, derived2;
    derived1.print();
    derived2.Base::print();
    
    Base* ptr1 = &derived1;
    ptr1->print();
    
    Derived* ptr2 = &derived1;
    ptr2->print();

    return 0;
}