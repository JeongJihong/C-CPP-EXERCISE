package com.tuyano.gradle;

class Node {
    public int num;
    public Node next;

    Node() {
        this.num = 0;
        this.next = null;
    }

    Node(int n) {
        this.num = n;
        this.next = null;
    }
}

class List {
    public Node first;
    public List() {first = null;}
    public List(int m) {first = new Node(m);}
    public List(List a) {first = a.first;}

    public void AddNode(int data) {
        Node node = new Node(data);
        if(first == null) {
            first = node;
            return ;
        }
        Node p = first;
        while(p.next != null) {
            p = p.next;
        }
        p.next = node;
    }

    public void AddList(List b) {
        Node p = this.first;
        while(p.next != null){
            p = p.next;
        }
        p.next = b.first;
    }

    public void ShowList() {
        Node p;
        p = first;

        while(p != null) {
            System.out.print(p.num + " ");
            p = p.next;
        }
        System.out.println();
    }

    public int Length()
    {
        Node p;
        p = first;

        int cnt = 0;
        while(p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void SimpleSplit(List b)
    {
        int n = this.Length();
        Node p = this.first;

        int left = n / 2;

        for(int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        b.first = p.next;
        p.next = null;
    }

    public void SimpleMerge(List b)
    {
        Node p = this.first, q = b.first;
        List l;
        if (p.num > q.num) {
            l = new List(q.num);
            q = q.next;
        } else {
            l = new List(p.num);
            p = p.next;
        }

        while(p != null && q != null) {
            if(p.num > q.num) {
                l.AddNode(q.num);
                q = q.next;
            }
            else {
                l.AddNode(p.num);
                p = p.next;
            }
        }

        if(p == null) {
            while(q != null) {
                l.AddNode(q.num);
                q = q.next;
            }
        }
        if(q == null) {
            while(p != null) {
                l.AddNode(p.num);
                p = p.next;
            }
        }

        this.first = l.first;
    }

    public void Sort(List c) {
        Node p = this.first, q = c.first;
        List l;
        if (p.num > q.num) {
            l = new List(q.num);
            q = q.next;
        } else {
            l = new List(p.num);
            p = p.next;
        }

        while(p != null && q != null) {
            if(p.num > q.num) {
                l.AddNode(q.num);
                q = q.next;
            }
            else {
                l.AddNode(p.num);
                p = p.next;
            }
        }

        if(p == null) {
            while(q != null) {
                l.AddNode(q.num);
                q = q.next;
            }
        }
        if(q == null) {
            while(p != null) {
                l.AddNode(p.num);
                p = p.next;
            }
        }
        this.first = l.first;
    }
}

public class ListIterator {
    private List list;
    private Node current;
    public ListIterator(List l) {
        list = l;
        current = l.first;
    }

    public boolean NotNull() {
        return !(current == null);
    }

    public boolean NextNotNull() {
        return !(current.next == null);
    }

    public int First() {
        return list.first.num;
    }

    public int Next() {
        current = current.next;
        return current.num;
    }
    public static void MakeList(List a, int num) {
        int rnum;
        for(int i = 0; i < num; i++) {
            rnum = (int)(Math.random() * 20);
            a.AddNode(rnum);
        }
    }

    public static int Sum(List a) {
        ListIterator li = new ListIterator(a);
        int sum = li.First();
        while(li.NextNotNull()) {
            sum += li.Next();
        }
        return sum;
    }

    public static int Max(List a) {
        ListIterator li = new ListIterator(a);
        int max = li.First();
        while(li.NextNotNull()) {
            if(max < li.Next()) {
                max = li.current.num;
            }
        }
        return max;
    }

    public static void Split(List[] l)
    {
        int j = 1;
        int n = l[0].Length();
        while(true) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if(l[i].Length() > 1)
                    ++cnt;
            }
            if(cnt == 0)
                break;

            int times = 0;
            for(int i = 0; i < n; i++) {
                if(cnt > times && l[i].Length() > 1) {
                    l[i].SimpleSplit(l[j++]);
                    ++times;
                }
            }
        }
    }

    public static List Merge(List[] l, int n)
    {
        int p = 1;
        while(l[0].Length() != n) {
            for(int i = 0; i < n; i += p) {
                if(i + p < n) {
                    l[i].SimpleMerge(l[i+p]);
                    i += p;
                }
            }
            p *= 2;
        }
        return l[0];
    }

    public static void main(String[] args) {
        List a1 = new List();
        List a2 = new List();
        MakeList(a1, 3);
        MakeList(a2, 4);
        a1.ShowList();
        a2.ShowList();

        //System.out.println("sum: " + Sum(a1));
        //System.out.println("max: " + Max(a1));

        a1.AddList(a2);
        int n = a1.Length();        //Make List Array
        List l[] = new List[n];
        for(int i = 0; i < n; i++)
            l[i] = new List();
        l[0] = a1;

        Split(l);
        List res = Merge(l, n);
        res.ShowList();
    }
}