package Dynamic_Programming_extras;
import java.util.*;

public class Q37_Largest_Divisible_Subset {

    // same as LIS , Only chnage is here we changed one conditon and sort the array
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums) ; // sorting helps in choosing the number that is divisible by anyone within same set
        int n = nums.length ;
        int[] dp = new int[n] ;
        int[] hash = new int[n] ;
        
        int ansIdx = 0 ;
        int maxLen = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            hash[i] = i ;
            int max = (int)-1e9 ;
            
            for(int j = 0 ; j < i ; j++){
                if( nums[i] % nums[j] == 0 && max < dp[j]){ // instead of finding the smaller value only we are finding the value(as array sorted then automatically smaller )which can divide current number.  
                    max = dp[j] ;
                    hash[i] = j ;                    
                }
            }
            
            dp[i] = max != (int)-1e9 ? max+1 : 1 ;
            if(maxLen < dp[i]){
                maxLen = dp[i] ;
                ansIdx = i ;
            }
        }
        
        List<Integer> list = new ArrayList<>() ;
     
        list.add(nums[ansIdx]) ;
        while(hash[ansIdx] != ansIdx){
            list.add( nums[ hash[ansIdx] ] ) ;
            ansIdx = hash[ansIdx] ;
        }
        Collections.reverse(list) ;
        return list ;
}
    
}
