package Trie_Level_02;
import java.util.*;

public class Q15_Print_Anagrams_Together {

    static class Node{
        Node[] childs = new Node[26] ;
        List<String> list = new ArrayList<>() ; // we will store string here who ends on current node.
    }
    
    static Node root ; 
    
    public static void insert(String word){
        
        // adding in Pq so that we can store word in lexicographically.
          Node curr = root ;
          PriorityQueue<Character> q = new PriorityQueue<>() ;
          
          for(char ch : word.toCharArray() ){
              q.add(ch) ;
          }
        
        while(q.size() > 0 ){
            char ch = q.poll() ;
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch - 'a'] ;
        }
        
        // adding in current node list.
        curr.list.add( word ) ; 
        
    }
    
    public static void find(Node curr){
        
        if(curr.list.size() > 0){ // adding list of string if it has any string
            ans.add(curr.list) ;
        }
        
        for(Node child : curr.childs){
            
            if(child != null){
                find(child) ;
            }
        }
        
    }
    
    static List<List<String>> ans ;
    public List<List<String>> Anagrams(String[] string_list) {
        
        root = new Node() ;
        ans = new ArrayList<>() ;
        
        // adding words in trie.
        for(String s : string_list){
            insert(s) ;
        }
        
        find(root) ;
        
        return ans ;
       
    }
    
}
