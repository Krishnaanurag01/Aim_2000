package Dynamic_Programming_extras;

public class Q13_Partitions_With_Given_Difference {

    
    public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
        int sum = 0 ;
        for(int i : arr) sum += i ;
        // if after substraction it becomes 0 or if it is not even then return false;
        if((sum - d < 0) || (sum - d ) % 2 != 0 ) return 0 ;
        
        return helper(d,arr,(sum-d)/2) ; // this sum - d / 2 came from a formula that is : s1 - s2 = d.
	}
    static int mod = (int)1e9 + 7 ;

    // this is count of subset with sum
    static int helper(int d, int[] arr, int target){
        
        int[] dp = new int[target+1] ;
        
        if(arr[0] == 0 ) dp[0] = 2 ;
        else dp[0] = 1 ;
        
        if(arr[0] != 0 && arr[0] <= target ) dp[arr[0]] = 1 ;
        
        for(int i = 1 ; i < arr.length ; i++){
            int[] temp = new int[target+1] ;
            for(int j = 0 ; j <= target ; j++ ){
                
                int notTook = dp[j] ;
                int took = 0 ;
                if(arr[i] <= j )
                    took = dp[j - arr[i]] ;
                
                temp[j] = (notTook + took)%mod ;
            }
            dp = temp ;
        }
        
        return ( dp[target] ) % mod;
    }


    
}
