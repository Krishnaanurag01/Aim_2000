package Problem_Of_The_day;
import java.util.*;

public class Q295_Fill_up_buckets {

    public int totalWays(int n, int[] capacity) {
        
        Arrays.sort(capacity) ;
        long ans = 1; 
        long mod = (int)1e9+7 ;
        
        for(int i = 0 ; i < n ; i++){
            ans = ((ans * (capacity[i] - i)) % mod + mod ) % mod ; 
        }
        
        return (int)ans ;
    }
}
