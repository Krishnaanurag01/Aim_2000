package Dynamic_Programming_random;

public class Q6_Minimum_Swaps_To_Make_Sequences_Increasing {

    Integer[][] dp ;
    public int minSwap(int[] nums1, int[] nums2) {
        
        dp = new Integer[nums1.length][2] ;
        return helper(nums1, nums2, 0, 0) ;
    }
    
    // swapped denotes whether previous operation was swap or not swap. initally it is not swap
    int helper(int[] nums1, int nums2[], int idx, int swapped) {
        
        if(idx == nums1.length ) return  0 ;
        if(dp[idx][swapped] != null) return dp[idx][swapped] ;
        
        
        int ans = Integer.MAX_VALUE ;
        
        // if both are are already increasing then do not swap.
        if(idx == 0 || nums1[idx] > nums1[idx-1] && nums2[idx] > nums2[idx-1]){
           int temp = helper(nums1, nums2, idx+ 1,0) ;
            ans = Math.min(ans, temp) ;
        }
        
        
        // if both arrays idx element can be swapped then try doing it.
        if(idx == 0 || nums1[idx] > nums2[idx-1] && nums2[idx] > nums1[idx-1]){    
            swap(nums1,nums2,idx) ;
            int temp = 1 + helper(nums1, nums2, idx+ 1, 1) ;
            swap(nums1,nums2,idx) ;
            ans = Math.min(ans, temp)  ; //  and roll back.
        }
        
        return dp[idx][swapped] = ans ;
    }
    
    
    void swap(int[] nums1, int[] nums2, int idx){
        int temp = nums1[idx] ;
        nums1[idx] = nums2[idx] ;
        nums2[idx] = temp ;
    }
}
