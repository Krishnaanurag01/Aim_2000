package Searching_and_Sorting;

import java.util.Scanner;

public class Q32_ROTI_Prata_SPOJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); // taking test cases

        for (int i = 0; i < testCases ; i++) {
            
            int prata = sc.nextInt(); // taking parata
            int chefCount = sc.nextInt(); // total numbers of chefs
            int[] chefs = new int[chefCount]; // making array of chefs where we can store rank of chefs

            for (int j = 0; j < chefs.length; j++) {
                chefs[j] = sc.nextInt(); //storing ranks.
            }
            getMinTime(chefs, prata, chefCount);
        }
    }

    public static void getMinTime(int[] chefs, int prata , int chefsCount) {

        int low = 0;
        int high = 10000007; // took the longest integer value as not able to find the max number so simply take higest number
        int ans = 0;
        
        while (low <= high) {

            int mid = low +(high-low)/2 ; // this is a calculated time.

            if(canCookInMidTime(chefs , prata , mid)){ // when we can make parata in mid time that means higher value than mid also make samee prata. so we find the min number in which we can make n prata (given) for this we reduced high to mid -1.
                high = mid - 1;
                ans = mid;
            }
            else{ // here finding larger values.
                low = mid + 1;
            }
            
        }
       System.out.println(ans);
        
    }

    private static boolean canCookInMidTime(int[] chefs, int prata, int mid) {

        int time = 0 ; // taking a time input so that we can comapre it with mid time.
        int calculatedPrata = 0; // this will help achieving making prata.

        for (int i = 0; i < chefs.length; i++) {
            time  = chefs[i]; // n rank means n min and 2n rank means 2 min . so take the first chef of n rank and made him make one prata in same rank time.
            int j = 2; // this will help in multiplying rank so that we can find corrent time. 

            while (time <= mid) { /// when calculated time is less than means we have alot of time to make prata.
                calculatedPrata++; // after makiing prata incremeting calculated prata count.
                time = time + (j*chefs[i]); // so on.
                j++;
            }

            if(calculatedPrata >= prata) return true; // when we make required prata then returning true.
            
        }// o\w false.
        return false ;
    }
}
