package com.tuyano.gradle;

public class AddMatrix {
    public static int[][] Add(int[][] a, int[][] b)
    {
        int row = a.length;
        int col = a[0].length;
        int result[][] = new int[row][col];

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                result[i][j] = a[i][j] + b[i][j];

        return result;
    }

    public static void Print(int[][] a)
    {
        int row = a.length;
        int col = a[0].length;

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(a[i][j] + " ");
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int A[][] = {{1, 2, 3}, {4, 5, 6}};
        int B[][] = {{1, 1, 1}, {1, 1, 1}};
        int C[][] = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int D[][] = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        Print(Add(A, B));
        Print(Add(C, D));
    }
}
