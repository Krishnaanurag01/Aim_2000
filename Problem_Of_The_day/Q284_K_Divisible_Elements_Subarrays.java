package Problem_Of_The_day;
import java.util.*;

public class Q284_K_Divisible_Elements_Subarrays {

    
    public int countDistinct(int[] nums, int k, int p) {

        HashSet<String> set = new HashSet<>() ;
        
        for(int i = 0 ; i < nums.length ; i++){
            int divisible = 0 ;
            StringBuilder sb = new StringBuilder() ;

            for(int j = i ; j < nums.length; j++){
                if(nums[j] % p == 0) divisible++ ;
                sb.append( "-" + nums[j]) ;
                if(divisible <= k ) set.add(sb.toString()) ;
                else break ;
            }
        }
        
        return set.size(); 
    }
}
