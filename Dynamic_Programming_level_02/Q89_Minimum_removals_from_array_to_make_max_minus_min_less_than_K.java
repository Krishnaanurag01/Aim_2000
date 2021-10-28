package Dynamic_Programming_level_02;

import java.util.Arrays;
import java.util.Scanner;

public class Q89_Minimum_removals_from_array_to_make_max_minus_min_less_than_K {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[sc.nextInt()] ;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt() ;
        }

        System.out.println(get_min_removal(arr, sc.nextInt()));

        sc.close(); 
        
    }


    // this will take : time = o(nlogn)
    //                  space = o(n2)

    public static int get_min_removal(int[] arr , int k ) {
        
       if(arr.length == 1){ // when array has only one element then min and max is the same number so difference is 0 so we don't have to delete anything. so simply return 0 which means we'll remove zero elements
           return 0 ;
       }

       int i = 0 ; // starting index
       int j = arr.length-1 ; // last index
       Integer[][] dp = new Integer[1001][1001]; // made an integer array which null value by default
       
       Arrays.sort(arr); // now sort the original array
 
       return solve(arr,i,j,k,dp) ; // sending for memoization
    }


    private static int solve(int[] arr, int i, int j, int k, Integer[][] dp) {
       
        if (i >= j) { // the moment i  becomes equal to j or greater then return 0 as we can't delete anything now
            return 0 ;
        }
        if( arr[j] - arr[i] <= k){ // or the difference is less than equals to k then we don't have to delete anything so return 0
            return 0 ;
        }

        if(dp[i][j] != null){ // checking if value is previously solved 
            return dp[i][j] ;
        }

        return dp[i][j] = 1 + Math.min(solve(arr, i+1, j, k, dp), solve(arr, i, j-1, k, dp)) ; // adding 1 denotes we are deleting one element either from start or from last and solving answer for both and storing min the dp array.
    }
}
