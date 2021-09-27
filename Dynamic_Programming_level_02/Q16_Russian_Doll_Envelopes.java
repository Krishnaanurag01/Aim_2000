package Dynamic_Programming_level_02;

import java.util.Arrays;
import java.util.Comparator;

public class Q16_Russian_Doll_Envelopes {
    

    public static void main(String[] args) {
        
    }

    // same logic as Q15 (LIS BASED).


    // time is  : o(nlog n) and space is o(n).
    public static int get_total_envelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes , new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] ;   // sorting based on the width.
            }
            
        });

        int n = envelopes.length ;

        int[] dp = new int[n] ;
        int ans = 0 ;

        for (int i = 0; i < dp.length; i++) {
            
            int max = 0 ; 

            for (int j = 0; j < i ; j++) {
                // here comparing if width and height of j is less than i then update max.
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                   max =  Math.max(max, dp[j]) ;
                }
                
            }

            dp[i] = max+1 ; // and then same thing which we done in previous question. ( 1  denotes that previous max + 1 doll can ve russian enveloped).
            ans = Math.max(ans, dp[i]) ; // updating answer.
        }

        return ans ;

    }
}
