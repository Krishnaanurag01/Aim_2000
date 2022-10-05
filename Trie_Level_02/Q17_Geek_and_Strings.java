package Trie_Level_02;
import java.util.*;

public class Q17_Geek_and_Strings {

    static class TrieNode{
        TrieNode[] childs = new TrieNode[26] ;
        int prefixCount = 0 ;
    }
    
    static TrieNode root ;
    
    static List<Integer> prefixCount(int N, int Q, String li[], String queries[])
    {
        generateTrie(li) ;
        List<Integer> ans = new ArrayList<>() ;
        
        for(String query : queries){
            ans.add(getCount(query)) ;
        }
        
        return ans;
    }
    
    // now fetching the prefix count of current string
    static int getCount(String s){
        TrieNode curr = root ;
        
        for(char ch : s.toCharArray()){
            if(curr.childs[ch - 'a'] == null) return  0 ; // if current char is not present then return 0 as this denotes trie does not have ch child
            curr = curr.childs[ch-'a'] ;
        }
        
        return curr.prefixCount ;
    }
    
    
    // storing all the strings prefix count in trie first
    static void generateTrie(String[] li){
        
        root = new TrieNode() ;
        
        for(String s : li){
            TrieNode curr = root ;
            for(char ch : s.toCharArray()){
                if(curr.childs[ch-'a'] == null){
                    curr.childs[ch-'a'] = new TrieNode() ;
                }
                curr = curr.childs[ch-'a'] ;
                curr.prefixCount++ ;
            }
            
        }
    }
}
