#include  <iostream>
using namespace std;

class Phone {
public:
	string CompamyName;
	string Model;
};

int main()
{
	Phone Iphone;
	Iphone.CompamyName = "Iphone14pro";
	Iphone.Model = "14pro";
	

	cout << "Name: " << Iphone.CompamyName << endl;
	cout << "Model: " << Iphone.Model << endl;

    Phone Oppo;
    Oppo.CompamyName = " Oppo f17 pro ";
    Oppo.Model = " f17pro " ;

    cout << "Name: " << Oppo.CompamyName << endl;
    cout << "Model: " << Oppo.Model << endl;
    
return 0;
}