package Arrays_and_string;

public class Q14_Sort_Array_By_Parity {
    
    public int[] sortArrayByParity(int[] nums) {
        
        int firstOdd = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 0){ // swapping
                int temp = nums[i] ;
                nums[i] = nums[firstOdd] ;
                nums[firstOdd] = temp ;
                firstOdd++ ;
            }
        }
     
        return nums ;
    }

}
