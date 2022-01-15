package Arrays_and_string;

public class Q25_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {
        
        int end = -1 ;  /// this will point to the last index of element which is smaller. 
        int max = nums[0] ; // we we'll carry an max value.
        
        for(int i = 1 ; i < nums.length ; i++){  // now checking if the current value is smaller than previous max then it means it is not at its correct position.
            if(max > nums[i]){ // if found the element which is smaller than max till now then update the end pointer.
                end = i ;
            }
            else{ // else update the max value.
                max = nums[i];
            }
        }
        
         int start = 0 ;  // this will point to start position of the unsorted array. this is assigned 0 becuase if both end and start pointer remains same then array is already sorted and this (end-start+1) will give 0.
        int min = nums[nums.length-1] ; // vice versa of first loop
        
        
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            if(min < nums[i]){ // here if element is larger than min till now. then update the start pointer
                start = i ;
            }
            else{ // else update the min value.
                min = nums[i];
            }
        }
        
        return end - start + 1 ; // now return the width.
        
        
    }
    
}
