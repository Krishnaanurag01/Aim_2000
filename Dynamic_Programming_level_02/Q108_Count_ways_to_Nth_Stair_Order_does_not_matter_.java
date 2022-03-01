package Dynamic_Programming_level_02;

public class Q108_Count_ways_to_Nth_Stair_Order_does_not_matter_ {

    public long nthStair(int n)
    {
        int[] dp = new int[n+1] ;
        
        dp[0] = 1 ; // there is one way to move from 0 to 0 that is do nothing
        
        for(int i = 1 ; i <= 2 ; i++){ // now climbing one way at a time
            for(int j = i ; j < dp.length ; j++){
                int rem = dp[j - i] ;
                dp[j] += rem ;  // it can climb total rem times
            }
        }
        
        return dp[n] ;
    }
    
}
