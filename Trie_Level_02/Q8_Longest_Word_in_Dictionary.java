package Trie_Level_02;
import java.util.*;

public class Q8_Longest_Word_in_Dictionary { 


    // 1st method : takes nlogM(m= length of word)

    public String longestWord(String[] words) {
        
        Node root = new Node() ;
        String ans = "" ;
        
        Arrays.sort(words) ;
        
        for(String word : words){
             insert(root,word) ; // first inserting the word 
             // now checking whether the current word is our potential answer or not? if yes then compare with current answer length.
            if(find(root,word) && word.length() > ans.length()){
                ans = word ;
            }
        }
        
        return ans ;
    }
    
    class Node{
        Node[] childs = new Node[26];
        boolean isEnd ;
        String str ;
    }
    
    public void insert(Node root, String word){
        
        Node curr = root ;
        
        for(int i = 0 ; i < word.length() ; i++){
            
            char ch = word.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch - 'a'] ;
        }
        curr.isEnd = true ;
        curr.str = word ;
    }
    
    public boolean find(Node root, String word){ // here we will check if each char ( or prefix) of word true(means any other word) exist or not.
        
        Node curr = root ;
        
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            
            if(curr.childs[ch-'a'] != null){
                curr = curr.childs[ch-'a'] ;
                if(curr.isEnd == false){
                    return false;
                }   
            }
        }
        
        return true ;
    }
}

// method 02 : takes o(n) time only.
