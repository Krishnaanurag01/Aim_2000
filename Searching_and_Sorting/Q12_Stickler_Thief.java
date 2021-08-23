package Searching_and_Sorting;

import java.util.Arrays;

public class Q12_Stickler_Thief {
    public static void main(String[] args) {
        int arr[] = {5,5,10,100,10,5};
        System.out.println(getMaximumLoot(arr));
   
   
    }

    public static int getMaximumLoot(int[] arr) {
    
        if(arr == null || arr.length == 0){
            return 0 ;
        }

        if(arr.length == 2){
            return Math.max(arr[0], arr[1]);
        }


       /// otherwise.

        // we'll make a dp array.

        int dp[] = new int[arr.length];
        dp[0] = arr[0] ; // means at this point thief can only stole money from house 0.
        dp[1] = Math.max(arr[0], arr[1]); // means thief can stole money where money is more.

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]) ; // this means as we can;t stole from adjecent houses so we'll check if we add current homes loot with the last of last house is greater or simply the last house money is greater ( as we can't stole from adjecent houses thats why not adding current house money )
        }

        return dp[dp.length-1] ;
    }
    
}
