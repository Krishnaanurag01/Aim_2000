package Dynamic_Programming_extras;

public class Q49_Sum_of_Subarray_Minimums {

    //Gives TLE
    // using gap strategy. takes hell lot of space.

    public int sumSubarrayMins2(int[] arr) {
        
        int mod = (int)1e9 + 7;
        
        long sum = 0 ; 
        int[][] dp = new int[arr.length][arr.length] ;
        
        for(int g = 0 ; g < arr.length ; g++){
            for(int i = 0 , j = g ; j < arr.length ; j++ , i++){
                
                if(g == 0){
                    dp[i][j] = arr[i] ;
                    sum += dp[i][j] ;
                }
                else if(g == 1){
                    dp[i][j] = Math.min(arr[i],arr[j]) ;
                    sum += dp[i][j] ;
                }
                else{
                    dp[i][j] = Math.min(arr[i], Math.min(dp[i+1][j-1], arr[j]) ) ;
                    sum += dp[i][j] ;

                }
            }
        }
        
        return (int)(sum % mod);
    }


    // using memoization,
    // take O(n) space.
    //Gives TLE

    
    static Integer dp[] ;
    public int sumSubarrayMins(int[] arr) {
         dp = new Integer[arr.length] ;
        return helper(0,arr) ;
    }
    
    static int mod = (int)1e9+7 ;
    int helper(int i, int[] arr){
        
        if(i == arr.length) return 0 ;
        if(dp[i] != null) return dp[i] ;
        
        int sum = 0 ;
        int min = (int)1e9 ;
        for(int k = i ; k < arr.length ; k++){
            min = Math.min(min,arr[k]) ;
            sum = (sum + min)%mod ;
        }
        
        return dp[i] = (sum + helper(i+1,arr))%mod ;
    }






}
