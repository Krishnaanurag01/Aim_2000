package Dynamic_Programming_extras;

public class Q72_Longest_Subarray_of_1s_After_Deleting_One_Element {

    // method 01 : 
    public int longestSubarray(int[] nums) {
        
        int[] lcns = new int[nums.length];     // store consecutive count of 1's from left
        int[] rcns = new int[nums.length];     // from right
        
        // storing consecutives 1's in left and right additional array
        int cons = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 1){
                cons++ ;
                lcns[i] = cons;
            }
            else{
                cons = 0 ;
            }
        }
        
        cons = 0 ;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(nums[i] == 1){
                cons++ ;
                rcns[i] = cons;
            }
            else{
                cons = 0 ;
            }
        }
        
        // now checking answer by seeing the 0 in nums, as we have to delete one element so we'll delete that zero whose left + right consecutive 1's sum is largest.
        int ans = 0 ;
        int czero = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                int left = i > 0 ? lcns[i-1] : 0 ;
                int right = i < nums.length - 1 ? rcns[i+1] : 0 ;
                ans = Math.max(ans,left+right) ;
                czero++ ;
            }
        }
        
        // if array does not have any zero in it then we will delete just one 1 from the nums array.
        if(czero == 0)
            return nums.length - 1;
        
        return ans ;

    }


    // method 02 : sliding window
    public int longestSubarray2(int[] nums) {
        
        // using acquire and release strategy. solved variation in hashmaps
        
        int j = -1 ;
        int zcount = 0 ; // count of zero
        int ans = 0 ;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0)
                zcount++ ;
            
            while(zcount > 1){ // when have more than one zero then delete zero until there's only 1 zero left
                j++ ;
                if(nums[j] == 0)
                    zcount-- ;
            }
            ans = Math.max(ans, i - j - 1) ; // subtracting -1 denotes deleting current number.
        }
        
        return ans ;
    }
}
