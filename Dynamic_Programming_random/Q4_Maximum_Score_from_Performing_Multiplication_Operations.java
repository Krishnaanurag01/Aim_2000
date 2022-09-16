package Dynamic_Programming_random;

public class Q4_Maximum_Score_from_Performing_Multiplication_Operations {

      /*
    We have three parameters we could form our dp on:
    
    Left idx of nums array
    Right idx of nums array
    Idx of multiplier array
    
However, if you already have the Idx of multiplier array(which tells us how many numbers we've used), and the Left idx of nums array, you don't really need the Right idx of nums array.
For a given nums Left idx and multiplier Idx, the nums Right idx will always be.. the same.
So it's redundant. Therefore our memo only needs to be 2 dimensional.*/
                                                         
Integer[][] dp ;
public int maximumScore(int[] nums, int[] multipliers) {
    
    dp = new Integer[multipliers.length][multipliers.length] ; // hum multiplierns length tak he mutliply kar saktey isliy both dimention of multilpliers length jitna he banao.
    // and hume right k liy alag dimention banane ki jaroort nhi kyuki right ki value humesha same he rhegi for the same left and multiplier index.
    
    return helper(nums, multipliers, 0, nums.length - 1, 0) ;
}

int helper(int[] nums, int[] mul, int si, int ei, int mi){
    
    if(si > ei) return 0 ;
    if(mi >= mul.length) return 0 ;
    if(dp[mi][si] != null) return dp[mi][si] ;

    int start_chosen = nums[si]*mul[mi] +  helper(nums, mul, si +1, ei, mi + 1) ;
    int end_chosen = nums[ei]*mul[mi] + helper(nums, mul, si, ei-1, mi + 1) ;
    
    return dp[mi][si] = start_chosen > end_chosen ? start_chosen : end_chosen ;
}
}
