#include <iostream>

using namespace std;

class Person {
	char* name;
public:
	Person(char* n): name(n) {}
	Person() { name = NULL;}
	int operator==(const Person& p) const {
		return strcmp(name, p.name);
	}
	char* Name() { return name; }
	Person& operator = (const Person& source) {
		name = new char[10];
		strcpy(name, source.name);
		return *this;
	}
};

class Queue {
	Person line[20];
	int number;
public:
	Queue() { number = 0; }
	void Push(Person p);
	Person Pop();
	int Number();

	friend ostream& operator <<(ostream& os, Queue& q);
	friend istream& operator >>(istream& is, Queue& q);

	Queue& operator= (const Queue& source);
	int operator==(Queue q2);
};

void Queue::Push(Person p)
{
	if (number >= 20) {
		cout << "Full of Queue" << endl;
		return;
	}
	line[number] = p;
	++number;
	cout << p.Name() << " has joined the Queue" << endl;
}

Person Queue::Pop()
{
	Person p = line[0];
	cout << p.Name() << " has left the queue" << endl;
	for (int i = 1; i < number; ++i) {
		line[i - 1] = line[i];
	}
	--number;
	return p;
}

int Queue::Number()
{
	return number;
}

ostream& operator <<(ostream& os, Queue& q)
{
	for (int i = 0; i < q.number; ++i) {
		os << q.line[i].Name() << " ";
	}
	return os;
}

istream& operator >>(istream& is, Queue& q)
{
	char* buf = new char[10];
	is >> buf;
	Person p1(buf);
	q.Push(p1);
	return is;
}

Queue& Queue::operator= (const Queue& source)
{
	number = source.number;
	for (int i = 0; i < source.number; ++i) {
		line[i] = source.line[i];
	}
	return *this;
}

int Queue::operator==(Queue q2)
{
	if (number != q2.number) {
		cout << "different" << endl;
	}
	int i;
	for (i = 0; i < q2.number && !(line[i] == q2.line[i]); ++i) ;
	if (i != q2.number) {
		cout << "different" << endl;
		return 1;
	}
	cout << "same" << endl;
	return 0;
}

int main()
{
	Queue q, q2;
	Person p1((char*)"AAA"), p2((char*)"BBB"), p3((char*)"CCC");
	q.Push(p1);
	q.Push(p2);
	q.Push(p3);
	q.Pop();

	cout << "\nInsert 3person's name: ";
	for (int i = 0; i < 3; ++i)
		cin >> q;
	cout << "\nq: " << q << endl;

	q2 = q;
	cout << "q2: " << q2 << endl;

	q == q2;

	q.Pop();
	q.Pop();
	q.Pop();
	q.Pop();
	cout << "\nq: " << q << endl;
	cout << "q2: " << q2 << endl;
	return 0;
}