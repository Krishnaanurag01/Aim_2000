package Dynamic_Programming_level_02;

public class Q39_Longest_Common_Substring {

    public static void main(String[] args) {
        
    }


    // bottom up approach, Works on a single run.(my own code)

    public static int get_longest_common_substring(String s1 , String s2 ) {
        
        int n1 = s1.length() ;
        int n2 = s2.length() ;

        int len = 0 ;

        int[][] dp = new int[n1 + 1 ][n2 + 1 ] ;


        // starting from bottom.
        for (int i = n1 ; i >= 0 ; i--) {
            for (int j = n2 ; j >= 0 ; j--) {

                if(i == n1 || j == n2){ // last col || row will be 0 .
                    dp[i][j] = 0 ;
                }
                else{
                    if(s1.charAt(i) == s2.charAt(j) ){ // when same take diagonal value and add 1.
                        dp[i][j] = 1 + dp[i+1][j+1] ;
                    }
                    else{
                        dp[i][j] = 0 ; // store 0 else.
                    }
                }
                
                if( len < dp[i][j]){ //  update len.
                    len = dp[i][j] ;
                }
            }
        }

        return len ;
    }

    // top down approach.

    public static int get_longest_common_substring2(String s1, String s2) {

        int n1 = s1.length() ;
        int n2 = s2.length() ;
        int len = 0 ;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(i == 0 || j == 0){
                    dp[i][j] = 0 ;
                }
                else{
                    dp[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 + dp[i-1][j-1] : 0 ;
                }

                if( len < dp[i][j]){
                    len = dp[i][j] ;
                }
            }
        }
        
        return len ;
    }
}
