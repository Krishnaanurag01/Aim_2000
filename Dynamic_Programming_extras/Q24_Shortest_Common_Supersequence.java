package Dynamic_Programming_extras;

public class Q24_Shortest_Common_Supersequence {

    
    // using lcs in it.
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1] ;
        
        // find lcs first.
        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1 ; j <= str2.length() ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) 
                    dp[i][j] = 1+dp[i-1][j-1] ;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) ;
        }}}
        
        System.out.println(dp[str1.length()][str2.length()]) ;
            

        // now making answer string.
        StringBuilder sb = new StringBuilder() ;
            
            int i = str1.length() ;
            int j = str2.length() ;
            
            while(i > 0 && j > 0){
                if(str1.charAt(i-1) == str2.charAt(j-1)){ // if both same then add once and reduce both pointer by 1
                    sb.append(str1.charAt(i-1))  ; 
                    i-- ;
                    j-- ;
                }
                else if(dp[i][j-1] > dp[i-1][j]){ // if left side is greater then add j
                    sb.append(str2.charAt(j-1)) ;
                    j-- ;
                }
                else{
                    sb.append(str1.charAt(i-1)) ; // else add ith char
                    i-- ;
                }
            }

            // add if any remainning
            
            while(i > 0 ){
               sb.append(str1.charAt(i-1)) ;
                i-- ;
            }
            
            while( j > 0 ){
                sb.append(str2.charAt(j-1)) ;
                j-- ;
            }
        
        return sb.reverse().toString() ;      // returning reverse becuase we made string from n point to 0 index.  
    }


    // when ask for count.


    public static int shortestCommonSupersequence(String str1,String str2,int m,int n)
    {
        
         int[][] dp = new int[str1.length()+1][str2.length()+1] ;
        
        // find lcs first.
        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1 ; j <= str2.length() ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) 
                    dp[i][j] = 1+dp[i-1][j-1] ;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) ;
        }}}
        
        // System.out.println(dp[str1.length()][str2.length()]) ;
            
        // StringBuilder sb = new StringBuilder() ;
        int count = 0; 
            
            int i = str1.length() ;
            int j = str2.length() ;
            
            while(i > 0 && j > 0){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // sb.append(str1.charAt(i-1))  ; 
                    count++ ;
                    i-- ;
                    j-- ;
                }
                else if(dp[i][j-1] > dp[i-1][j]){
                    // sb.append(str2.charAt(j-1)) ;
                    count++ ;
                    j-- ;
                }
                else{
                    // sb.append(str1.charAt(i-1)) ;
                    count++ ;
                    i-- ;
                }
            }
            
            while(i > 0 ){
            //   sb.append(str1.charAt(i-1)) ;
               count+= i ;
                i = 0 ;
            }
            
            while( j > 0 ){
                // sb.append(str2.charAt(j-1)) ;
                count+= j ;
                j = 0 ;
            }
        
        return  count ;        

      
    }
}
