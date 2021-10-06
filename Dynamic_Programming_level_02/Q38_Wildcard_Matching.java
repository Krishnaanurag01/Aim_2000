package Dynamic_Programming_level_02;

public class Q38_Wildcard_Matching {

    public static void main(String[] args) {
        
    }
    

    public static int will_match(String str , String patt) {


        int s = str.length() ;
        int p = patt.length() ;
        
        // dp row is made up of pattern and column is made up of string.
        boolean[][] dp = new boolean[p+1][s+1] ;

        for (int i = p ; i >= 0 ; i--) {  
            for (int j = s ; j >= 0 ; j-- ) {
                
                if(i == p && j == s){  // when both are the last row and last col then true.
                    dp[i][j] = true ;
                }
                else if(i==p){ // else last row is false
                    dp[i][j] = false ;
                }
                else if(j==s){
                   // last col is false excpet "*" when this comes look below
                    dp[i][j] = patt.charAt(i) == '*' ? dp[i+1][j] : false ;
                }
                else{
                    char ptr = patt.charAt(i) ; // got pattern

                    if(ptr == '*'){ // if it is "*" then look right and below if true any one side then true
                        dp[i][j] = dp[i][j+1] || dp[i+1][j] ;
                    }
                    else if(ptr == '?'){ // when this comes look diagonally
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else{
                        if(patt.charAt(i) == str.charAt(j)){ // when both char is same then diagonally
                            dp[i][j] = dp[i+1][j+1] ;
                        }
                        else{ // else false
                            dp[i][j] = false ;
                        }
                    }
                }
            }
        }

        return dp[0][0] == true ? 1 : 0 ;
    }
}
