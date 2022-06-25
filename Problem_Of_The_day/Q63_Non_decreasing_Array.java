package Problem_Of_The_day;

public class Q63_Non_decreasing_Array {

    public boolean checkPossibility(int[] nums) {
        
        int pos = -1 ;
        for(int i = 0 ; i <= nums.length - 2 ; i++){
            if(nums[i] > nums[i+1]){
                if(pos != -1) return false ; // if pos is not -1 then it means one position is already found where modification needed.
                pos = i ; 
            }
        }
        
        // if position is boundary then true else check if left and right value.
        return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos-1] <= nums[pos+1] || nums[pos] <= nums[pos+2] ;
    }
}
