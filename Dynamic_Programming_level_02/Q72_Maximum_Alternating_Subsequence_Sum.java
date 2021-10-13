package Dynamic_Programming_level_02;

import java.util.*;

public class Q72_Maximum_Alternating_Subsequence_Sum {

    public static void main(String[] args) {

        int[] nums = {2,3,5,6,1,6} ;

        long[][] dp = new long[nums.length][2];
        
        for(long[] subArr : dp){
            Arrays.fill(subArr,-1);
        }
        System.out.println( get_max_sum(0,nums,0,dp) ) ;
        
    }

    // using memoization.

    public static long get_max_sum(int idx , int[] nums , int evenOdd , long[][] dp ) {
        
        if(idx >= nums.length) return 0 ;

        if(dp[idx][evenOdd] != -1) return dp[idx][evenOdd] ;

        long ans = 0 ;
        long element = nums[idx] ;
        // this means if we add current index. and subtract odd value
        if(evenOdd == 0){
            // means even
            ans = get_max_sum(idx+1, nums, 1 , dp) + element ;
        }
        else{ // when odd
            ans = get_max_sum(idx+1, nums, 0 , dp) - element ;
        }

        ans = Math.max(ans, get_max_sum(idx+1, nums, evenOdd, dp)) ; // this means if we skip current index and start from next value so that we add odd index and sutract even index value.

        return dp[idx][evenOdd] = ans ;
    }


    // using tabulations.

    public static long get_max(int[] nums) {
        
        long[] endEven = new long[nums.length] ;
        long[] endOdd = new long[nums.length] ;

        endEven[0] = nums[0] ;
        for (int i = 1; i < nums.length; i++) {
            long current  = nums[i] ;
            endEven[i] = Math.max(endEven[i-1], endOdd[i-1]+current) ;
            endOdd[i] = Math.max(endOdd[i-1], endEven[i-1]- current) ;
        }

        return Math.max(endEven[nums.length-1], endOdd[nums.length-1]) ;
    }


    // same approch as above but with space o(1)
    
    public static long get_max2(int[] nums) {

        long endEven = 0 ;
        long endOdd = 0 ;

        endEven= nums[0] ;
        for (int i = 1; i < nums.length; i++) {
            long current  = nums[i] ;
            endEven = Math.max(endEven , endOdd +current) ;
            endOdd = Math.max(endOdd , endEven - current) ;
        }

        return Math.max(endEven , endOdd ) ;
        
    }
}
