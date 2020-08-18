#include <iostream>
#define MAXNUM 20
using namespace std;

class Complex {
	friend class Stack;
	float real;
	float img;
public:
	Complex(float r, float i) {
		real = r;
		img = i;
	}
	Complex() {
		real = 0.0;
		img = 0.0;
	}
	friend ostream& operator<<(ostream& s, Complex& c);
};

class Stack {
	Complex line[MAXNUM];
	int number;
public:
	Stack() { number = 0; }
	void Push(Complex p);
	Complex Pop();
	friend ostream& operator<<(ostream& s, Stack& st);
};

void Stack::Push(Complex p)
{
	//line[number++] = p;

	if (number >= MAXNUM) {
		cout << "Stack Full" << endl;
		return;
	}
	line[number++] = p;
	cout << "Current Top is " << number << endl;
}

Complex Stack::Pop()
{
	//--number;
	//return line[number];

	if (number <= 0) {
		cout << "Stack Empty" << endl;
		return Complex(-1, -1);
	}
	cout << "Current Top is " << --number << endl;
	return line[number];
}

ostream& operator<<(ostream& os, Complex& c)
{

	os << c.real << ' ' << c.img;
	return os;
}

ostream& operator<<(ostream& os, Stack& st)
{
	for (int i = 0; i < st.number; ++i) {
		os << st.line[i] << endl;
	}
	return os;
}

int main()
{
	Stack s1;
	Complex c1(1.0, 2.0);
	Complex c2(3.0, 4.0);
	Complex c3(5.0, 6.0);

	s1.Push(c1);
	s1.Push(c2);
	s1.Push(c3);
	cout << s1 << endl;

	c1 = s1.Pop();
	c2 = s1.Pop();
	cout << s1 << endl;

	return 0;
}