package Arrays_and_string_level_02;

public class Q74_Find_the_number_of_subarrays_having_even_sum {
    
    long countEvenSum(int[] arr, int n) {
    
         long ans = 0 ;
        
        // odd : even + odd , odd + even
        // even : even + even , odd + odd
        
        int even = 0 ;
        int odd = 0 ;
        long sum = 0 ; // it's act like presum
        
        for(int val : arr){
            
            sum += val ;
            
            if(sum % 2 == 0){ // denotes sum is even
                ans += 1 + even ;  // as current number is also even so adding +1
                even++ ;
            }
            else{ /// denotes sum is odd
                ans += odd ; 
                 odd++ ;
            }
        }
        
        
        return ans ;
        
    }

}
