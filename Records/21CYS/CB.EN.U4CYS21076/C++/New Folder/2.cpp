#include <iostream>
using namespace std;
int main()
{
 int a[10], b[10],c[10];
 int i, j,k;
 for (i = 0; i < 10; i++)
 {

    cin >> a[i];
    cout << " Enter the elements of the matrix " ;
 }
 for (i = 0; i < 10; i++)
 {
    cin >> b[i];
 }
 c[9] = a[10] + b[10];
 for (k = 0; k < 10; k++)
 {
   cout << c[k];
   cin >> "\n" ;
 }
}
