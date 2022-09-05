package Dynamic_Programming_random;

public class Q1_Strange_Printer {

    // using gap strategy.
    public int strangePrinter(String s) {
        
        int[][] dp = new int[s.length()][s.length()] ;
        
        for(int g = 0 ; g < s.length() ; g++){
            for(int i = 0, j = g ; j < s.length() ; i++, j++){
                
                if(g == 0 ){ // when gap is 0 then only 1 char is present so it will take 1 turn
                    dp[i][j] = 1 ;
                }
                else if (g == 1){ // when gap is 1 then only 2 char present and bothare same then 1 turn o/w 2 turn
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 2 ;
                }
                else{
                    int min = (int)1e9 ;
                    // otherwise we have to make partition and check.
                    // we are doing partition like so i-j -> (i->k) + (k+1 -> j)
                    for(int k = i ; k + 1 <= j ; k++){
                       min = Math.min(min ,dp[i][k] + dp[k+1][j]) ;
                    }
                    
                    if(s.charAt(i) == s.charAt(j)) min-- ; // if both end char is same then reduce 1 turn as we are assuming that we created a sequence of this same char of i-j+1 size initially.
                    
                    dp[i][j] = min ;
                }
            }
        }
        
        return dp[0][s.length() - 1] ;
    }
}
