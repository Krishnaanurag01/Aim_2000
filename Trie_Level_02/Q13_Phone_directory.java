package Trie_Level_02;
import java.util.*;

public class Q13_Phone_directory {

    static class Node{
        Node[] childs = new Node[26] ;
        String str ;
    }
    
    static Node root ;
    
    
    // same old insert function.
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
    
    
    public static void find(String prefix, ArrayList<String> list ){ // this function will find the node of last char of prefix.
        
        Node curr = root ;
        
        for(int i = 0 ; i < prefix.length() ; i++ ){
            
            char ch = prefix.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){ // if node is not present then return list with "o"
                list.add("0") ;
                return ;
            }
             // else move to next node.
            curr = curr.childs[ch - 'a'] ;
        }
        
        // this helper function will help us in accessing every word that has gievn prefix in it. 
        findHelper(curr,list) ;
    }
    
    public static void findHelper(Node curr , ArrayList<String> list ){
        
        // checking if string is present then it is one the answer. so adding it to the list.
        if(curr.str !=  null){
            list.add(curr.str) ;
        }
        
        // accessing every child
        for(Node child : curr.childs){
            if(child != null){
                findHelper(child,list) ;
            }
        }
        
    }
    

    // Main given function : 
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
       root = new Node() ;
       
       // adding every word in the TRIE first.
       for(String cont : contact){
           insert(cont) ;
       }
       
       ArrayList<ArrayList<String>> ans = new ArrayList<>() ;
       
       // now checking words with corresponds to every prefix .substring
       for(int i = 1 ; i <= s.length() ; i++ ){
           
           String ss = s.substring(0,i) ;
           
           ArrayList<String> inAns = new ArrayList<>() ; 
           find(ss, inAns) ;
           // adding answer of current substring in ans list.
           ans.add(inAns) ;
       }
       
       return ans ;
    }
    
}
