#include <iostream>

using namespace std;

class Person {
	int pnumber;
	int* ref;
public:
	Person() {
		pnumber = 0;
		ref = &pnumber;
	}
	friend istream& operator >> (istream&, Person&);
	friend ostream& operator << (ostream&, Person&);
};

class Students {
	Person men;
	Person women;
public:
	Students() {};
	friend istream& operator >> (istream&, Students&);
	friend ostream& operator << (ostream&, Students&);
};

istream& operator >> (istream& is, Person& pers)
{
	is >> pers.pnumber;
	return is;
}

ostream& operator << (ostream& os, Person& pers)
{
	os << pers.pnumber;
	return os;
}

istream& operator >> (istream& is, Students& stud)
{
	cout << "men's number: ";
	is >> stud.men;
	cout << "women's number: ";
	is >> stud.women;
	return is;
}

ostream& operator << (ostream& os, Students& stud)
{
	os << "men: " << stud.men << endl;
	os << "women: " << stud.women << endl;
	return os;
}

int main()
{
	Students s;
	cin >> s;
	cout << s;

	return 0;
}