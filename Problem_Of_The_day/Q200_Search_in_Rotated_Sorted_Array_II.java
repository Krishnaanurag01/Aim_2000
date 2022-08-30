package Problem_Of_The_day;

public class Q200_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        
        int low = 0 ;
        int high = nums.length - 1 ;
        
        while(low <= high){
            int mid = low + (high-low)/2 ;
            
            if(nums[mid] == target) return true ;
            
            else if(nums[low] < nums[mid]){ // check if left part is sorted.
                    // check if nums comes in this range 
                    if(target >= nums[low] && target <= nums[mid]){
                        high = mid - 1 ; // then makes the range by subtracting high 
                    }
                    else{
                        // else search in right side
                        low = mid + 1 ;
                    }
            }
            else if(nums[mid] < nums[low]){ // when left part is not sorted then right surely will be sorted.
                
                if(target >= nums[mid] && target <= nums[high]){
                        low = mid + 1 ; // then makes the range by subtracting high 
                    }
                    else{
                        // else search in left side
                        high = mid - 1  ;
                    }   
            }
            else{ // to remove redundancy
                low++ ;
            }
        }
        
        
        return false;
    }
}
