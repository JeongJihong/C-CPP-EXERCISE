package com.tuyano.gradle;

import java.util.Random;

public class WormMatrix {
    public static void main(String[] args) {
        Random rand = new Random();
        int mat[][] = new int[8][8];
        int x, y, move, cnt = 0;
        boolean flag = true;
        for(int i = 0; i < 8; i++)         //initialize
            for(int j = 0; j < 8; j++)
                mat[i][j] = 0;

        x = rand.nextInt(8);
        y = rand.nextInt(8);
        mat[x][y] += 1;
        System.out.println("start location: " + x + ", " + y);

        while(true) {
            flag = true;
            cnt = 0;
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(mat[i][j] > 0)
                        ++cnt;
                    else {
                        flag = false;
                        break;
                    }
                }
                if(flag == false)
                    break;
            }

            if(cnt >= 64) {
                for(int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++)
                        System.out.printf("%-2d ", mat[i][j]);
                    System.out.print("\n");
                }
                break;
            }

            move = rand.nextInt(8);
            switch (move) {
                case 0:
                    if(y < 7)    y++;
                    break;
                case 1:
                    if(x < 7 && y < 7) { x++;y++; }
                    break;
                case 2:
                    if(x < 7)    x++;
                    break;
                case 3:
                    if(x < 7 && y > 0) { x++;y--; }
                    break;
                case 4:
                    if(y > 0)    y--;
                    break;
                case 5:
                    if(x > 0 && y > 0) { x--;y--; }
                    break;
                case 6:
                    if(x > 0)    x--;
                    break;
                case 7:
                    if(x > 0 && y < 7) { x--;y++; }
                    break;
            }
            mat[x][y] += 1;
        }
    }
}
