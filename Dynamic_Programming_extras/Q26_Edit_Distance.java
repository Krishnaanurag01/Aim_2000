package Dynamic_Programming_extras ;

public class Q26_Edit_Distance {

    // using memoization : 

    public int minDistance(String word1, String word2) {
        
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1] ;
        return helper(word1.length()-1, word2.length()-1,word1,word2,dp) ;
    }
    
    static int helper(int l1, int l2, String w1, String w2,Integer[][] dp){
        // if(l1 == -1 && l2 == -1) return 0 ;
                if(l1 == -1 ) return l2+1 ;
                if(l2 == -1 ) return l1+1 ;

        if(dp[l1][l2] != null) return dp[l1][l2] ;
        
        char ch1 = w1.charAt(l1) ;
        char ch2 = w2.charAt(l2) ;
        
        if(ch1 == ch2){ // if char are same then compare the next seqeunce and return
            return helper(l1-1,l2-1,w1,w2,dp) ;
        }
        
        int insert = 1 + helper(l1,l2-1,w1,w2,dp) ; // inserting curr ch1
        int delete = 1 + helper(l1-1,l2,w1,w2,dp) ; // deleteing ch1
        int replace =1 + helper(l1-1,l2-1,w1,w2,dp) ;// replacing ch1
        
        return dp[l1][l2] = Math.min(insert, Math.min(delete,replace)) ;        
    }
    



    // using tabulations : // converted memo into tabulations

    public int minDistance2(String word1, String word2) {
        
        int[][] dp = new int[word1.length()+1][word2.length()+1] ;
        for(int j = 0 ; j <= word2.length() ; j++) dp[0][j] = j ; // handling base case when first string becomes nulll then total step it need is j
        
        for(int i = 1 ; i <= word1.length() ; i++){
            for(int j = 0 ; j <= word2.length() ; j++){
                if(j == 0) dp[i][0] = i ; // handling second base case
                else{
                    
                    char ch1 = word1.charAt(i-1) ;
                    char ch2 = word2.charAt(j-1) ;
        
                    if(ch1 == ch2){ // if both char same then store previous data
                      dp[i][j] = dp[i-1][j-1] ;
                        continue ;
                     }
        
                     // else find the min step in below
                 int insert = 1 + dp[i][j-1] ;
                 int delete = 1 + dp[i-1][j] ;
                 int replace =1 + dp[i-1][j-1] ;
                    
                 dp[i][j] = Math.min(insert, Math.min(delete,replace)) ;           
                }
            }
        }
        
        return dp[word1.length()][word2.length()] ;
    }




    // space optimized solution of tabulation: 

    public int minDistance3(String word1, String word2) {
        
        int[] dp = new int[word2.length()+1] ; // holding the previous row
        for(int j = 0 ; j <= word2.length() ; j++) dp[j] = j ;
        
        for(int i = 1 ; i <= word1.length() ; i++){
            int[] curr = new int[word2.length()+1] ; //and this is the current row
            for(int j = 0 ; j <= word2.length() ; j++){
                if(j == 0) curr[0] = i ;
                else{
                    
                    char ch1 = word1.charAt(i-1) ;
                    char ch2 = word2.charAt(j-1) ;
        
                    if(ch1 == ch2){
                      curr[j] = dp[j-1] ;
                        continue ;
                     }
        
                 int insert = 1 + curr[j-1] ;
                 int delete = 1 + dp[j] ;
                 int replace = 1 + dp[j-1] ;
                    
                 curr[j] = Math.min(insert, Math.min(delete,replace)) ;           
                }
            }
            dp = curr ; // current row becomes prev
        }
        
        return dp[word2.length()] ;
    }
}