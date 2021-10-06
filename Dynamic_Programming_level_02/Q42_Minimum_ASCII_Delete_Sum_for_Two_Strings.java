package Dynamic_Programming_level_02;

public class Q42_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    public static void main(String[] args) {
        
    }


    // bottom up approach.
    public static int get_min_ascii_delete_sum(String s1 , String s2) {
        
        int n1 = s1.length() ;
        int n2 = s2.length() ;

        int[][] dp = new int[n1+1][n2+1] ;

        for (int i = n1 ; i >= 0 ; i--) {
            for (int j = n2 ; j >= 0 ; j--) {
                // when In last rows last col store 0.
                if(i == n1 && j == n2){
                    dp[i][j] = 0 ;
                }
                else if(i == n1){ // when in last row then add col char with its right value
                    dp[i][j] = s2.charAt(j) +  dp[i][j+1] ;
                }
                else if(j == n2){ // when in last col then add current row char with its below value.
                    dp[i][j] = s1.charAt(i) + dp[i+1][j] ; 
                }
                else{ 
                    // now took both characters.
                    char c1 = s1.charAt(i); // row char
                    char c2 = s2.charAt(j) ; // col char

                    if( c1 == c2){ // if same then store diagonal value.
                        dp[i][j] = dp[i+1][j+1] ;
                    }else{ // else find min of current row char with below data and current char with right value. 
                        dp[i][j] = Math.min(c1 + dp[i+1][j], c2 + dp[i][j+1]) ;
                    }
                }
            }
        }

        return dp[0][0] ;

    }
    
}
