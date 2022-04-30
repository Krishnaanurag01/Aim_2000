package Problem_Of_The_day;

public class Q57_Form_A_Palindrome {

    // 1st Approch : finding the longest palindromic subsequence (LPS) then Substracting it from the string length. it will give the count of characters that has odd frequency. so for a palindrome all the char should have even freq  or only one char can have odd freq

    int findMinInsertions(String S){
        // code here
        int n = S.length() ;
        int[][] dp = new int[n][n] ;
        
        // this is LPS : check explanation in DP level-02 Q32
        
        for(int g = 0 ; g < n ; g++){
            for(int i = 0 , j = g ; j < n ; i++ , j++){
                
                if(g == 0){
                    dp[i][j] = 1 ;
                }
                else if(g == 1){
                    dp[i][j] = S.charAt(i) == S.charAt(j) ? 2 : 1 ;
                }
                else{
                    
                    if(S.charAt(i) == S.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1] ;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]) ;
                    }
                    
                }
                
            }
        }
        
        return S.length() - dp[0][n-1] ;
    }

    // method 02 : It solving the exact problem instead of finding LPS.

    int findMinInsertions2(String S){
        // code here
        int n = S.length() ;
        int[][] dp = new int[n][n] ;
        
        
        for(int g = 0 ; g < n ; g++){
            for(int i = 0 , j = g ; j < n ; i++ , j++){
                
                if(g == 0){ // at gap 0, one char present so it is already palindrome. so we neeed 0 insertions for it.
                    dp[i][j] = 0 ;
                }
                else if(g == 1){ // at gap 1 , 2 char present so if both char equal then 0 else we need 1 char insertion to make it palindrome. eg: ab -> inserted a -> aba or when inserted b -> bab 
                    dp[i][j] = S.charAt(i) == S.charAt(j) ? 0 : 1 ;
                }
                else{
                    
                    if(S.charAt(i) == S.charAt(j)){ // if both end character same then we don't need to add any character so we will assign the count of middle string insertion in it. ama -> store the count to make m palindrome
                        dp[i][j] = dp[i+1][j-1] ;
                    }
                    else{ // else we will add one char at any end and add with min of prefix or suffix.
                        dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i+1][j]) ;
                    }
                    
                }
                
            }
        }
        
        // now returning the answer.
        //
        return dp[0][n-1] ;
    }
    
}
