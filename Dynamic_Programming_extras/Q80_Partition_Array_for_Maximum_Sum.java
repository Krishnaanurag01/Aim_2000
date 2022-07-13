package Dynamic_Programming_extras;

public class Q80_Partition_Array_for_Maximum_Sum {

    Integer[] dp ;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length] ;
        return helper(0,arr,k) ;
    }
    
    int helper(int idx, int[] arr, int k){
        if(idx == arr.length) return 0 ;
        if(dp[idx] != null) return dp[idx] ;
        
        int nc = arr[idx] + helper(idx+1,arr,k) ; // not partitioned from idx 
        int ei = Math.min(idx + k,arr.length) ; // finding the ending index till where we can partiton subarray starting from current index.
        
        int ans = nc ; 
        int maxEle = arr[idx] ; // max element 
        for(int i = idx; i < ei ; i++){
            int val = arr[i] ;
            maxEle = Math.max(maxEle,val) ; // comparing max element till now
            int temp = maxEle * (i - idx + 1) + helper(i+1,arr,k); // if we partion sub array from idx to current i then ans would be max element in size of subarray + other part.
            ans = Math.max(ans,temp) ;
        }
        
        return dp[idx] = ans;
    }
}
