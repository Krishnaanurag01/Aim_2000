package LeetCode_Contests.Contest_316;

public class Q2_Number_of_Subarrays_With_GCD_Equal_to_K {

    public int subarrayGCD(int[] nums, int k) {
        
        // brute force approach  by using nested looping and checking gcd for each subarray.
        
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){    
            int prevgcd = -1 ;
            for(int j = i ; j < nums.length; j++){
                int val = nums[j] ;
                if(prevgcd == -1){
                    prevgcd = gcd(val,val) ; 
                }
                else{
                    prevgcd = gcd(val, prevgcd) ;
                }
                
                if(prevgcd == k) count++ ;
            }
        }
        
        return count ;
    }
    
    int gcd(int a, int b){
        
        if(b == 0) return a ;
        
        return gcd(b, a%b) ;
    }
}
