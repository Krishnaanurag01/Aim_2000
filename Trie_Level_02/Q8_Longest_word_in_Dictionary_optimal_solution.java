package Trie_Level_02;

public class Q8_Longest_word_in_Dictionary_optimal_solution {


    // optimal solution.
    static String ans ;
    public String longestWord(String[] words) {
        
        Node root = new Node() ;
        ans = "" ;

        // first inserting the word in trie
        for(String word : words){
             insert(root,word) ;
        }
        

        // now running the dfs
        dfs(root) ;
        return ans ;
    }
    
    class Node{
        Node[] childs = new Node[26];
        String str ;
    }

    // same old insert operation
    
    public void insert(Node root, String word){
        
        Node curr = root ;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }   
            curr = curr.childs[ch - 'a'] ;
        }
        curr.str = word ;
    }
    
    public boolean dfs(Node root){
        
        for(Node child : root.childs){ // here checking every child node, if it is not null and the string value it has also not null then compare with the answer. and call for dfs so that we can find in the deep down of trie.
            if(child != null && child.str != null){
                ans = ans.length() < child.str.length() ? child.str : ans ;
                dfs(child) ;
            }
        }
        return true ;
    }

}
