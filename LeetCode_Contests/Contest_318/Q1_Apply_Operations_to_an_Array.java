package LeetCode_Contests.Contest_318;

public class Q1_Apply_Operations_to_an_Array {

    public int[] applyOperations(int[] nums) {
        
        for(int i = 0 ; i < nums.length - 1 ; i++){
            
            if(nums[i] == nums[i+1]){
                nums[i] *= 2 ;
                nums[i+1] = 0 ;
            }
        }
        
        int[] ans = new int[nums.length] ;
        int k = 0 ;
        for(int i = 0; i< nums.length ;i++){
            int val = nums[i] ;
            if(val != 0){
                ans[k++] = val ;
            }
        }
        
        return ans;
    }    
}