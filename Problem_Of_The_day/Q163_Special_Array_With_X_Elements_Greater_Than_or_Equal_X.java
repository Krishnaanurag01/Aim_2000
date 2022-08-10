package Problem_Of_The_day;
import java.util.*;

public class Q163_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {

    public int specialArray(int[] nums) {
        
        // intuition : as size of nums is n so the x can be 1 to n as we require the same freq of numbers with greater or equal value.
        
        Arrays.sort(nums) ; // sorting for binary seach
        
        for(int i = 1 ; i <= nums.length ; i++){ // checking for each possible x
             int count = getCount(i,nums) ;  
            if(count == i) return i ;
        }
        
        return -1 ;
    }
    
    int getCount(int x, int[] nums){
        int low = 0 ;
        int high = nums.length - 1 ;
        
        // here instead of finding how many element are greater or equal to x we can search the starting index of x in nums so that we can count the elements after it which are greater than x
        
        while(low <= high){
            int mid = (low + high)/2 ;
            
            if(nums[mid] < x){
                low = mid + 1 ;
            }
            else if(nums[mid] >= x){
                high = mid - 1 ;
            }
        }
        
        return nums.length - low  ;
    }
}
