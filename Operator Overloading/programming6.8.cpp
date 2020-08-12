#include <iostream>

using namespace std;

class List;
class ListNode {
	friend class List;
	int data;
	ListNode* link;
	friend istream& operator >> (istream& is, ListNode& n);
	friend ostream& operator << (ostream& os, ListNode* n);
public:
	int getData();
	ListNode* getLink();
	void setLink(ListNode*);
};

class List {
	ListNode* first;
public:
	List() {
		first = NULL;
	}
	~List() {
	}
	friend istream& operator >> (istream& is, List& l);
	friend ostream& operator << (ostream& os, List& l);
};

int ListNode::getData()
{
	return data;
}


ListNode* ListNode::getLink()
{
	return link;
}

void ListNode::setLink(ListNode* l)
{
	link = l;
}

istream& operator >> (istream& is, List& l)
{
	ListNode* node = new ListNode;
	ListNode* p = l.first;
	cin >> *(node);

	if (p == NULL) {
		l.first = node;
		return is;
	}
	while (p->getLink()) {
		p = p->getLink();
	}
	p->setLink(node);

	return is;
}

istream& operator >> (istream& is, ListNode& n)
{
	cin >> n.data;
	n.link = NULL;
	return is;
}

ostream& operator << (ostream& os, List& l)
{
	cout << l.first;
	return os;
}

ostream& operator << (ostream& os, ListNode* n)
{
	ListNode* p = n;
	while (p) {
		cout << p->data << "->";
		p = p->link;
	}
	cout << "end" << endl;
	return os;
}

int main()
{
	List list;
	cout << "Insert node numbers: ";
	int num = 0;
	cin >> num;

	for (int i = 0; i < num; ++i)
		cin >> list;
	
	cout << list;

	return 0;
}