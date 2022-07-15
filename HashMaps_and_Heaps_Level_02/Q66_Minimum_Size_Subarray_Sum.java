package HashMaps_and_Heaps_Level_02;

public class Q66_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {
        // acquire and release strategy.
        
        int ans = (int)1e9 ;
        int i = -1 ;
        int j = -1 ;
        int sum = 0 ;
        
        while(true){
            boolean flag1 = false ;
            boolean flag2 = false ;
            
            // aquire.
            while(i < nums.length - 1 && sum < target){
                i++ ;
                sum += nums[i] ;
                if(sum >= target) ans = Math.min(ans,i-j) ;
                flag1 = true ;
            }
            
            while(j < nums.length - 1 && sum >= target){
                j++ ;
                ans = Math.min(ans,i-j+1) ;                
                sum -= nums[j] ;
                flag2 = true ;
            }
            if(flag1 == false && flag2 == false) return ans == (int)1e9 ? 0 : ans;
        }
    }
}
