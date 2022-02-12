package Arrays_and_string_level_02;
import java.util.*;

public class Q28_Wiggle_Sort_II {

    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums) ; // first sorting the array.
        int n = nums.length ;
        
        int i = 1 ; // pointing to first odd index
        int j = nums.length - 1 ;  // 
        
        int[] ans = new int[nums.length] ;
        
        while(i < n){
            ans[i] = nums[j] ; // storing largest number from right in the odd index first
            i += 2 ;
            j-- ;
        }
        
        i = 0 ; // now making i to 0 
        
        while(i < n ){
            ans[i] = nums[j] ; // now storing for even add 
            i += 2 ;
            j-- ;
        }
        
        
        for(int k = 0 ; k < nums.length ; k++){ // storing result to original array.
            nums[k] = ans[k] ;
        }
        
    }
    
}
