package Trie_Level_02;

public class Q9_Stream_of_Characters {
    
}

class StreamChecker {
    
    class Node{
        Node[] childs = new Node[26];
        boolean isEnd ;
    }
    
    private static  Node root ;
    private static  StringBuilder sb ;

    public StreamChecker(String[] words) {
        
        root = new Node() ;
        sb = new StringBuilder() ;
        
        
        // adding every word of the array in reverse order in trie ds.
    
        
        for(String word : words){
            
             Node curr = root ;
            
            for(int i = word.length() - 1 ; i >= 0 ; i--){
                char ch = word.charAt(i) ;
                
                if(curr.childs[ch - 'a'] == null ){
                    curr.childs[ch - 'a'] = new Node() ;
                }
                
                curr = curr.childs[ch - 'a'] ;
            }
            
            curr.isEnd = true ;
        }
        
    }
    
    public boolean query(char letter) {
        
        sb.append(letter) ; // adding the letter in sb first
        
        Node curr = root ;
        
        for(int i = sb.length() - 1 ; i >= 0 ; i--){ // now checking from last char of sb to first char
            char ch = sb.charAt(i) ;
            
            curr = curr.childs[ ch - 'a' ] ; 
            
            if(curr == null) return false ;
            if(curr.isEnd == true) return true ; // if we found any end then return true.
            
            
        }
        
        if (curr.isEnd) return true ; 
        
        return false ;
    }
}

