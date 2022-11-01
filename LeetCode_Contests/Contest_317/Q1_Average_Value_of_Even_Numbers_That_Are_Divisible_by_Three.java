package LeetCode_Contests.Contest_317;

public class Q1_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three {
    
    public int averageValue(int[] nums) {
        
        int count = 0 ;
        int sum = 0 ;
        
        for(int val : nums){
            if(val % 2 == 0 && val % 3 == 0){
                sum += val ;
                count++ ;
            }
        }
        
        
        if(count == 0) return 0 ;
        return sum / count ;
    }
}
