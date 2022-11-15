package LeetCode_Contests.BiWeekly_91;

public class Q2_Count_Ways_To_Build_Good_Strings {
 
     
    int mod = (int)1e9+7 ;
    Integer[] dp ;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        dp = new Integer[high + 1] ;
        return helper(0,low,high,zero,one) ;
    }
    
    // initially the good string size is 0
    int helper(int size, int low, int high, int zero, int one){
        int count = 0 ;
        // if solved before then return answer.
        if(dp[size] != null) return dp[size] ;
            
        // if we can add zero then add it and get the answer
        if(size + zero <= high){
            count = (count + helper(size + zero, low, high, zero, one)) % mod ;
        }
        
        // if we can add one then add it and get the answer.
        if(size + one <= high){
            count = (count + helper(size + one, low, high, zero, one)) % mod ;
        }
        
        // now if size is in the range then add 1 count.
        if(size >= low ){
            count = (count + 1) % mod ;
        }
        
        return dp[size] = count ;
    }
}
