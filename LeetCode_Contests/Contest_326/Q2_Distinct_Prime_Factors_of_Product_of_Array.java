package LeetCode_Contests.Contest_326;
import java.util.*;

public class Q2_Distinct_Prime_Factors_of_Product_of_Array {

    public int distinctPrimeFactors(int[] nums) {
        
        HashSet<Integer> ans = new HashSet<>() ; // store all the prime factors.
        
        // instead of multiplying all number factorize each num becuase jo final product hota usme jo bhi prime val hotey wo bas khud se he divide hotey toh indivisual he operate karo
        for(int val : nums){
            if(isPrime(val)){ // agar value phle se prime hai to add it already
                ans.add(val) ;
                continue;
            }
            
            int num = 2 ; // otherwise esko factorize karo
            
            while(num * num <= val){
                
                if(val % num == 0){  
                    if(isPrime(num)) ans.add(num) ; // agar num bhi prime hai toh usko bhi add karo
                }
                
                while(val % num == 0){
                    val = val/num ;
                }
                
                num++;
            }
            
            if(val > 1) ans.add(val) ; // check if any remainders left then it must be prime becuase it didn't get divided
        }
        
        return ans.size() ;
    }
    
    
    boolean isPrime(int val){
        if(val == 2) return true ;
        for(int i = 2 ; i * i <= val ; i++){
            if(val % i == 0) return false;
        }
        
        return true;
    }
}
