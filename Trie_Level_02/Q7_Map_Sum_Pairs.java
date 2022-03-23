package Trie_Level_02;
import java.util.*;

public class Q7_Map_Sum_Pairs {
    
}

class MapSum {
    
    class Node{
        Node[] childs = new Node[26] ;  // pointers to nexh char
        boolean isEnd ; /// denots end of string
        int score = 0 ; // holds total score so far
    }
    
    Node root ;
    HashMap<String,Integer> map ; // this will help us in updating the val

    public MapSum() {
        map = new HashMap<>() ;
        root = new Node() ;
    }
    
    public void insert(String key, int val) {
        
        if(map.containsKey(key)){ // if already present in map then we have to update the value
            val = val - map.get(key) ; // so fiding new val
        }
        
        map.put(key, map.getOrDefault(key,0) + val); // updating in map when updation
        
        Node curr = root ;
        
        for(int i = 0 ; i < key.length() ; i++){
            char ch = key.charAt(i) ;
            
            if(curr.childs[ch - 'a'] == null){ // if next node not present then create  it
                curr.childs[ch - 'a'] = new Node() ;
            }
            
            curr = curr.childs[ch-'a'];
            curr.score += val ; // we will also add current score to every prefix char of key
        }
        
        curr.isEnd = true ;
        
    }
    
    public int sum(String prefix) {
        
        Node curr = root ; 

        // going till the prefix end char and returning the last char value
        
        for(int i = 0 ; i < prefix.length() ; i++ ){
            char ch = prefix.charAt(i) ;
             
            if(curr.childs[ch - 'a'] != null){
                curr = curr.childs[ ch - 'a'] ;
            }
            else{
                return  0 ;
            }
        }
        
        return curr.score ;
        
    }
}
