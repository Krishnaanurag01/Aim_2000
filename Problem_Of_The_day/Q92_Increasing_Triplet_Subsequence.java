package Problem_Of_The_day;

public class Q92_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false ;
    
        int i = Integer.MAX_VALUE ;
        int j = Integer.MAX_VALUE ;
        
        for(int idx = 0 ; idx < nums.length ; idx++){
            if(nums[idx] <= i){
                i = nums[idx] ;
            }
            else if(nums[idx] <= j){
                j = nums[idx] ;
            }
            else return true ; // means it is greater than previous two numbers.
        }
        
        return false ;
    }
}
