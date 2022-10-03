package Super_Important ;
import java.util.*;

public class Q3_Modified_Numbers_and_Queries {

    public int sumOfAll(int l, int r)
    {
        boolean[] seive = new boolean[r+1] ;
        Arrays.fill(seive, true) ;
        int sum = 0 ;
        
        if(l < 2){ // adding this becuase when l starts from 1 then we are ignoring 1 in below steps so adding 1 initially
            sum = 1 ;
        }
        
        // using seive of eratothenes and segmented seive combined.
        
        for(int i = 2 ; i < seive.length ; i++){ // this is seive of eratothenes here instead of codintion i*i < n we changed to traversing every element because if i is 2 then it is prime factor of itself 
             if(seive[i] == true){ // making mutliples false.
                for(int j = i + i ; j < seive.length ; j += i){
                    seive[j] = false ;
                }
                
                
                // NOW USING SEGMENTED SEIVE IN IT.
                
                int first_multiple = (l/i)*i ; // getting the first value of range in between L and R where i(prime valu) is participating.
                if(first_multiple < l) first_multiple += i ; // if it is less than L then add prime again.
                    
                for(int j = first_multiple ; j <= r ; j += i){ // now going till n
                    sum += i ; // and storing in our answer instead of storing in any array. this denotes that jth value has i as prime factor.
                }
                
            }
        }
        
        
        return sum ;
    }
}
