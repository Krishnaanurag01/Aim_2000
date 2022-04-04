package Dynamic_Programming_extras ;

public class Q14_01_Knapsack {


    // using memoization.
 
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        Integer[][] dp = new Integer[n][maxWeight+1] ;
        return helper(n-1, maxWeight, weight,value,dp) ;
    }
    
    static int helper(int idx, int cap, int[] wt, int[] val, Integer[][] dp){
        
        if(idx == 0){
            if(wt[idx] <= cap) return val[idx] ;
            return 0 ;
        }
        
        if(dp[idx][cap] != null) return dp[idx][cap] ; // returning if already solved
        
        int notPicked = helper(idx-1,cap,wt,val,dp) ;
        int picked = (int)-1e9 ;
        if(wt[idx] <= cap)
            picked = val[idx] + helper(idx-1, cap - wt[idx], wt,val, dp ) ;
        
        return dp[idx][cap] = Math.max(notPicked,picked) ;      
    }



    // using tabulation : 

    static int knapsack2(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1] ;
        
        // filling the 0th value if 0th wight is less than maxweight
        for(int w = weight[0] ; w <= maxWeight ;  w++){ dp[0][w] = value[0] ;}
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= maxWeight ; j++){
                
                // same recurrence
                int notPicked =  dp[i - 1][j] ;
                int picked = (int)-1e8 ;
                if(weight[i] <= j)
                    picked = value[i] + dp[i-1][j - weight[i]] ;
                
                dp[i][j] = Math.max(notPicked,picked) ;
            }
        }
        
        return dp[n-1][maxWeight] ;
    }

    // space optimized solution : take O(2*maxweight) space

    static int knapsack4(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1] ; // holds previous row data
        
        // storing value of first weight
        for(int w = weight[0] ; w <= maxWeight ;  w++){ prev[w] = value[0] ;}
        
        for(int i = 1 ; i < n ; i++){
        int[] curr = new int[maxWeight+1] ; // store answer of current row
            
            for(int j = 0 ; j <= maxWeight ; j++){
                
                int notPicked =  prev[j] ;
                int picked = (int)-1e9 ;
                if(weight[i] <= j)
                    picked = value[i] + prev[j - weight[i]] ;  // here we need prev guy data that's why we revered the jth loop in super optimal soltion below
                
                curr[j] = Math.max(notPicked,picked) ;
            }
            prev = curr ;
        }
        
        return prev[maxWeight] ;
    }



    // super space optimized solution : 
    // takes only O( maxWeight ) space.

    static int knapsack5(int[] weight, int[] value, int n, int maxWeight) {

        int[] prev = new int[maxWeight+1] ; // we will store and update in this array only
//         int[] curr = new int[maxWeight+1] ;
        
        for(int w = weight[0] ; w <= maxWeight ;  w++){ prev[w] = value[0] ;}
        
        for(int i = 1 ; i < n ; i++){
            
            for(int j = maxWeight ; j >= 0 ; j--){ // now we will store from max to 0, this way it does not require right side element so we can update current cell directly.
                
                int notPicked =  prev[j] ;
                int picked = (int)-1e9 ;
                if(weight[i] <= j)
                    picked = value[i] + prev[j - weight[i]] ;
                
                prev[j] = Math.max(notPicked,picked) ;
            }
//             prev = curr ;
        }
        
        return prev[maxWeight] ;
    }
    
    
}