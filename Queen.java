package com.tuyano.gradle;

class Point {
    int x;
    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

interface Interface {
    int Size();
    boolean IsEmpty();
    boolean IsFull();
    void Push(Point p);
    void Pop();
}

class Stack implements Interface{
    int top;
    int size;
    Point[] data;

    public Stack(int n) {
        top = -1;
        size = n;
        data = new Point[n];
        for(int i = 0; i < n; i++)
            data[i] = new Point();
    }

    public int Size() {
        return top + 1;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return top == size - 1;
    }

    public Point Top() {
        return data[top];
    }

    public void Push(Point p) {
        if(IsFull())
            System.out.println("Full Stack!");
        else {
            ++top;
            data[top].x = p.x;
            data[top].y = p.y;
        }
    }

    public void Pop() {
        if(IsEmpty())
            System.out.println("Empty Stack!");
        else {
            top--;
        }
    }
}

public class Queen {
    private static int nSize = 8;
    private static int[][] board = new int[nSize][nSize];

    public static int EightQueen(int size)
    {
        int board[] = new int[size];
        int s = 0, k = 0;
        int cnt = 0;
        while(true) {
            if(k == size) {
                if(s == 0) break;
                k = board[--s] + 1;
                continue;
            }
            int j;
            for(j = 0; j < s; j++) {
                if( board[j] == k || Math.abs(k - board[j]) == s - j) break;
            }
            if(j < s) k++;
            else if (s == size - 1) {
                cnt++;
                k = board[--s] + 1;
            }
            else {
                board[s++] = k;
                k = 0;
            }
        }
        return cnt;
    }

    public static void Print() {
        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < nSize; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void BoardInit() {
        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < nSize; j++)
                board[i][j] = 0;
        }
    }

    public static boolean CheckMove(int currentRow, int col) {
        int i = 0;
        for(i = 0; i < currentRow; i++) {               //check column
            if(board[i][col] == 1)    return false;
        }

        i = 1;
        while(currentRow - i >= 0 && col - i >= 0) {      //check left diagonal
            if(board[currentRow - i][col - i] == 1)     return false;
            ++i;
        }

        i = 1;
        while(currentRow - i >= 0 && col + i < nSize) {      //check right diagonal
            if(board[currentRow - i][col + i] == 1)     return false;
            ++i;
        }
        return true;
    }

    public static void SolveQueen()
    {
        for(int col = 0; col < nSize; col++) {
            int r = 0, c = 0;
            int x = 0, y = 0;
            boolean flag = false;

            Stack mystack = new Stack(nSize);
            BoardInit();
            mystack.Push(new Point(0, col));
            board[0][col] = 1;

            while(r < nSize) {
                if(r == nSize - 1) {
                    Print();
                    break;
                }

                c = 0;
                if (flag == true) {
                    r = x - 1;
                    c = y + 1;
                }
                flag = false;
                if(c < nSize && CheckMove(r+1, c)) {
                    mystack.Push(new Point(++r, c));
                    board[r][c] = 1;
                }
                else {
                    while(c < nSize && !CheckMove(r+1, c))
                        ++c;
                    if(c >= nSize) {
                        x = mystack.Top().x;
                        y = mystack.Top().y;
                        board[x][y] = 0;
                        mystack.Pop();
                        --r;
                        flag = true;
                    }
                    else if(CheckMove(r+1, c)) {
                        mystack.Push(new Point(++r, c));
                        board[r][c] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveQueen();
    }
}