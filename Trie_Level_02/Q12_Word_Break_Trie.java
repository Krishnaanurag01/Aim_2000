package Trie_Level_02;
import java.util.*;

public class Q12_Word_Break_Trie {

    static class Node{
        Node[] childs = new Node[26] ;
        String str ;
    }
    
    static Node root ;
    
    /// given function
    public static int wordBreak(String A, ArrayList<String> B )
    {
        root = new Node() ;
        
        // inserting the Strings in TRIE DS first.
        for(String s : B){
            insert(s) ;
        }
        
        return breakDown(A) ? 1 : 0 ; // // this recursive function will check if a given sequence is valid or not
    }
    
    
    public static boolean breakDown(String word){
     
     if(word.length() == 0)
     return true; 
     
     for(int i = 1 ; i <= word.length() ; i++ ){
          // we will look for every substring from 0 to i and check if sequence is valid or not
         String subStr = word.substring(0,i) ;
         
         // checking if current substring is valid then we will call this function for i till end substring
         if(search(subStr) && breakDown(word.substring(i)) ){
             return true ;
         }
     }
     
     return false; 
        
    }
    
    
    // this will check whether the given word exist or not in TRIE.
    public static boolean search(String word){
        
          Node curr = root ;
        
        for(int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i) ;
            
            curr = curr.childs[ch - 'a'] ;
            
            if(curr == null) return false;
        }
        
        if(curr.str != null)
        return curr.str.equals( word ) ? true : false;
        
        return false;
    }

    
    // same old function
    public static void insert(String word){
        
          Node curr = root ;
        
        for(int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch - 'a'] ;
        }
        
        curr.str = word; 
        
    }
    
}
