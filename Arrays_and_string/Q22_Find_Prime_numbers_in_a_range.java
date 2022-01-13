package Arrays_and_string;
import java.util.*;

// same logic as sieve of eratosthens.
public class Q22_Find_Prime_numbers_in_a_range {
    
    ArrayList<Integer> primeRange(int L, int N) {
        
        
        ArrayList<Integer> list = new ArrayList<Integer>() ;
      
       boolean[] isPrime = new boolean[N+1] ;
     Arrays.fill(isPrime,true) ;
     
     for(int i = 2 ; i * i  <= N ; i++ ){
         if( isPrime[i] == true ) {
             
             for(int j = i + i ; j <= N ; j += i){
                 isPrime[j] = false ;
             }
         }
     }
      
       
       isPrime[0] = false ;
       isPrime[1] = false ;
     
      for(int i = L ; i <= N ; i++){
           
           if(isPrime[i] == true){
               list.add(i) ;
           }
       }
     
     
     return list ;
     
   }

}
