package Arrays_and_string;
import java.util.*;

public class Q20_Sieve_of_Eratosthenes {
    
    // Time comp : O(nlog(log n))
    static ArrayList<Integer> sieveOfEratosthenes(int N){
      
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        
        boolean[] isPrime = new boolean[N+1] ; // N numbers
        Arrays.fill(isPrime,true) ; // each number assigned true that denotes each number of array is prime.
        
        // running from 2 because 1 and 0 are not primes.
        for(int i = 2 ; i * i  <= N ; i++ ){  // now running loop from 2 to root of N 
            if( isPrime[i] == true ) { // if number is prime then make its multiple false.
                
                for(int j = i + i ; j <= N ; j += i){
                    isPrime[j] = false ;
                }
            }
        }
        
        for(int i = 2 ; i <= N ; i++){
            // now adding element that is left with mark true denotes prime.
            if(isPrime[i] == true){
                list.add(i) ;
            }
        }
        
        
        return list ;
        
    }

}
