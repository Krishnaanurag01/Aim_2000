package LeetCode_Contests.Contest_317;

public class Q3_Minimum_Addition_to_Make_Integer_Beautiful {

    public long makeIntegerBeautiful(long n, int target) {
        
        if(getSum(n) <= target) return 0 ; // if sum is already within range then we will add nothing.
        
        String val = String.valueOf(n) ;
        
        long additional = 0 ;
        long mul = 1 ;
        
        // otherwise we try to convert digit from last into 0.
        for(int i = val.length() - 1; i >= 0 ; i--){
            int digit = val.charAt(i) - '0' ; // took the ith digit from last
            int rem = 10 - (digit + ( i < val.length() - 1 ? 1 : 0)) ; // now inorder to make this digit 0 we have to add rem digit and we are adding additonal 1 because if we come here that means other previous values are also converted into 0 so that carry value is added here.
            
            additional = (rem * mul) + additional ; // this is the additional value that we have to add in our original value in order to get sum within target.
            
            int temp = getSum(n + additional) ;
            if(temp <= target) return additional ; // if it get within target then return this additional value and stop.
            mul *= 10 ;
        }
    
        return 0 ;
    }
    
    
    /// this function finds the sum of digits of any value.
    public int getSum(long val){
        
        long sum = 0 ;
        
        while(val > 0){
            long digit = val % 10 ;
            sum += digit ;
            val = val/10; 
        }
        
        return (int)sum ;
    }
}
