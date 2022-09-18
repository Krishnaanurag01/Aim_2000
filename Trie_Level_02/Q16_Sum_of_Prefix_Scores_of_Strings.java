package Trie_Level_02;

public class Q16_Sum_of_Prefix_Scores_of_Strings {

      
    // using Trie Data Structure.
    class TrieNode{
        TrieNode[] childs = new TrieNode[26] ;
        int count ;
    }
    
    TrieNode root ;
    
    // this function add given word in trie and at the same time also increase the count of prefix.
    void addToTrie(String word){
        TrieNode curr = root ;
        
        for(char ch : word.toCharArray()){
            int idx = ch - 'a' ;
            if(curr.childs[idx] == null){ // moving next node by first creating if null
                curr.childs[idx] = new TrieNode() ;
            }
            curr = curr.childs[idx] ;
            curr.count++ ; // now increasing the count of string till node(prefix)
        }
    }
    
    
    // this function get the count of all prefix of passed word.
    int getPrefixCount(String s){
        TrieNode curr = root ;
        int count = 0 ;
        for(char ch : s.toCharArray()){
            int idx = ch - 'a' ;
            curr = curr.childs[idx] ; // moving next node.
            count += curr.count ; /// and calculating the count.
        }
        
        return count ;
    }
    

    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode() ;
        
        // first storing the prefix in trie.
        for(String s : words){
            addToTrie(s) ;
        }
        
        int[] ans = new int[words.length] ; 
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i] ;
            int score = getPrefixCount(s) ; // getting count from trie function.
            ans[i] = score ;
        }
        
        return ans; 
    } 
}
