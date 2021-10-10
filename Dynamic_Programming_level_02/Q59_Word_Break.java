package Dynamic_Programming_level_02;

import java.util.ArrayList;

public class Q59_Word_Break {

    public static void main(String[] args) {
        
    }

    public static boolean name(String s , ArrayList<String> list) {
        
        int[] dp = new int[s.length()] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i ; j++) {
                
                String tString = s.substring(j,i+1); // extracting string

                if(list.contains(tString)){ // if list has this string then
                    if(j>0){ // check if j is greater than 0 then add with previous dp[j]
                        dp[i] += dp[j-1] ;
                    }
                    else{ // else if j = 0 then means its out first word so store 1.
                        dp[i] = 1 ;
                    }
                }
            }
        }


    

        return dp[s.length() - 1] > 0  ;
    }
    
}
