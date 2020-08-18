#include <iostream>

using namespace std;

class Person {
	int p;
	const char* pname;
public:
	Person();
	friend ostream& operator << (ostream&, Person&);
};

class Student {
	int s;
	Person* p;
public:
	Student();
	friend ostream& operator << (ostream&, Student&);
};

Person::Person()
{
	p = 0;
	pname = "AAA";
}

Student::Student()
{
	s = 1;
	p = new Person;
}

ostream& operator << (ostream& os, Person& pers)
{
	os << "Name: " << pers.pname << endl;
	return os;
}

ostream& operator << (ostream& os, Student& stud)
{
	os << *(stud.p);
	return os;
}

int main()
{
	Student s;
	cout << s;

	return 0;
}