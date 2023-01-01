package LeetCode_Contests.Contest_326;
import java.util.*;

public class Q4_Closest_Prime_Numbers_in_Range {

    
    static boolean[] seive ;
    
    public int[] closestPrimes(int left, int right) {
        
        // first find all prime number using seive algo
        seive = new boolean[right + 1] ;
        Arrays.fill(seive, true) ;
        
        seive[1] = false;
        seive[0] = false;
        for(int i = 2 ; i * i < seive.length ; i++){
            if(seive[i] == true){
                for(int j = i + i ; j < seive.length ; j += i){
                    seive[j] = false ;
                }
            }
        }
        
        // now choosing the smallest gap answer
        int[] ans = {-1, -1} ;
        int gap = (int)1e9 ;
        int first = 0 ;
        int second = 0 ;
        
        for(int i = left ; i <= right ; i++){
            if(gap == 1) break ; // if gap is already least then break it.
            if(seive[i] == true){ // if current number is prime
                if(first == 0){
                    first = i ; // and first is nt present then make it present
                }
                else if(second == 0){ // make second present
                    second = i ; 
                    
                    if(second - first < gap){ // and check the gap
                        gap = second - first ;
                        ans[0] = first ;
                        ans[1] = second ;
                    }
                    
                }
                else{ // now taking the next adjecent prime number
                    first = second ;
                    second = i ;
                    
                    if(second - first < gap){
                        gap = second - first ;
                        ans[0] = first ;
                        ans[1] = second ;
                    }
                }
            }
        }
        
        return ans ;
    }
}
