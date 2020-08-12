#include "NOTE.h"

int main()
{
	//Note n(5, 32);
	Note n;
	Note n1;

	cin >> n;
	++n, n++;

	n1 = n;
	Note n2 = n;
	cout << "n1 " << n1 << endl;
	cout << "n2 " << n2 << endl;
	//n.Sound();
	//n.Increase(5);
	//n.Sound();
	//n.Modulate(50);
	cout << "Press the button to end the program" << endl;

	return 0;
}