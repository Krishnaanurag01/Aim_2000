package Arrays_and_string;

public class Q56_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {

    // check explanation in dp level-02

    public int maxSumTwoNoOverlap(int[] nums , int x , int y){
        
        return Math.max(helper(nums, x , y),helper(nums,y,x)) ;
    }
    
    public int helper(int[] nums, int x, int y) {
        
        int n = nums.length ; 
        int[] dp1 = new int[n] ;        
        int[] dp2 = new int[n] ;
        
        int sum1 = 0 ;
        for(int i = 0 ; i < n ; i++ ){
            
            if( i < x ){
                sum1 += nums[i] ;
                dp1[i] = sum1 ;
            }
            else {
                sum1 += (nums[i] - nums[i-x]) ;
                dp1[i] = Math.max(sum1,dp1[i-1]) ;
            }
        }
        
        
        int sum2 = 0 ;
        int c = 0 ; 
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            
            if(c < y ){
                sum2 += nums[i] ;
                dp2[i] = sum2 ;
            }
            else{
                
                sum2 += (nums[i] - nums[i+y]) ;
                dp2[i] = Math.max(sum2,dp2[i+1]) ;
                
            }
            c++ ;
        } 

        int max = Integer.MIN_VALUE ;
        
        for(int i = 0 ; i < n-y ; i++){
            max = Math.max(dp1[i] + dp2[i+1],max) ;
        }
        
        return max ;
    }
    
}
