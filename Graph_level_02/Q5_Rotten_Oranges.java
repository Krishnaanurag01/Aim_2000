package Graph_level_02;
import java.util.*;


public class Q5_Rotten_Oranges {
    
    static class Pair{
        int x ; 
        int y ;
        
        Pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }
    
    
    public int orangesRotting(int[][] grid)
    {
        LinkedList<Pair> queue = new LinkedList<>(); // helps in bfs.
        
        int freshOranges = 0 ; // this denotes count of all freshOranges oranges ( oranges which have value 1 )
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 2 ){ // if the orange is rotten then add it in queue by making a pair .
                    queue.add( new Pair(i,j) ) ;
                }
                else if(grid[i][j] == 1) { // increasing frequency of freshOranges oranges.
                    freshOranges++ ;
                }
            }
        }
        

        if(freshOranges == 0){ // if there are no freshOranges oranges then it means all oranges are either rotten or empty.
            return 0 ; // so return 0.
        }
        
        int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} } ; // all four adjecent directions.
        
        int level = -1 ; // by default using -1 !
        
        while(queue.size() > 0){ // bfs technique.
            
            int size = queue.size() ; // finding size 
            level++; // increasing level.
            
            while(size-- > 0){ // traversing only for previous size.,
                
                Pair rem = queue.removeFirst() ; // removed first pair
                
                for(int i = 0 ; i < 4 ; i++){ // now going in all four directions and checking if element is 1 then making it rottena and adding to the queue so that it can affect its adjecent in next hours.
                    
                    int rowDash = rem.x + directions[i][0];
                    int colDash = rem.y + directions[i][1];
                    
                    if(rowDash >= 0 && rowDash < grid.length && colDash >= 0 && colDash < grid[0].length && grid[rowDash][colDash] == 1){
                        queue.add( new Pair(rowDash,colDash) ) ; // adding to the queue so that it can also affect its adjecent.
                        grid[rowDash][colDash] = 0 ; // making rotten
                        freshOranges-- ; // now decrementing .
                    }
                }
            }
            
        }
        
        
        if(freshOranges == 0){ // if we have no fresh oranges left then return the time (level)
            return level ;
        }
        else{ // if we left with any fresh oranges then return -1.
            return -1;
        }
        
        
    }
}
