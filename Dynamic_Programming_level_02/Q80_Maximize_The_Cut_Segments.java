package Dynamic_Programming_level_02;

import java.util.*;

public class Q80_Maximize_The_Cut_Segments {
    
    public static void main(String[] args) {
        maximizeCut(4, 2, 1, 1);
    }

    public static int maximizeCut(int n , int x,  int y, int z) {
        
        int[] dp = new int[n+1] ;

        // dp[1] = 1 ;/
        
        Arrays.fill(dp,-1) ;
        dp[0]= 0  ;
        
        for(int i = 0 ; i <= n ; i++){
            
            if(dp[i] != -1){
                if(i+x <= n){
                    dp[i+x] = Math.max(dp[i+x],dp[i]+1) ;
                }
                
                if(i+y <= n){
                    dp[i+y] = Math.max(dp[i+y],dp[i]+1) ;
                }
                
                if(i+z <= n){
                    dp[i+z] = Math.max(dp[i+z],dp[i]+1) ;
                }
            }
        }

       return dp[n] == -1 ? 0 : dp[n];
    }
}
