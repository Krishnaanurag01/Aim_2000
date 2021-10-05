package Dynamic_Programming_level_02;

import java.util.HashMap;

public class Q36_Number_of_distinct_subsequences {

    public static void main(String[] args) {
        
    }
    public static int count_distinct_subsec(String s) {
        
        int n = s.length() ;

        int[] dp = new int[n+1] ; // making  dp of size + 1 .
         dp[0] = 1 ;
        int mod = 1_000_000_007;

        HashMap<Character,Integer> map = new HashMap<>() ;

        for (int i = 1; i < dp.length; i++) {
            
            dp[i] = (2*dp[i-1])%mod ; // store previous subsequence * 2. directly

            if(map.containsKey(s.charAt(i-1))){ // now chheck if exist in hashtable then get value of that key and subtract.
                dp[i] = (dp[i]  - dp[map.get(s.charAt(i-1)) - 1] + mod )%mod;
            }

            map.put(s.charAt(i-1), i); // now putting into the map.
            
        }

        return dp[s.length()] -1 ;
    }
}
