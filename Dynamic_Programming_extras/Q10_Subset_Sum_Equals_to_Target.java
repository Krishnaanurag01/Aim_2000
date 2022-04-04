package Dynamic_Programming_extras;

public class Q10_Subset_Sum_Equals_to_Target {
    


    // memoization.
    static Boolean isSubsetSum(int N, int arr[], int sum){
       
        Boolean[][] dp = new Boolean[N][sum+1] ; // dp to store result
        return helper(N-1,arr,sum,dp) ;
    }
    
    static boolean helper(int i , int[] arr, int sum,Boolean[][] dp){
        if(sum == 0){
            return true ;
        }
        else if( i == 0 ) return arr[i] == sum ;
        
        if(dp[i][sum] != null) return dp[i][sum] ; // if already solved then return true
        
        boolean notTook = helper(i-1,arr,sum,dp) ; // when not took the current element
        boolean took = false; 
        if(arr[i] <= sum ) // can take current element if current element is smaller than sum
        took = helper(i-1,arr,sum-arr[i],dp) ; // taking current elemnt
        
        return dp[i][sum] = took || notTook  ; 
        
    }


    // tabulation : 

    static Boolean isSubsetSum2(int N, int arr[], int sum){
        // code here
        
        boolean[][] dp = new boolean[N][sum+1] ;
        
        for(int i = 0 ; i < N ; i++) dp[i][0] = true ; // it is true if at any index we got 0.
        
        if(arr[0] <= sum ) dp[0][arr[0]] = true ; // if first element is less than or equal to sum then true
        
        for(int i = 1 ; i < N ; i++){
            for(int j = 1 ; j <= sum ; j++){
                
                boolean notTook = dp[i-1][j] ; // not taken
                boolean took = false ;
                
                if(arr[i] <= j )
                took = dp[i-1][ j - arr[i] ] ; // if took then check if rest is true or not.
                
                dp[i][j] = notTook || took ;
            }
        }
        
        return dp[N-1][sum] ;
    }


    
    // space optimized solution : takes only O(k) space
    // as one row depends on the previous row so we will hold only previous row.

    static Boolean isSubsetSum3(int N, int arr[], int sum){
        // code here
        
        boolean[] dp = new boolean[sum+1] ;// making dp of target size
        
        // for(int i = 0 ; i < N ; i++) dp[i][0] = true ; // it is true if at any index we got 0.
        
        if(arr[0] <= sum ) dp[arr[0]] = true ; // if the first element is smaller or less than it can be true for arr[o]
        
        for(int i = 1 ; i < N ; i++){
            boolean[] temp = new boolean[sum+1] ; // current row array
            for(int j = 0 ; j <= sum ; j++){
                
                boolean notTook = dp[j] ; // then look in previous
                boolean took = false ;
                
                if(arr[i] <= j )
                took = dp[ j - arr[i] ] ; // check if remainning is true in previous row
                
                temp[j] = notTook || took ; // storing in current row
            }
            dp = temp ; // now current row become previous row
        }
        
        return dp[sum] ;
    }
}
