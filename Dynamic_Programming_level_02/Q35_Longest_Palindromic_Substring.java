package Dynamic_Programming_level_02;

public class Q35_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        

        get_longest_palindromic_substr("aaaabbaa");
    }
    


    // doing same as Q35
    public static void get_longest_palindromic_substr(String s ) {
        
        boolean[][] dp = new boolean[s.length()][s.length()] ;
        int len = 0 ;
        String os = "" ;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0 , j = g ; j < dp.length; i++,j++) {
                
                if(g==0){
                    dp[i][j] = true ;
                }
                else if(g==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ;
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){

                        dp[i][j] = dp[i+1][j-1] ;
                    }
                    else{
                        dp[i][j] = false ;
                    }

                }

                // when current dp is true and g+1 (as gap 0 has 1 element so on..) is greater than len (length of last answer) then update and 
                // also update the substring
                if(dp[i][j] && len < g+1){
                    len = g+1 ;
                    os = s.substring(i,j+1) ;
                }

            }
        }

        System.out.println(len + " -> "+ os);
    }
}
