package Graph_level_02;

import java.util.* ;

public class Q17_Swim_in_Rising_Water {

    public static int swimInWater(int[][] grid) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();  // using dikstras technique.
        boolean[][] visited = new boolean[grid.length][grid.length] ;
        pq.add( new Pair(0,0,grid[0][0])); // adding source to the pq.
        
        
        int[][] dir = { {-1,0} , {0,1} , {1,0} ,  {0,-1}} ; // all four adjcent directions.
        while(pq.size() > 0 ){
            
            Pair rem = pq.remove(); // removing the first.
            
            if(rem.row == grid.length - 1 && rem.col == grid.length - 1){ // if it is destination then print.
                return rem.msf ;
            }
            
            
            if(visited[rem.row][rem.col] == true){ // if already visited then continue ;
                continue ;
            }
            
            // making visited
            visited[rem.row][rem.col] = true ;
            

            // now visiting all four directions.
            for( int i = 0 ; i < 4 ; i++){
                
                int rowDash = rem.row + dir[i][0] ;
                int colDash = rem.col + dir[i][1] ;
                
                // if out of bound or already visited then skip.
                if( rowDash < 0  || colDash < 0 || rowDash >= grid.length || colDash >= grid.length || visited[rowDash][colDash] == true ){
                    continue ;
                }
                
                // else add pair with new row , new col and max so far .
                pq.add( new Pair(rowDash , colDash , Math.max(rem.msf , grid[rowDash][colDash]))) ;
            }   
        }
        
        
        return 0 ;
    }
    
    static class Pair implements Comparable<Pair>{
        int row ;
        int col ;
        int msf ; // max so far.
        
        Pair(int row , int col , int w){
            this.row = row ;
            this.col = col ;
            this.msf = w ;
        }
        
        public int compareTo(Pair  obj){ /// comparision based the max so far.
            return this.msf - obj.msf ;
        }
    }
    
}
