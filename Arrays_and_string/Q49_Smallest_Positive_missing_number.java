package Arrays_and_string;
import java.util.*;

public class Q49_Smallest_Positive_missing_number {
    
    static int missingNumber(int nums[], int size)
    {
         Arrays.sort(nums) ; // first sort the array.
        
        int smallest = 1 ; // this is currently the smallest positive integer.
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= 0 ) continue ; // if the current element is negative then continue;
            
            if(i > 0 && nums[i] == nums[i-1]) continue ; // if current element is same as previous one then skip.

            if(nums[i] == smallest){ // if current element is same as array element then increase the smallest number(denotes that the number is already present in array so increase the smallest positive number )
                smallest++ ;
            }
            else{ // if the smallest positive number is not present then return .
                 return smallest ;
            }
            
            
        }
        
        return smallest ;
        
    }


    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length ;
        // first step : check if 1 present and mark number as 1 who are out of range.
        boolean onePresent = false ;
        for(int i = 0 ; i < n ; i++){
            
            if(nums[i] == 1) {
                onePresent = true ;
            }
            
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1 ;
            }
        }
        
        if(onePresent == false){
            return 1; /// as 1 not present then simply return 1.
        }
        
        
        // step 02 : map numbers with indexes
        
        for(int i = 0 ; i < n ; i++){
            int index = Math.abs(nums[i]) ; // here first take abs number
            nums[index-1] = -Math.abs(nums[index-1]) ; // now go to index -1 so (1 is mapped at 0 th index , 2 is at 1st index.) and also store - abs(nums[i]) becuase if number is already mapped then it must be negative and negation of negative is positive. negative denotes that it is present iin array .
        }
        
        //step 02 :  // if current number is not negative then it means index + 1 is not present in the array so return it.
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0){
                return i+1 ;
            }
        }
        
        
        
        // else return n+1.
        return n+1 ;
        
    }

}
