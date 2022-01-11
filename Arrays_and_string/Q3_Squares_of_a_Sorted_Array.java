package Arrays_and_string;

public class Q3_Squares_of_a_Sorted_Array {

    
    public int[] sortedSquares(int[] nums) {
        
        int i = 0 ;
        int j = nums.length - 1 ;
        int[] ans = new int[nums.length] ;
        int idx = nums.length-1 ; // index for ans array
        
        while(i <= j){
            
            if( Math.abs(nums[i]) > Math.abs( nums[j] ) ){ // if nums[i] is greater then add it to the answer and sort the array
               ans[idx--] = nums[i]*nums[i] ;
                i++ ;
            }
            else{
                ans[idx--] = nums[j]*nums[j] ; // else put arr[j] and j--
                j-- ;             
            }
            
        }
        
        
        return ans ;
        
    }
}
