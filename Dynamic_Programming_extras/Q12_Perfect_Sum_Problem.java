package Dynamic_Programming_extras ;
public class Q12_Perfect_Sum_Problem {

    // same as Q11 only base case is different. becuase here num[i] >= 0 where as in Q11 nums[i] >= 1 so 0 was not considered there.

    static int mod =(int)1e9 + 7 ;
	public int perfectSum(int num[],int n, int tar) 
	{ 
	    Integer[][] dp = new Integer[num.length][tar+1] ;
        return helper(num.length - 1 ,num,tar,dp) ;
	} 
	
    static int helper(int i, int[] arr, int sum, Integer[][] dp ){
	   
	    if(i == 0 ){
	        if(sum == 0 && arr[i] == 0 ) return 2 ; // if sum is zero and current element is also 0 then we have two option that is totake and not take and both is correct so return 2.
	        if(sum == 0 || arr[i] == sum ) return 1 ; // else if sum == 0 or sum == current element then count is 1.
	        
	        return  0;
	    } 
            
        if(dp[i][sum] != null) return dp[i][sum] ;
	    
	    int notTook = helper(i-1,arr,sum,dp) ;
	    int took = 0 ;
	    if(arr[i] <= sum){
	        took = helper(i-1,arr,sum  - arr[i],dp) ;
	    }
	    
	    return dp[i][sum] = ( notTook + took ) % mod ;
    }
    
}
