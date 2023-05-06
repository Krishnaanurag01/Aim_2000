package Problem_Of_The_day;
import java.util.*;

public class Q399_Another_Coin_Change_Problem {
    
    static Boolean[][] dp ;
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        
        dp = new Boolean[target+1][K+1];
        Arrays.sort(coins);
        
        return helper(target, coins, K, N-1) ;
    }
    
    static boolean helper(int target, int[] coins, int K, int idx){
        
        
        if(target == 0 && K == 0) return true;
        
        
        if(target == 0){
            return false;
        }
        if( K <= 0 ) return false ;
        if(idx < 0) return false;
        
        if(dp[target][K] != null) return dp[target][K];
        
        
        
        
        if(coins[idx] <= target){
          
          for(int i = 1; i * coins[idx] <= target ; i++){
           
              if(helper(target - (i*coins[idx]),coins, K-i, idx-1)) return dp[target][K] = true;
          }  
           
        }
        
        if(helper(target, coins, K, idx-1)) return dp[target][K] = true ;
        
        return dp[target][K] = false;
    }
}
