package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q14_All_Palindromic_Partitions {

    static ArrayList<ArrayList<String>> ans; // this will contain the answer.
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
       
        ans = new ArrayList<>() ;
        helper(S, new ArrayList<String>()) ;
        
        return ans ;
    }
    
    static void helper(String s , ArrayList<String> list ){
    
    if(s.length() == 0 ){ // base case
        ans.add( new ArrayList<String>(list) ) ; // adding answer so far we got in the answer list
        return ;
    }
    
    for(int i = 0 ; i < s.length() ; i++){
        
        String pta = s.substring(0,i+1) ; // finding the prefix substring
        String rest = s.substring(i+1) ; // and extracting the rest string
        
        if(isPalin(pta)){ // checking if prefix string is palindrome or not 
            // if yes the add the prefix string in list
            list.add(pta) ;
            helper(rest,list) ; // and move forward with the rest of the string
            list.remove( list.size() - 1 ) ; // now unvisit or remove the last added string
        }
    }
    }
    
    
    // function to check whether a given string is palindrome or not.
    static boolean isPalin(String str){
        int i = 0 ;
        int j = str.length() - 1 ;
        
        while(i < j){
            if(str.charAt(i) == str.charAt(j) ){
                i++ ;
                j-- ;
            }
            else{
                return false;
            }
        }
        
        return true ;
    }
    
}
