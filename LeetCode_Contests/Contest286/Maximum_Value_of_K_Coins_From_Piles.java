package LeetCode_Contests.Contest286;
import java.util.*;

public class Maximum_Value_of_K_Coins_From_Piles {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        Integer[][] dp = new Integer[piles.size() + 1][k+1] ; // making dp array
        return helper(piles,0,k,dp);
    }
    
    public int helper(List<List<Integer>> piles,int idx, int k, Integer[][] dp){
        
        if(idx >= piles.size() || k <= 0) return  0 ; // boundry conditions.
        
        if(dp[idx][k] != null ) // if already solved then return.
            return dp[idx][k] ;
        
        // now taking 0 to k int from current pile
        
        int whenTookZero = helper(piles, idx + 1 , k , dp ); // if taking 0(not taking anything) from current pile.
        
        int max = whenTookZero ;
        
        // if taking 1 to k.
        int sum = 0 ;
        
        for(int i = 0 ; i < k && i < piles.get(idx).size() ; i++){
            int val = piles.get(idx).get(i) ;
            sum += val ;
            // means took i+1 int from current piles and finding rest from other piles.
            max = Math.max(max,sum + helper(piles, idx+1, k - (i+1), dp )  ) ;
        }
        
        dp[idx][k] = max ;
        
        return max ;
        
    }
    
}
