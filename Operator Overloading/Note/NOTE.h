#include <iostream>
#include <string>
using namespace std;

class Note;
class NoteImpl {
	friend Note;
	int pitch;
	int duration;
public:
	NoteImpl() {
		pitch = 0;
		duration = 0;
	}
	NoteImpl(int p, int d) {
		pitch = p;
		duration = d;
	}
	void Sound() {
		cout << "Sound(): pitch = " << pitch << ", duration = " << duration << endl;
	}
	void setPitch(int p) {
		pitch = p;
	}
	void setDuration(int d) {
		duration = d;
	}
};

class Note {
	class NoteImpl* ni;
public:
	Note() {
		ni = new NoteImpl();
	}
	Note(int pitch, int duration) {
		ni = new NoteImpl(pitch, duration);
	}
	Note(const Note& n) {	//copy constructor
		ni = new NoteImpl();
		*ni = *(n.ni);
		cout << "복사 생성자" << endl;
	}

	void Sound() {
		ni->Sound();
	}
	void Increase(int delta) {
		ni->pitch += delta;
	}
	void Modulate(int cycles) {
		for (int i = 0; i < cycles; ++i) {
			ni->pitch++;
			ni->duration = 1 + i % 2;
			ni->Sound();
		}
	}
	friend ostream& operator << (ostream& os, Note& n);
	friend istream& operator >> (istream& is, Note& n);

	Note& operator++();		//Prefix operator, Increase pitch
	Note& operator++(int);	//Postfix operator, Increase duration
	Note& operator= (Note& n);
};

ostream& operator<<(ostream& os, Note& n)
{
	n.Sound();
	return os;
}

istream& operator>>(istream& is, Note& n)
{
	int pitch, duration;
	is >> pitch >> duration;
	n.ni->setPitch(pitch);
	n.ni->setDuration(duration);
	return is;
}

Note& Note::operator++()
{
	ni->pitch++;
	return *this;
}

Note& Note::operator++(int)
{
	ni->duration++;
	return *this;
}

Note& Note::operator= (Note& n)
{
	ni = new NoteImpl();
	*ni = *(n.ni);
	cout << "대입 연산" << endl;
	return *this;
}