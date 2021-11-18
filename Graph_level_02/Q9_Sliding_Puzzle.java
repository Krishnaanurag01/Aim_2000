package Graph_level_02;
import java.util.*;

public class Q9_Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {
        
        LinkedList<String> queue = new LinkedList<>() ; // helps in bfs.
        
        StringBuilder sb = new StringBuilder() ; // helps in making intial board to string.
        
        for( int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                
                sb.append(board[i][j]) ;
            }
        }
        
        String initial = sb.toString() ; /// now converting it to the string.
        
        String target = "123450" ; // this is our target value.
        
        HashSet<String> visited = new HashSet<>() ; // visited.
        
        queue.add(initial) ; // adding initial string.
        
        
        int[][] swapIndex = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4} } ; // this denotes where can we swap one char , we convert our matrix into string so we need to keep track of our adjecent index where we can swap of 0.
        
        int level = 0 ;
        
        while(queue.size() > 0){
            // size of current level.
            int size = queue.size();
            
            while(size-- > 0){
                
                String rem = queue.removeFirst() ; // removing first string from queue.
                
                if(rem.equals(target) ){ // if it is the target one then return level.
                    return level ;
                }
                
                int idx = -1 ; // holds the index of "0"
                
                for(int i = 0 ; i < rem.length() ; i++){
                    if(rem.charAt(i) == '0'){
                        idx = i ;
                        break ;
                    }
                }
                
                int[] swapping_index = swapIndex[idx] ; // getting all the direction index where we can swap our zero.
                
                for( int i = 0 ; i < swapping_index.length ; i++){
                    
                    String toBeAdded = newString(rem,idx,swapping_index[i]); // now swapping the character and getting the new string.
                    
                    if( visited.contains( toBeAdded )){ // if it is already visited then skip
                        continue;
                    }
                    // else add it to the queue and visited set.
                    queue.add(toBeAdded);
                    visited.add(toBeAdded);
                }
                
            }
            
            level++ ;
        }
        
        return -1;
    }
    
    // it will swap the character of given string.
    public String newString(String str , int original_idx , int i){
        
        StringBuilder sb = new StringBuilder(str);
        
        sb.setCharAt(original_idx , str.charAt(i));
        sb.setCharAt(i , str.charAt(original_idx) );
        
        return sb.toString();
    }
    
}
