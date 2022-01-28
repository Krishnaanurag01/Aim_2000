package Searching_Sorting_level_02;

public class Q14_Find_Minimum_in_Rotated_Sorted_Array {
    
    public int findMin(int[] nums) {
        
        int n = nums.length  ;
        int low = 0 ;
        int high = n - 1 ;
        
        if(nums[low] <= nums[high]) // when array already sorted
            return nums[0];  // then return first element
        
        while(low <= high){
            
            int mid = (low+high)/2 ;
            
            if(mid-1 >= 0 && nums[mid] < nums[mid-1] ){ // if current element is smaller than it's left element then it is the min element here mid is the starting point of the array and mid-1 is the end point of the rotation
                return nums[mid] ;
            }
            else if(mid + 1 < n && nums[mid] > nums[mid+1]){ // if current element is larger than it's right element then it's right element is the smallest one. here mid is the point where rotation ends.
                return nums[mid+1] ;
            }
            else if(nums[low] <= nums[mid]){ // if left part is sorted then it means it's the rotated part so we won't find the smaller number here as sorted part will not contain smallest element
                low = mid + 1 ;
            }
            else if( nums[mid] <= nums[high] ){ // else if right part is sorted then it means right part is rotated one.
                high = mid - 1 ;
            }
        }
        
        
        return -1 ; // formality
        
    }

}
