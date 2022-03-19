package Bit_Manipulation;
import java.util.*;
public class Q13_Same_Number_of_Set_Bits_as_that_of_N {

     
    public static long ncr(long n, long r){
        if(n < r){ // when r is greater then there can't be any possibilities.
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){
            // this derived from the formula : ncr : (n!)/r!*(n-r)!
            res = res * (n - i); 
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n, int k, int i) {

        if( i == 0 )
        return 0L ;

        long mask = 1L << i ; //making mask
        
        long res = 0 ;

        if( (mask & n) == 0 ){ // then we only have one option to skip and move to next index.
        res = solution(n,k,i-1) ;
        }
        else{ // when current index bit is 1.

            long res1 = solution(n,k-1,i-1) ; // so taking current bit and looking k-1 bits ahead.
            // else not not current bit so counting total combination of getting k bits in i spots.
            long res0 = ncr(i,k) ;
            res = res1 + res0 ; 
        }
        return res ;
      
    }
    

    // it will give total count of set bit .
    public static int csb(long n){
        int res = 0;
        
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        int k = csb(n);
        System.out.println(solution(n, k, 63));
        scn.close();
    }
	
    
}
