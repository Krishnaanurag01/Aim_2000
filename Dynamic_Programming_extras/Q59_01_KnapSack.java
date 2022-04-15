package Dynamic_Programming_extras;

public class Q59_01_KnapSack {

    // tabulations : O(n2) space.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        int[][] dp = new int[wt.length+1][W+1] ;
        int max = 0 ;
        
        for(int i = 1 ; i <= wt.length ; i++){
            for(int j = 0 ; j <= W ; j++){
        
                int take = 0 ; 
                int notTake = dp[i-1][j];
        
                if(wt[i-1] <= j){
                     take = val[i-1] + dp[i-1][j - wt[i-1]];
                }
                
                dp[i][j] = Math.max(take, notTake) ;
                max = Math.max(max,dp[i][j]) ;
            }
        }

        return max;
    } 
    

    // space optimized tabulations : O(n)
    static int knapSack2(int W, int wt[], int val[], int n) 
    { 
        
        int[] dp = new int[W+1] ;
        int max = 0 ;
        
        for(int i = 1 ; i <= wt.length ; i++){
            int[] curr = new int[W+1] ;
            for(int j = 0 ; j <= W ; j++){
        
                int take = 0 ; 
                int notTake = dp[j];
        
                if(wt[i-1] <= j){
                     take = val[i-1] + dp[j - wt[i-1]];
                }
                
                curr[j] = Math.max(take, notTake) ;
                max = Math.max(max,curr[j]) ;
            }
            dp = curr ;
        }

        return max;
    }
    
    // memoization.

    // static int helper(int idx, int[] val, int[] wt, int cap){
        
    //     if(idx == -1) return 0 ;
    //     if(dp[idx][cap] != null) return dp[idx][cap] ;
    //     int take = 0 ;
    //     int notTake = helper(idx-1, val, wt, cap);
        
    //     if(wt[idx] <= cap){
    //         take = val[idx] + helper(idx-1, val, wt, cap - wt[idx]);
    //     }
        
    //     return dp[idx][cap] = Math.max(take, notTake) ;
    // }
}
