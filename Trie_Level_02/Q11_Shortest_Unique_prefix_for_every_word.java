package Trie_Level_02;

public class Q11_Shortest_Unique_prefix_for_every_word {

    // Trie DS nodes.
    static class Node{
        Node[] childs = new Node[26] ;
        int count = 0 ; // this will keep the details about how many children it has. 
        // the moment we find count equal to 1 then that would be our prefix. as these prefix strings does not comes in any other.
    }
    
    static Node root ;
    static String[] ans ;
    static int k  ;
    
    static String[] findPrefixes(String[] arr, int N) {
        
        root = new Node() ;
        ans = new String[N] ;
        k = 0 ;
        
        // first add all the strings.
        for(String s : arr){
            insert(s) ;
        }
        
        // now finding the unique prefix of each string.
        for(String s : arr){
           ans[k] = find(s) ;
           k++ ;
        }
        
        return ans ; 
    }
    
    public static String find(String s){
        
        Node curr = root ;
        
       for(int i = 0 ; i < s.length() ; i++ ){
           
           char ch = s.charAt(i) ;
           
           curr = curr.childs[ch - 'a'] ;
           
           if(curr.count == 1){ // if current node has count of 1 then substring till current node is our answer. 
               curr.count = -1 ;
               return s.substring(0,i+1) ;
           }
       }
        
        return null ;
    }
    
    
    // same old insert function.
    
    public static void insert(String word){
        
        Node curr = root ;
        
        for(int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch - 'a'] ;
            curr.count++ ; // increase the count denotes it contain count number of children
        }
    }
    
}


///                       2nd Method : It does not access the common prefix multiple times. It access every prefix just once.


class Solution {
    
    static class Node{
        Node[] childs = new Node[26] ;
        int count = 0 ;
        String str ; // this string is prefix string till current node.
    }
    
    static Node root ;
    static String[] ans ;
    static int k  ;
    
    static String[] findPrefixes(String[] arr, int N) {
        
        root = new Node() ;
        ans = new String[N] ;
        k = 0 ;
        
        for(String s : arr){
            insert(s) ;
        }
        
       find(root) ;
        
        return ans ; 
    }
    
    public static void find(Node curr){
        
        
       for(Node child : curr.childs){
           
           if(child != null && child.count != 1){
               find(child) ;
           }
           else if(child != null && child.count == 1){
               ans[k] = child.str ;
               child.count = 0 ;
               k++  ;
           }
       }
        
        return ;
    }
    
    
    
    public static void insert(String word){
        
        Node curr = root ;
        StringBuilder sb = new StringBuilder() ; // we will also add char of word in every iteration and we will store this string in each node .

        for(int i = 0 ; i < word.length() ; i++ ){
            char ch = word.charAt(i) ;
            sb.append(ch) ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch - 'a'] ;
            curr.str = sb.toString() ; // storing prefix string till now
            curr.count++ ; // and also storing count of children each node has.
        }
    }
    
    
};
