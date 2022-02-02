package Searching_Sorting_level_02;
import java.util.*;

public class Q37_Largest_Perimeter_Triangle {

    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums) ;
        
        // perimeter of triangle -> sum of all three sides
        // A valid triangle -> s1 + s2 > s3 (when sum of two side should be larger than side 3)

        int n = nums.length ;
        int i = n-1 ;
        
        while( i >= 2 ){  // running till 2 because we have to choose 3 sides 
            
            // as we have to find the largest perimeter so we sorted the array and  checking if previous two side sum is greater than current side
            int sum = nums[i-1] + nums[i-2] ;
            
            if(sum > nums[i]){
                return sum + nums[i] ; // if yes then add all three sides and return
             }
            
            i-- ;
        }
        
        return 0 ;
    }
    
}
