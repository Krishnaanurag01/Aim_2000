package Contests;
import java.util.*;
public class Q5_Subarray_counting {

    public static long solve(int N, int[] A) {
        long ans = 0 ;
        
        // brute force will work only becuase we are finding gcd in continuos elements and after some elements the gcd of contin element will surely be 1 because of different numbers so we are using break statement.
        
        for(int i = 0 ; i < N ; i++){
            int gcd = 0 ;
            HashSet<Integer> set = new HashSet<>() ;
            for(int j = i ; j < N ; j++){
                gcd = getGcd(gcd,A[j]) ;
                if(set.contains(gcd)) break ; // if already present then break.
                ans++ ;
                set.add(gcd) ;
            }
        }
        
        return ans ;
    }
    
    
    // normal gcd function.
    static int getGcd(int a, int b){
        if(b == 0 ) return a ;
        return getGcd(b, a % b) ;
    }
}
