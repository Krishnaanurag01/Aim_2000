package Dynamic_Programming_extras;

public class Q11_Number_Of_Subsets {
    
    // memoization/

    public static int findWays(int num[], int tar) {
        // Write your code here..
        Integer[][] dp = new Integer[num.length][tar+1] ;
        	    return helper(num.length - 1 ,num,tar,dp) ;
    }
    
    static int helper(int i, int[] arr, int sum, Integer[][] dp ){
	    
	    if(sum == 0) return 1 ; // returning 1 when sum becomes 0 
	    if(i == 0 ) return arr[i] == sum ? 1 : 0 ; // else cheecking if last element is equals to sum or not
            
        if(dp[i][sum] != null) return dp[i][sum] ; // returning if solve before
	    
	    int notTook = helper(i-1,arr,sum,dp) ;
	    int took = 0 ;
	    if(arr[i] <= sum){
	        took = helper(i-1,arr,sum  - arr[i],dp) ;
	    }
	    
	    return dp[i][sum] = notTook + took ; // returning total count.
	}

    // space optimized tabulation : same as Q10

    public static int findWays2(int num[], int tar) {
        int[] dp = new int[tar+1] ;
         if(num[0] <= tar) dp[num[0]] = 1 ;
         dp[0] = 1 ; // store for 0 sum  = 1; // thsi is base case in recursive code
         
         for(int i = 1 ; i < num.length ; i++){
             int[] temp = new int[tar+1] ;
         for(int j = 0 ; j <= tar ; j++){
             int notTook = dp[j] ;
             int took = 0 ;
             if(num[i] <= j){
                 took = dp[ j  - num[i]]  ;
               }	    
             temp[j] = notTook + took ;  // storing total  
             }
             dp = temp ;
         }
         
         
         return dp[tar] ;
     }

}
