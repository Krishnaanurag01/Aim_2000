package Trie_Level_02;

public class Q1_Implement_Trie {

    // starts from here. 
    // used Array here.

    static class Trie {
    
        static class Node{
            
            Node[] child ;
            boolean isEnd ; // denotes any particular string ends here
            
            Node(){
                child = new Node[26] ; // becuase there are 26 alphabets in total.
            }
        }


        
        static Node root ;
    
        public Trie() {
            root = new Node() ;
        }
        


        public void insert(String word) {
            
            Node curr = root ;
            
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i) ;
                
                if(curr.child[ch - 'a'] == null ){
                    curr.child[ch - 'a'] = new Node() ; // if not present then add a node
                }
                
                curr = curr.child[ch-'a'] ; // moving next node.
            }
            
            curr.isEnd = true ; // also marking that this word ends here.
            
        }
        
        public boolean search(String word) {
            
             Node curr = root ;
            
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i) ;
                
                if(curr.child[ch - 'a'] == null ){
                    return false ;  // if not present then return false.
                }
                
                // when present.
                curr = curr.child[ch-'a'] ; // moving next node.
            }
            
            if(curr.isEnd == true){ /// checking if word ends here.
                return true ;
            }
            
            return false; 
            
        }
        
        public boolean startsWith(String prefix) {
            
            
             Node curr = root ;
            
            for(int i = 0 ; i < prefix.length() ; i++){
                char ch = prefix.charAt(i) ;
                
                if(curr.child[ch - 'a'] == null ){
                    return false ;  // if not present then return false.
                }
                
                // when present.
                curr = curr.child[ch-'a'] ; // moving next node.
            }
            
            return true ;
        }
    }
    
}
