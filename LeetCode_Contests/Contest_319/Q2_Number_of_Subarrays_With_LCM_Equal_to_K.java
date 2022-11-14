package LeetCode_Contests.Contest_319;

public class Q2_Number_of_Subarrays_With_LCM_Equal_to_K {
    
    public int subarrayLCM(int[] nums, int k) {
        
        int count = 0 ;
        
        for(int i = 0 ; i < nums.length; i++){
            int hcf = 0 ;
            int lcm = 0 ;
            
            for(int j = i ; j < nums.length ; j++){
                int val = nums[j] ;
                
                if(j == i){
                    hcf = val ;
                    lcm = val ;
                    if(lcm == k) count++ ;
                    continue ;
                }
                 
                hcf = gcd(lcm, val) ;                
                lcm = (lcm*val) / hcf ;
                 
                if(lcm == k) {
                    count++ ;
                }
            }
        }
        
        return count ;
        
    }
        
        
    
    int gcd(int A, int B){
        
        if(B == 0) return A;
        
        return gcd(B,A%B) ;
    }
}
