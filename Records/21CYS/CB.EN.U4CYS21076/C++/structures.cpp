#include <iostream>
using namespace std;
struct student {
    char name [20];
    int age;
    float salary;
};

void print_strucuture(student);
int main()
{
    student a;

    cout << " Enter the name of the student " << endl;
    cin.get(a.name, 20);
    cout << " Enter the Age of the student " << endl;
    cin >> a.age;
    cout << " Enter the salary of the student " << endl;
    cin>> a.salary;

    print_strucuture(a);

    return 0;
}

void print_strucuture(student a){
    cout << " The name of the student is " << a.name << endl;
    cout << " The age of the student " << a.age << endl;
    cout << " The salary of the student " << a.salary << endl;
}