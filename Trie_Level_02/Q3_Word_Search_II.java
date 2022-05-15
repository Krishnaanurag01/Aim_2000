package Trie_Level_02;
import java.util.*;

public class Q3_Word_Search_II {

    // optimal solution.
     
    static class Node{
        public Node[] childs = new Node[26] ;
        public String s ; // this will store at the end point
        int count = 0 ; // denotes total active child of current node 
     }
     
     static List<String> list ;
     
     public List<String> findWords(char[][] board, String[] words) {
         
         Node root = new Node() ;
         
         // adding trie
         for(String word : words){
             insert(word,root) ;
         }
         
         list = new ArrayList<>() ;
         
         // checking for each traversal
         for(int i = 0; i < board.length ; i++){
             for(int j = 0 ; j < board[0].length ; j++){
                 
                find(board,root,i,j) ;
             }
         }
         
         return list ;
         
     }
     
     void find(char[][] board, Node root, int i , int j){
         
        // out of bound, visited( '0') occurs then return without  doing anything
         if( i < 0  || i >= board.length || j >= board[0].length || j < 0 || board[i][j] == '0' || root.childs[ board[i][j] - 'a' ] == null  )
         {
             return ;
         }
             
         Node child = root.childs[ board[i][j] - 'a' ] ; // now getting the child node
         
         if(child.s != null){ // if it string is not null then it mmust be end point so add to answer.
             list.add(child.s) ;
             child.s = null ;
         }
         
         char bkp = board[i][j] ; // backup
         board[i][j] = '0' ; // visiting
         
         
         // going adjecent directions
         find(board,child,i+1,j) ;
         find(board,child,i-1,j) ;
         find(board,child,i,j+1) ;
         find(board,child,i,j-1) ;
         
          board[i][j] = bkp ; // unvisiting 
        
         if(child.count == 0){
             root.count-- ;
         }
         
     }
     
     void insert(String word,Node root){
         
         Node curr = root ;
         
         for(int i = 0 ; i < word.length() ; i++){
             char ch = word.charAt(i); 
             
             if(curr.childs[ch-'a'] == null){
                 curr.childs[ch-'a'] = new Node() ;
                 curr.count++ ;
             }
             
             curr = curr.childs[ch-'a'] ;
         }
         
         curr.s = word ;
         // System.out.println(curr.s) ;
     }
 
    
}



// SELF SOLUTION.
// Algo : 
// -> insert the dictionary words in TRIE data structure(make one) 
// -> then look into the char[][] array and check if current char is present in the root child of trie data structure if yes then 
// -> search that word by going to adjecent chars and add to ans list if we found the end of the word.
class Solution {
    
    static class Node{
        
       public Node[] childs ;
       public boolean isEnd ;
        
        Node(){
            childs = new Node[26];
        }
    
        // for adjecent traveral
    int[][] directions = {
        {1,0},
        {-1,0},
        {0,-1},
        {0,1}
    };
    
    void find(char board[][] ,int i , int j, String wsf){
        
    if(isEnd && list.contains(wsf) == false){ // if it is the end of word and not present in list then add to answer.
        list.add(wsf) ;
    }
    
        char bkp = board[i][j] ;
        board[i][j] = '0' ; // work as visited array
        
        
        // going to adjecent characters
        for(int[] dir : directions)
        {
            int rdash = i + dir[0];
            int cdash = j + dir[1];
            
            // when out of bound or already visited then do nothing.
            if(rdash >= 0 && rdash < board.length && cdash >= 0 && cdash < board[0].length && board[rdash][cdash] != '0'){
                
                char ch = board[rdash][cdash] ;
                
                if(childs[ch - 'a'] != null){ // checking if adjecen char present in child if yes then call the find function with that wsf
                    childs[ch -'a'].find(board,rdash,cdash,wsf + ch) ;
                }
                
            }
        }
        
          board[i][j] = bkp ;
        
        return ;
    
    }
        
    }
    
    
    
    
    
    static Node root ;
    
    Solution(){
        root = new Node() ;
    }
    
    static List<String> list ;
    

    // solution starts from here
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String word : words){ // adding word to trie
            insert(word) ;
        }
        
        list = new ArrayList<>() ;
        
        // checking each char if present in the trie data structure 
        for(int i = 0; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                
                char ch = board[i][j] ;
                
                if(root.childs[ch-'a'] != null){
                    root.childs[ch-'a'].find(board,i,j,""+ch) ;
                }
            }
        }
        
        return list ;
        
    }

    // same as previous two questions
    
    
    void insert(String word){
        
        Node curr  = root ;
        
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i); 
            
            if(curr.childs[ch-'a'] == null){
                curr.childs[ch-'a'] = new Node() ;
            }
            
            curr = curr.childs[ch-'a'] ;
        }
        
        curr.isEnd = true ;
    }
}
