package Searching_and_Sorting ;

import java.io.*;
import java.util.Scanner;


/**
 * Q19_Bishu_and_Soldiers
 */
public class Q19_Bishu_and_Soldiers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfSoldiers = sc.nextInt();
        int[] soldiersPower = new int[numberOfSoldiers];
        for (int i = 0; i < numberOfSoldiers; i++) {
            soldiersPower[i] = sc.nextInt();
        }

        int Rounds = sc.nextInt();
        for (int i = 0; i < Rounds ; i++) {
            int bishusPower = sc.nextInt();
            int[] result = getResultOfFight(soldiersPower, numberOfSoldiers , bishusPower);

            for (int j : result) {
                System.out.print(j+" ");
            }

            System.out.println();
        }
        sc.close();
    }

    public static int[] getResultOfFight(int[] soldiersPower , int soldiers , int bishusPower) {

        int[] result = new int[2];
        int totalSoldiersBeaten = 0 ;
        int totalStrength = 0 ;

        for (int i = 0; i < soldiersPower.length ; i++) {
            if(soldiersPower[i] <= bishusPower){
                totalSoldiersBeaten++;
                totalStrength += soldiersPower[i] ;
            }
        }

        result[0] = totalSoldiersBeaten;
        result[1] = totalStrength;
        return result ;
    }
    
}


// 7
// 1 2 3 4 5 6 7
// 3
// 3
// 10
// 2