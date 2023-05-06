package Problem_Of_The_day;
import java.util.*;

/**
 * Q4_Number_of_Subsequences_Tha_Satisfy_the_Given_Sum_Condition
 */
public class Q4_Number_of_Subsequences_Tha_Satisfy_the_Given_Sum_Condition {

    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);    //Sorting so that we can get the min and max directly
        int i = 0 ; 
        int j = nums.length-1 ;
        int count = 0 ; 
        int mod = (int)1e9 + 7;
        
        int[] power = new int[nums.length] ;  //Calculating the power in the power array.
        power[0] = 1 ; // no. of subsequences formed using one no. is 1
        for(int idx = 1 ; idx < nums.length ; idx++){
            power[idx] = ( power[idx-1] * 2 ) % mod;  
        }
        
			//Now if i is at 0 and j is at 3 then the no. of 
			//subsequences keeping the first no. that is at i fixed we can form 8 subsequences (because for length 3 array there could be 2^3 subseq ), similarly for different values of i and j the no. of subsequences varies.
			// if this is the array
		   // 3 5 6 7			
		   // i     j                      j-i=3.
		   // then no. of subsequences formed keeping 3 constant is 8 which is stored in the power array (power[j-i]=8) just do a dry run of the formula. you will get 8 for gap of 3
			//3
			//3 5 6 7
			//3 5 6
			//3 5 7
			//3 6 7
			//3 5
			//3 6
			//3 7
        
        while(i <= j){
            if(nums[i] + nums[j] <= target){ // if within the range.
                count = (count + power[j-i] ) % mod; // count the subseq by keeping the ith element constant and take length of rest element and find 2^len (this is total subseq count)
                i++;
            }else if(nums[i] + nums[j] > target) j--; // else decrease the higher value so that we can have max value in range.
        }
        
        return count;
    }
}