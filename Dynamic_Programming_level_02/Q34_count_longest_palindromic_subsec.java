package Dynamic_Programming_level_02;

public class Q34_count_longest_palindromic_subsec {

    public static void main(String[] args) {
        
    }
    

    public static int get_count_substring(String s) {
        
        int n = s.length() ;

        boolean[][] dp = new boolean[n][n];
        int count = 0 ;

        // top down approch

        // gap strategy
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++,j++) {
                
                if(g==0){ // one char is always palindrome
                    dp[i][j] = true ;
                }
                else if(g==1){ // when gap is 1 so check if both same then store true else false.
                    dp[i][j] = s.charAt(i) == s.charAt(j) ;
                }
                else{ // else check
                    // if both char is same then go to diagonal and save its value as for palindrome substring both extreamityu should be same and mid part also be palindrome it self . so if diagonal element is true then store true else false.
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] ;
                    }
                    else{ // else false.
                        dp[i][j] = false ;
                    }
                }

                // increase count everytim if true,
                if(dp[i][j]){
                    count++;
                }
            }
        }

        return count ;
    }
}
