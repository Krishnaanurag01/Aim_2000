package Problem_Of_The_day;
import java.util.*;

public class Q343_GCD_Array {

    public static int solve(int N, int K, int[] arr) {
        
        //step 1 :  find prefix sum.
        int[] prefix = new int[N] ;
        int sum = 0 ;
        for(int i = 0 ; i < N ; i++){
            sum += arr[i];
            prefix[i] = sum ;
        }
        
        // now find all the divisor of sum.
        ArrayList<Integer> divisors = new ArrayList<>() ;
        
        for(int i = 1 ; i * i <= sum ; i++){ // taking all the divisors that a and b both from a * b
            if(sum % i == 0){
                divisors.add(i) ;
                if( i != sum/i){ // when 4*4 is same so handling this case.
                    divisors.add(sum/i) ;
                }
            }
        }
        
        // now pick all divisors and check if pair count is greater than or equal to K. and choose the largest divisor(i.e GCD)
        int ans = 1 ; // 1 is the minimum divisor that is common for all
        for(int divisor : divisors){
            int partition = 0 ;
            for(int val : prefix){
                if(val % divisor == 0) // means sum till current can be paired in one group that has gcd as divisor
                partition++ ;
                
                if(partition >= K){
                    ans = Math.max(ans, divisor) ; // chossing the max divisor
                }
            }
        }
        
        
        return ans ;
    }
}
