package Dynamic_Programming_extras;

public class Q18_Knapsack_with_Duplicate_Items {

    // using memoization.
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        Integer[][] dp = new Integer[N][W+1] ;
        return helper( N-1, val, wt, W,dp) ;
    }
    
    static int helper(int idx, int[] val, int[] wt, int cap, Integer[][] dp){
        if(cap == 0) return 0 ;
        if(idx == 0 ){
            
            int took = 0 ;
            if(wt[idx] <= cap ){
                took = val[idx] + helper(idx,val,wt,cap - wt[idx] , dp) ; // calling again with same index becuase there might be any chance that cap still some space left for same element.
            }
            return took > 0 ? took : 0 ; // returning the max
        }
        
        if(dp[idx][cap] != null) return dp[idx][cap] ; // returning if solved already
        
        int notTook = 0 + helper(idx-1,val,wt,cap,dp) ; // not taking current element
        int took = 0 ;
        if(wt[idx] <= cap){
            took = val[idx] + helper(idx,val,wt,cap - wt[idx],dp) ; //taking current element and calling again for same index.
        }
        
        return dp[idx][cap] = Math.max(took,notTook) ; // returning max
    }

    // tabulations.

    static int knapSack2(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W+1] ;
        
        for(int j = 0 ; j <= W ; j++){
            if(wt[0] <= j) // storing data of first row
            dp[0][j] =val[0] + dp[0][j - wt[0] ] ;
        }  
        
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j <= W ; j++){
                // same recurrence relation as memoization
                int notTook = 0 + dp[i-1][j] ;
                int took = 0 ;
                if(wt[i] <= j){
                    took = val[i] + dp[i][j - wt[i] ] ;
                }
                
                dp[i][j] = Math.max(notTook , took) ;
            }
        }
                
        return dp[N-1][W] ;
    }


    // space optimized solution : 

    static int knapSack3(int N, int W, int val[], int wt[])
    {
        // code here
        int[] prev = new int[W+1] ;
        
        for(int j = 0 ; j <= W ; j++){
            if(wt[0] <= j)
            prev[j] =val[0] + prev[j - wt[0] ] ;
        }  
        
        for(int i = 1 ; i < N ; i++){
         int[] curr = new int[W+1] ;
            for(int j = 0 ; j <= W ; j++){
                
                int notTook = 0 + prev[j] ;
                int took = 0 ;
                if(wt[i] <= j){
                    took = val[i] + curr[j - wt[i] ] ; // here we need current guy previous data that's why we used increasing jth loop in super optimal solution in below approch
                 }
                
                curr[j] = Math.max(notTook , took) ;
            }
            prev = curr ;
        }
    
        return prev[W] ;
    }


    // super optimal solution.
    // solution is just 1d array space.

    static int knapSack4(int N, int W, int val[], int wt[])
    {
        // code here
        int[] prev = new int[W+1] ;
        
        for(int j = 0 ; j <= W ; j++){
            if(wt[0] <= j)
            prev[j] =val[0] + prev[j - wt[0] ] ;
        }  
        
        for(int i = 1 ; i < N ; i++){
        //  int[] curr = new int[W+1] ;
            for(int j = 0 ; j <= W ; j++){
                
                int notTook = 0 + prev[j] ;
                int took = 0 ;
                if(wt[i] <= j){
                    took = val[i] + prev[j - wt[i] ] ;
                }
                
                prev[j] = Math.max(notTook , took) ;
            }
            // prev = curr ;
        }
    
        return prev[W] ;
    }
}
