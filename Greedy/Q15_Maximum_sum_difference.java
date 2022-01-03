package Greedy;

public class Q15_Maximum_sum_difference {

    static int maxSum(int N){
        // code here
        
        if(N == 1) return 1 ;
        
        return N*(N+1)/2 + N/2 - (N+1) ; // this is the formula to find the max sum of absolute difference.
    }
    
}
