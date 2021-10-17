package Dynamic_Programming_level_02;

import java.util.HashMap;

public class Q37_Count_Distinct_Palindromic_Subsequences {


    public static void main(String[] args) {
        
    }

    public static int get_count_distinct_subsec(String s) {
        
        int n = s.length() ;
        int[][] dp = new int[n][n] ;

        int[] next = new int[n] ;  // this will store the index of every arr[i] next index 
        int[] prev = new int[n] ; // and this store the previous arr[i] index.

        HashMap<Character,Integer> map = new HashMap<>() ;

        for (int i = 0; i < n ; i++) {
            
            char ch = s.charAt(i) ;

            if(map.containsKey(ch) == false){
                prev[i] = -1 ;
            }
            else{
                prev[i] = map.get(ch) ;
            }

            map.put(ch, i) ;
        }

        map.clear(); 


        for (int i = n-1 ; i >= 0 ; i--) {
            
            char ch = s.charAt(i) ;

            if(map.containsKey(ch) == false){
                next[i] = n ;
            }
            else{
                next[i] = map.get(ch) ;
            }

            map.put(ch, i) ;
        }


        // using gap strategy : 

        /* formula : 

        when c != c2 : dps(c1m) + dps(mc2) - dps(m)
        
        when c == c2 : 
        if a ------ a : 2*dps(m) + 2 ;
        if a ----a ------- : 2*dps(m) + 1 ;
        if a ---- a --- a ------ : 2*dps(m) - dps(m') ;
                    |^|
                     m' 

        */


        for (int g = 0; g < n ; g++) {
            
            for (int i = 0 , j = g ; j < prev.length; i++,j++) {
                
                if(g== 0){
                    dp[i][j] = 1 ;
                }
                else if(g==1){
                    dp[i][j] = 2 ;
                }
                else{
                    char sc = s.charAt(i) ;
                    char ec = s.charAt(j) ;

                    if(sc != ec){
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] ;
                    }
                    else{

                        int nc = next[i] ;
                        int pc = prev[i] ;


                        if( nc > pc){
                            dp[i][j] = 2*dp[i+1][j-1] + 2 ;  
                        }
                        else if(nc == pc){
                            dp[i][j] = 2*dp[i+1][j-1] + 1 ;
                        }
                        else{
                            dp[i][j] = 2*dp[i+1][j-1] - dp[nc+1][pc-1] ;
                        }
                    }
                }
            }
        }

        return dp[0][n-1] ;


    }
    
}
