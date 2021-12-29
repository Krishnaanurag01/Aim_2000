package Greedy;

import java.util.Arrays;

public class Q6_Number_of_Coins {
    
    public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    int[] dp = new int[V+1] ;
	    
	    Arrays.fill(dp,Integer.MAX_VALUE) ;
	    dp[0] = 0 ;
	    
	    
	    for(int i = 1 ; i <= V ; i++){
	        
	        for(int j = 0 ; j < coins.length ; j++){
	            
	            if(coins[j] <= i ) {
	                
	                int rest = dp[ i - coins[j] ] ;
	                
	                if( rest != Integer.MAX_VALUE &&  rest + 1 < dp[i] ){
	                    dp[i] = 1 + rest ;
	                }
	            }
	        }
	        
	    }
	    
	    
	    if( dp[V] == Integer.MAX_VALUE ){
	        return -1 ;
	    }
	    
	    
	    return dp[V] ;
	} 
}
