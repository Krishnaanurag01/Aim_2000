package Problem_Of_The_day;

public class Q177_Minimum_Limit_of_Balls_in_a_Bag {
    
    public int minimumSize(int[] nums, int maxOperations) {
         
        int low = 1 ;
        int high = getMaxInArray(nums) ; // mmax value is high 
        while(low <= high){
            int penality = low + (high - low)/2 ; // this is mid 
            int opr = 0 ;
            // check if array can have max value as penality after maxoperations applied 
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] > penality){
                    if(nums[i] % penality == 0){ // if complete divisible by penality then count - 1 
                       opr += (nums[i] / penality) - 1 ;
                    }
                    else{ //
                        opr += (nums[i]/penality) ;
                    }
                }
            }
            
            if(opr <= maxOperations){ // if current penality can be achieved then check for lower penality
                high = penality - 1 ;
            }
            else{ // else check for higher penality
                low = penality + 1 ;
            }
        }
        
        return low ;
    }
    
    int getMaxInArray(int[] nums){
        int max =0 ;
        for(int val : nums){
            max = Math.max(max,val) ;
        }
        
        return max ;
    }
    
}
