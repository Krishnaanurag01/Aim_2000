package Problem_Of_The_day;

public class Q234_Sum_of_Even_Numbers_After_Queries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length] ;
        int even = 0 ;
        
        // first find sum of even nums.
        for(int val : nums) if(val % 2 == 0) even += val ;
        
        for(int i = 0 ; i < queries.length ; i++){
            int val = queries[i][0] ;
            int idx = queries[i][1] ;
            
            int prev_val = nums[idx] ; // previous value at current query idx.
            nums[idx] += val ; // adding current query val.
            
            if(prev_val % 2 == 0){ // prev is even.
                even -= prev_val ;// then subtract
                if(nums[idx] % 2 == 0){ // and if after adding val new number is again even then
                    even += nums[idx] ; // update even
                }
            }
            else{ // when prev is odd 
                // then we don't have to substract unlike even case.
                if(nums[idx] % 2 == 0){
                    even += nums[idx] ;
                }
            } 
            
            ans[i] = even ; // storing answer.
        }
        
        return ans ;
    }
}
