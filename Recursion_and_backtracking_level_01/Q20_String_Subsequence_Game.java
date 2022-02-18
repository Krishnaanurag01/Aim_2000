package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q20_String_Subsequence_Game {
    
    static TreeSet<String> set  ;
    static TreeSet<String> allPossibleSubsequences(String s) {
        // code here
        
       set = new TreeSet<>() ; // this will store string in sorted manner
       
       helper(s,"") ;
       
    //   System.out.println("count " + count ) ;
        
        return set ;
    }
    
    static void helper(String s, String ns){
        
        if(s.length() == 0 ){ // base case
            
            if(ns.length() > 0 ){ // if our new string length is greaer than 2
            char fc = ns.charAt(0) ; // getting first char
            char lc = ns.charAt( ns.length() - 1 ) ; // getting second char
            // System.out.println(ns +" last -.> "+ lc ) ;

            if( isVowel(lc) ){ // if last char is vowel then we won't add as last char should be consonant
                return ;
            }
            else if( !isVowel(fc) ){ // if first char is not vowel then return don't add it to answer
                return ;
            }
            else{ // else it is following both the case so add it to the answer
                // System.out.println(ns) ;
                set.add(ns) ;
            }
            
            }
            
            return ;
        }
        
        char fc = s.charAt(0) ;
        String rest = s.substring(1) ;
    
            helper(rest,ns+fc) ; 
            helper(rest,ns) ;
        
        
    }
    
    static boolean isVowel(char lc){
        
         if( lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u' ){
                return true ;
        }
        
        return false;
    }

}
