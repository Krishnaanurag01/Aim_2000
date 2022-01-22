package Arrays_and_string ;

public class Q52_Consecutive_Numbers_Sum {

    public int consecutiveNumbersSum(int n) {
        
        int count = 0 ; 
        
        // check copy for the proof.

        for(int k = 1 ; 2*n > k * (k-1) ; k++){
            
            int numerator = n - (k * (k-1)/2) ;
            
            if(numerator % k == 0){
                count++ ;
            }
            
        }
        
        return count ;
        
    }

}