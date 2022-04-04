package Dynamic_Programming_extras;

public class Q15_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount+1] ; // for memoization
        
        int ans = helper(coins.length -1 , coins,amount,dp) ;
        System.out.println((int)1e9) ; 
        return ans == (int)1e9 ? -1 : ans; // if ans is infity then return -1.
    }
    
    int helper(int idx, int[] coins, int x, Integer[][] dp){
        if(x == 0) return 0 ;
        
        if(idx == 0 ){
            if(coins[idx] <= x && x % coins[idx] == 0) return x/coins[idx]; // base case if x is not sum then check if current element can combine to make x.
            
            return (int)1e9 ;// else infity
        }
        
        int notPicked = 0  +  helper(idx-1,coins,x,dp) ;
        
        if(dp[idx][x] != null) return dp[idx][x] ;
        
        int min = (int)1e9 ;
        if(coins[idx] <= x){
            // for(int i = 1 ; i * coins[idx] <= x ; i++ ){
            //     min = Math.min(min, i + helper(idx - 1, coins, x - (i*coins[idx]), dp )) ;
            // }
            
            // instead of running a loop better do this.
           min = 1 +  helper(idx,coins,x-coins[idx],dp) ; // when taking not reducing index becuase we have multiple supplies.
        }
            
        return dp[idx][x] = Math.min(notPicked,min) ;
    }


    // tabulations : 

    public int coinChange3(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length][amount+1] ;
        
        // applying base case in first row.
        for(int t = 0 ; t <= amount ; t++){
            if(t % coins[0] == 0 ) dp[0][t] = t /coins[0] ; // first row / applying base case here.
            else dp[0][t] =(int)1e9 ;
         }
        
        for(int i = 1 ; i < coins.length ; i++){
            for(int j = 0 ; j <= amount ; j++){
                
                 int notPicked = 0  +  dp[i-1][j]  ;
                 int picked = (int)1e9 ;
                 if(coins[i] <= j){
                 picked = 1 +  dp[i][j-coins[i]]; }
                 dp[i][j] = Math.min(notPicked,picked) ;
            }
        }
       return dp[coins.length-1][amount] == 1e9 ? -1 : dp[coins.length-1][amount] ;
    }

    // space optimized solution :

    public int coinChange4(int[] coins, int amount) {
        
        int[] prev = new int[amount+1] ; // holding previous row only
        
        // applying base case in first row.
        for(int t = 0 ; t <= amount ; t++){
            if(t % coins[0] == 0 ) prev[t] = t /coins[0] ; // first row / applying base case here.
            else prev[t] =(int)1e9 ;
         }
        
        for(int i = 1 ; i < coins.length ; i++){
             int[] curr = new int[amount+1] ; // current row answer will be stored here.
            for(int j = 0 ; j <= amount ; j++){
                
                 int notPicked = 0  +  prev[j]  ; //when not picked ask the previous row
                 int picked = (int)1e9 ;
                 if(coins[i] <= j){
                 picked = 1 +  curr[j-coins[i]]; }  // if picked ask the rem in the same row
                 curr[j] = Math.min(notPicked,picked) ;
            }
            prev = curr ; // now curr becomes prev
        }
       return prev[amount] == 1e9 ? -1 : prev[amount] ;
    }
}
