package Dynamic_Programming_extras;
import java.util.*;

public class Q76_Integer_Replacement {

    // using map for storage.
    static HashMap<Long,Integer> map ;
    public int integerReplacement(int n) {
        map = new HashMap<>() ;
        return helper(n) ;
    }
    int helper(long n){
        if(n < 0) return (int)1e8;
        if(n == 1) return 0 ;
        if(map.containsKey(n)) return map.get(n) ;
        
        if(n % 2 == 0){
            int value = 1 + helper(n/2) ;
            map.put(n,value) ;
            return value ;
        }
        else{
            int plus = 1+ helper(n+1);      
            int minus = 1 + helper(n-1);
            map.put(n,Math.min(plus,minus)) ;
            return Math.min(plus,minus) ;
        }
    }
}
