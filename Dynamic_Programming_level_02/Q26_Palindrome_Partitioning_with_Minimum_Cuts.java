package Dynamic_Programming_level_02 ;



/**
 * Q26_Palindrome_Partitioning_with_Minimum_Cuts
 */
public class Q26_Palindrome_Partitioning_with_Minimum_Cuts {

    public static void main(String[] args) {
        
    }

    // method 01 : takes o(n3) time.

    public static int fewest_cuts(String str) {
        
        boolean[][] dp = new boolean[str.length()][str.length()] ; // this dp stores whether a string is palindrome or not.

        for (int g = 0; g < str.length() ; g++) { // using gap strategy.
            
            for (int i = 0 , j = g ; j < dp.length; i++ ,j++) {  // here i denotes row and j denotes column 
                
                if(g == 0){  // when gap is mark true
                    dp[i][j] = true ;
                }
                else if(g==1){ // when gap is 1 then compare both character if similar then mark true else mark false.
                    dp[i][j] = str.charAt(i) == str.charAt(j) ;
                }
                else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){ // else check if first char and last char is same and middle element is also palindrome then mark true.
                        dp[i][j] = true ;
                    }
                    else{ // else mark false.
                        dp[i][j] = false ;
                    }
                }
            }
        }


        int[][] strg = new int[str.length()][str.length()] ; // this will store total cuts on string for palindrome partition,


        for (int g = 0; g < str.length() ; g++) { // same gap strategy whihch used above.
            
            for (int i = 0 , j = g ; j < strg.length; i++ , j++) {
                
                if(g == 0){  // if gap is 0 then store 0
                    strg[i][j] = 0 ;
                }
                else if(g==1){ // else check if both character same then store as no cuts required to make palindrome else 1.
                    strg[i][j] = str.charAt(i) == str.charAt(j) ? 0 : 1 ;
                }
                else{

                    if(dp[i][j]){ // now check if current string is already palindorme then mark 0.
                        strg[i][j] = 0 ;
                    }
                    else{

                        // else find min by looking : eg. abccb : a | bccb , ab | ccb , abc | cb . abcc | b . and add 1 for current cut.
                    int min = Integer.MAX_VALUE ;

                    for(int k = i ; k < j  ; k++){

                        int left = strg[i][k] ;
                        int right = strg[k+1][j] ;

                        if( left+ right + 1 < min){
                            min = left + right + 1 ;
                        }
                    }

                    strg[i][j] = min ;
  
                    }

                }
            }
        }

        return strg[0][str.length()-1] ;
    }

    // method - 02 : o(n2) time.

    public static int get_palin_partition(String s) {
        
        int n = s.length() ;
        boolean[][] dp = new boolean[n][n] ; // this will store each substring of s if it is palindrome or not.

            
        for (int g = 0; g < n; g++) { // now using gap strategy.  same as above 
            
            for (int i = 0 , j = g ; j < dp.length; i++, j++) {
                
                if(g==0){
                    dp[i][j] = true ;
                }
                else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false ;
                }
                else{

                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false ;
                    }
                }
            }
        }


        int[] strg = new int[n]; // now making a 1d array which will store the totoal cut of each substring of s.
        strg[0] = 0 ;
        
        for (int j = 1 ; j < strg.length; j++) {
            if(dp[0][j]){  // if string is already palindrome then store 0 .
                strg[j] = 0 ;
            }
            else{
                // find cut.
                int min = Integer.MAX_VALUE ;

                
                for (int i = j ; i >= 1 ; i--) { // start from j to 1 we didn't go to 0 as if did this then the whole string would be selected.
                    if(dp[i][j]){/// checking if it palindrome
                        min = Math.min(min, strg[i-1]) ; // if yes then find count of cut in 0 to current index of string - 1 part.
                    }
                }

                strg[j] = min+1 ; // adding 1 cut becuase we are getting answer in partition.
            }
        }

        return strg[n-1] ;
    
    }
}