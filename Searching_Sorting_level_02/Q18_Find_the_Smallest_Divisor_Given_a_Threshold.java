package Searching_Sorting_level_02;

public class Q18_Find_the_Smallest_Divisor_Given_a_Threshold {

    // same as Q17
    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max = 0 ;
        
        for(int val : nums){
            max = Math.max(max,val) ;
        }
        
        int low = 1 ; // here low will be 1 becuase 0 is not possible, if we divide any number with 0 will give infinity.

        // rest is same as Q17
        int high = max ; 
        int ans = 0 ;
        
        while(low <= high){
            int divisor = low + (high - low ) / 2 ;
            
            if(isPossible(nums,threshold,divisor)){
                ans = divisor ;
                high = divisor - 1 ;
            }
            else{
                low = divisor + 1 ;
            }
        }
        
        return ans ; 
        
    }
    
    
    public boolean isPossible(int[] nums , int th , int divisor ){
        
        int sum = 0 ;
        
        for(int val : nums){
            sum += (int)Math.ceil((double)val/divisor) ;
        }
        
        return sum <= th ;
    }

}
