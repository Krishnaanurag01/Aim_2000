package Graph_level_02;
import java.util.*;

public class Q65_Snakes_and_Ladders {

    static HashMap<Integer,Integer> map ;  
    public int snakesAndLadders(int[][] board) {
        
        int n2 = board.length * board.length ;       
        
        // storing all ladders and snake cell and their destination in map.
        map = new HashMap<>() ;
        boolean flag = true ;
        for(int i = board.length - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j < board[0].length ; j++){
                int cell = 0 ;
                if(flag){
                    cell = (board.length - 1 - i)*(board.length) + j + 1 ;
                }
                else{
                    cell = (board.length - 1 - i)*(board.length) + (board.length - 1 - j ) + 1 ;
                }
                if(board[i][j] != -1){
                    map.put(cell,board[i][j]) ;
                }
            }
            flag = !flag ;
        }
        // System.out.println(map) ;
        
        
        // running bfs.
        int moves = 0 ;
        LinkedList<Integer> q = new LinkedList<>() ;
        q.add( 1 );
        boolean[] visited = new boolean[n2+1] ;
        visited[1] = true ;
        
        while(q.size() > 0){
            
            int size = q.size() ;
            while(size-- > 0){    
                int rv = q.removeFirst() ;
                if(rv == n2) return moves ;
                
                for(int i = 1 ; i <= 6 && i + rv <= n2  ; i++){ // i + rv <= n2 must
                    int next = i + rv ;
                   
                    if(map.containsKey(next) && visited[map.get(next)]) continue; // if next is snake or ladder and is already visited then continue.
                                                           
                    if(map.containsKey(next)){ // else snake or ladder but not visited
                        visited[next] = true ;
                        q.add(map.get(next)) ;
                        visited[map.get(next)] = true ;
                    }else if(visited[next] == false){ // else next is a cell and not visited
                        q.add(next);
                        visited[next] = true ;
                    }
                    }
                }
            moves++ ;
        }
         return -1;
    }
}
