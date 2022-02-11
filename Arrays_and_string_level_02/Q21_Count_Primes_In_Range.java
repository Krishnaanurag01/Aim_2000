package Arrays_and_string_level_02;

import java.util.Arrays;


// same logic as sieve of eratosthens.
public class Q21_Count_Primes_In_Range {
    
    int countPrimes(int L, int N) {
        
        
        boolean[] isPrime = new boolean[N+1] ;
        Arrays.fill(isPrime,true) ;
        
        for(int i = 2 ; i * i  <= N ; i++ ){
            if( isPrime[i] == true ) {
                
                for(int j = i + i ; j <= N ; j += i){
                    isPrime[j] = false ;
                }
            }
        }
          
          int count = 0 ;
          
          isPrime[0] = false ;
          isPrime[1] = false ;
        
        for(int i = L ; i <= N ; i++){
            
            if(isPrime[i] == true){
                count++;
            }
        }
        
        
        return count ;
        
      }
      
}
