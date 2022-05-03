package Dynamic_Programming_extras;

public class Q73_Sum_of_All_Subset_XOR_Totals {

    public int subsetXORSum(int[] nums) {
        return helper(0,nums,0) ;
    }
    
    int helper(int i , int[] nums , int mask){
        
        if(i == nums.length) return mask ;
        
        int nt = helper(i+1,nums, mask) ;  // not taking it.
        int t = helper(i+1,nums, mask ^ nums[i]) ; // taking it.
        
        return nt + t ; // returning sum.
    }
}
