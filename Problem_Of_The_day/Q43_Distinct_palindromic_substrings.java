package Problem_Of_The_day;

import java.util.HashSet;

public class Q43_Distinct_palindromic_substrings {


    public static void main(String[] args) {
        
        palindromeSubStrs("abaaa") ;

    }

    static int palindromeSubStrs(String str) { 
    
        HashSet<String> set = new HashSet<>() ;
        
        for (int i = 0 ; i < str.length() ; i++) {

            for (int j = i ; j < str.length() ; j++) {  // "abaaa"

                if(isPalindrome(str,i,j)){
                  set.add( str.substring(i, j+1) )  ;
                }

            }

        }

        // System.out.println(set);

        return set.size() ;
    }

    private static boolean isPalindrome(String str, int i, int j) {

        while (i < j) {
            char ch1 = str.charAt(i) ;
            char ch2 = str.charAt(j) ;

            if(ch1 == ch2 ){
                i++ ;
                j-- ;
            }
            else{
                return false ;
            }
        }

        return true ;
    }
    

    // method 02  : using dp 


    static int palindromeSubStrs2(String str) { 

        boolean[][] dp = new boolean[str.length()][str.length()] ; 
    
        HashSet<String> set = new HashSet<>() ;
        
        for (int i = 0 ; i < str.length() ; i++) {

            for (int j = i ; j < str.length() ; j++) {  // "abaaa"

                if(isPalindrome2(str,i,j,dp)){
                  set.add( str.substring(i, j+1) )  ;
                }

            }

        }

        // System.out.println(set);

        return set.size() ;
    }

    private static boolean isPalindrome2(String str, int i, int j , boolean[][] dp) {

        if(i > j) return true ;

        if(dp[i][j] != false){
            return dp[i][j] ;
        }

        // while (i < j) {
        //     char ch1 = str.charAt(i) ;
        //     char ch2 = str.charAt(j) ;

        //     if(ch1 == ch2 ){
        //         i++ ;
        //         j-- ;
        //     }
        //     else{
        //         return false ;
        //     }
        // }

        if (str.charAt(i) != str.charAt(j) ) {
            return dp[i][j] = false ;
        }

        return dp[i][j] = isPalindrome2(str, i+1, j-1, dp) ;
    }


}
