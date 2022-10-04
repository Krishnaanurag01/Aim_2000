package Super_Important;
import java.util.*;

public class Q1_Seieve_of_Eratothenes {


    // time comp : O(nlog(logn))

    public int countPrimes(int N) {
          
        boolean[] isPrime = new boolean[N+1] ;
        Arrays.fill(isPrime,true) ;
        
        // as 2 is first prime number so starts from 2 till i*i <= n
        for(int i = 2 ; i * i <= N ; i++ ){ // i*i is the first multiple where i is participating in inner loop so there's no sense in running the loop till i < n when the inner loop can't have any values for current i.
            if( isPrime[i] == true ) {
                for(int j = i * i ; j <= N ; j += i){ // starts from first optimal multiple.
                    isPrime[j] = false ;
                }
            }
        }
          
          
        // counting prime.
        int count = 0 ;
        for(int i = 2 ; i < N ; i++){
            if(isPrime[i] == true){
                count++;
            }
        }
        
        
        return count ;
       
      }
}
