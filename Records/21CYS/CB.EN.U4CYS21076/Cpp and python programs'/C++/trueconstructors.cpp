#include <iostream>
using namespace std;
class Point{
    double x;
    double y;
public:
    Point() { x = 0; y = 0; 
    cout << " default" << endl;}
    Point (double X, double Y) { x = X; y = Y; 
    cout << " Parameterized Point" << endl;}
    Point ( Point& rhs) { x = rhs.x ; y = rhs.y; }
};
int main() {
    Point p1;
    Point p2(2.3, 3.1);
    Point p3 = p1;
}
