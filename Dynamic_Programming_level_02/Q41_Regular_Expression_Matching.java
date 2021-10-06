package Dynamic_Programming_level_02;

public class Q41_Regular_Expression_Matching {

    public static void main(String[] args) {
        
    }

    public static boolean regular_expr_matching(String s , String ptr) {
        
        int slen = s.length() ;
        int plen = ptr.length() ;

        boolean[][] dp = new boolean[plen+1][slen+1] ;

        // top down approach pattern is row side and string is column side.
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(i==0 && j == 0){ // this will always be 0 as "-" == "-"
                    dp[i][j] = true ;
                }
                else if(i==0){ // else false
                    dp[i][j] = false ;
                }
                else if(j==0){ // now in this column if char of pattern is "*" then look above i-2 if its true then true else false.
                    dp[i][j] = ptr.charAt(i-1) == '*' && i > 1 ? dp[i-2][0] : false ;
                }
                else{ // we are finding char by i-1 and j-1 becuase first column is "_" , then "first char" and so on.
                    char pc = ptr.charAt(i-1);
                    char sc = s.charAt(j-1) ;

                    if(pc == sc || pc == '.'){ // in this case look diagonally.
                        dp[i][j] = dp[i-1][j-1] ;
                    }
                    else if( pc == '*'){ // if this comes look aove i-2
                            dp[i][j] = dp[i-2][j] ;

                            char previousChar = ptr.charAt(i-2) ;

                            // if '*' above character is same as current string char then you can also check left column if true then store true.
                            if(previousChar == s.charAt(j-1) || previousChar == '.'){
                                dp[i][j] = dp[i-2][j] || dp[i][j-1] ;
                            }
                    } // else false.
                    else{
                        dp[i][j] = false ;
                    }
                }

            }
        }

        return dp[plen][slen] ;
    }
    
}
