package com.tuyano.gradle;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Vector;

public class Lotto {
    static ArrayList<ArrayList<Integer>> totalLotto = new ArrayList<ArrayList<Integer>>();
    static HashMap<String, ArrayList<Integer>> buyer = new HashMap<String, ArrayList<Integer>>();
    static ArrayList<Integer> firstNum = new ArrayList<Integer>();
    static int bonus;

    private static int lottocnt = 100;

    public static void Issue() {
        int n, i, j;

        Random r = new Random();

        for(i = 0; i < lottocnt; i++ ){
            ArrayList<Integer> lotto = new ArrayList<>();
            while(lotto.size() <= 6){     //draw 6 lotto number + bonus number
                n = r.nextInt(45) + 1;
                for(j = 0; j < lotto.size(); j++) {
                    if(lotto.get(j) == n)
                        break;
                }
                if(j == lotto.size()) {
                    lotto.add(n);
                }
            }
            lotto.add(0);
            totalLotto.add(lotto);
        }

        //print
        /*for(i = 0; i < lottocnt; i++) {
            System.out.printf(i + ": ");
            for(int k = 0; k < totalLotto.get(i).size(); k++)
                System.out.printf(String.valueOf(totalLotto.get(i).get(k)) + " ");
            System.out.println();
        }*/
    }

    public static void Buy(String phoneNum) {
        int cnt = 0;
        Random r = new Random();

        ArrayList<Integer> buyNum = new ArrayList<Integer>();
        while(cnt < 5) {
            int n = r.nextInt(lottocnt);
            if(totalLotto.get(n).get(7) == 0) {
                totalLotto.get(n).remove(7);
                totalLotto.get(n).add(1);
                buyNum.add(n);
                ++cnt;
            }
        }
        buyer.put(phoneNum, buyNum);
    }

    public static void Draw() {
        Random r = new Random();
        int n = r.nextInt(lottocnt);

        System.out.print("1st lotto number: ");
        for(int i = 0; i < 6; i++) {
            firstNum.add(totalLotto.get(n).get(i));
            System.out.print(firstNum.get(i) + " ");
        }
        bonus = totalLotto.get(n).get(6);
        System.out.println(bonus);
    }

    public static void Check(String phoneNum) {
        int equal = 0, bEqual = 0, money = 0, n = 0;
        String rank = "";
        ArrayList<Integer> myNum = buyer.get(phoneNum);
        for(int i = 0; i < 5; i++) {
            equal = 0;
            bEqual = 0;
            for(int j = 0; j < 6; j++) {
                for(int k = 0; k < 6; k++) {
                    n = myNum.get(i);
                    if(firstNum.get(j) == totalLotto.get(n).get(k))     ++equal;
                }
            }
            if(bonus == totalLotto.get(n).get(6))       bEqual++;

            // print own lotto number
            for(int k = 0; k < 7; k++)
                System.out.printf(totalLotto.get(n).get(k) + " ");
            System.out.println();

            if(equal == 6) {
                money = 1708363039;
                rank = "1st";
            }
            else if(equal == 5) {
                if(bEqual == 0) {
                    money = 1380110;
                    rank = "2nd";
                }
                else {
                    money = 55245571;
                    rank = "3rd";
                }
            }
            else if(equal == 4) {
                money = 50000;
                rank = "4nd";
            }
            else if(equal == 3) {
                money = 5000;
                rank = "5nd";
            }
            System.out.println("You are get " + money + " won!");
            System.out.println(rank + "\n");
        }
    }

    public static void main(String[] args) {
        Issue();
        Buy("010-9177-8547");
        Buy("010-0000-0001");
        Buy("010-0000-0002");
        Buy("010-0000-0003");
        Buy("010-0000-0004");
        Buy("010-0000-0005");
        Buy("010-0000-0006");
        Draw();
        Check("010-9177-8547");
    }
}
