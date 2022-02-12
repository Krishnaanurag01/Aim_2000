package Arrays_and_string_level_02;
import java.util.*;

// same logic as sieve of eratosthens.
public class Q23_Product_of_Primes {
    
    static long primeProduct(long L, long N){
        // code here
        
         boolean[] isPrime = new boolean[(int)N+1] ;
      Arrays.fill(isPrime,true) ;
      
      for(int i = 2 ; i * i  <= (int) N ; i++ ){
          if( isPrime[i] == true ) {
              
              for(int j = i + i ; j <= N ; j += i){
                  isPrime[j] = false ;
              }
          }
      }
        
        
        int mod = 1000000000+7 ;
        
        long count = 1 ;
        
        isPrime[0] = false ;
        isPrime[1] = false ;
      
      for(int i = (int) L ; i <= (int) N ; i++){
          
          if(isPrime[i] == true){
              count = (count * i) % mod ;
          }
      }
      
      
      return count ;
      
      
    }

}
