package com.tuyano.gradle;

import java.util.Random;

public class WormMatrix2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int A[][] = new int[8][8];
        boolean B[][] = new boolean[10][10];
        int x, y, i, j;

        for(int r = 0; r < 8; r++)         //A initialize
            for(int c = 0; c < 8; c++)
                A[r][c] = 0;

        for(int r = 0; r < 10; r++)         //B initialize
            for(int c = 0; c < 10; c++) {
                if(r == 0 || c == 0 || r == 9 || c == 9)
                    B[r][c] = false;
                else
                    B[r][c] = true;
            }

        int offsetRow[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int offsetCol[] = {-1, -1, 0, 1, 1, 1, 0, -1};

        x = rand.nextInt(8);
        y = rand.nextInt(8);
        A[x][y] += 1;
        System.out.println("start location: " + x + ", " + y);

        int cnt;
        boolean flag = false;

        while(!flag) {
            flag = true;

            for(int r = 0; r < 8; r++) {
                for(int c = 0; c < 8; c++) {
                    if (A[r][c] == 0)
                        flag = false;
                }
            }

            int d = rand.nextInt(8);
            i = x + offsetRow[d];
            j = y + offsetCol[d];

            if(B[i + 1][j + 1] == true) {
                A[i][j] += 1;
                x = i;
                y = j;
            }

            if(flag) {
                for(int r = 0; r < 8; r++) {
                    for(int c = 0; c < 8; c++) {
                        System.out.printf("%-2d ", A[r][c]);
                    }
                    System.out.print("\n");
                }
            }
        }
    }
}
