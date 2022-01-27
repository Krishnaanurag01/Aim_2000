package Searching_Sorting_level_02;

public class Q11_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        
        int fs = getFirstPosition(nums,target) ; // getting the first occurance using binary search
        int ls = getLastPosition(nums,target) ; // getting the last occurance using binary search
        
        return new int[]{fs,ls} ; 
    }
    
    public int getFirstPosition(int[] nums, int target){
        
        int low = 0 ;
        int high = nums.length ; 
        
        int idx = -1 ;
        
        while(low <= high){
            
            int mid =  (low + high) / 2 ;
            
              if(mid >= 0 && mid < nums.length){
            
            if(nums[mid] == target){ // when target is found and as we are finding the first occurance so we'll look on lesser side
                idx = mid ;
                high = mid - 1 ; // that's why here decrementing the high to mid - 1
            }
            else if(nums[mid] < target){
                low = mid + 1 ;
            }
            else {
                high = mid - 1 ;
            }
              }
            else
                break ;
        }
        
        
        return idx;
    }
    
    public int getLastPosition(int[] nums,int target){
         int low = 0 ;
        int high = nums.length ; 
        
        int idx = -1 ;
        
        while(low <= high  ){
            
            int mid =  (low + high) / 2 ;
            
            if(mid >= 0 && mid < nums.length){
            
            if(nums[mid] == target){// when target is found and as we are finding the last occurance so we'll look on higher side
                idx = mid ;
                low = mid + 1 ; // that's why here changing low = mid + 1
            }
            else if(nums[mid] < target){
                low = mid + 1 ;
            }
            else {
                high = mid - 1 ;
            }
                
            }
            else{
                break ;
            }
        }
        
        
        return idx;
    }

    
}
