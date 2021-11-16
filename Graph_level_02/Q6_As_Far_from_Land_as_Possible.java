package Graph_level_02;
import java.util.*;

public class Q6_As_Far_from_Land_as_Possible {

    static class Pair{
        int x ; 
        int y ;
        
        Pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }
    
    // same logic as before question.
    
    public int maxDistance(int[][] grid) {
        
        LinkedList<Pair> queue = new LinkedList<>();
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1){ // adding all the lands index as a pair.
                    queue.add( new Pair(i,j));
                }
            }
        }
        
        
        // if queue is empty then it means there are no land so we can't reach land so returning -1.
        // and if queue have all the element of grid then it means there are no water in grid so return -1 
        if(queue.size() == 0 || queue.size() == grid.length * grid[0].length ){
            return -1 ;
        }
        
        
        int[][] directions = { {-1,0},{0,1},{1,0},{0,-1} }; // all four adjecent directions.
        
        
        // using bfs techniques.
        
        int level = -1; 
        
        while(queue.size() > 0){
            
            int size = queue.size();
            level++ ;
            
            while(size-- > 0){
                Pair rem = queue.removeFirst();
                
                for(int i = 0 ; i < directions.length ; i++){
                    
                    int rowDash = rem.x + directions[i][0];
                    int colDash = rem.y + directions[i][1];
                    
                    // if the element is water then make it 1 and add it to the queue.
                    if(rowDash >= 0 && rowDash < grid.length && colDash >= 0 && colDash < grid[0].length && grid[rowDash][colDash] == 0){
                        queue.add( new Pair(rowDash,colDash));
                        grid[rowDash][colDash] = 1 ;
                    }
                }
                
            }
        }
        
        // here level denotes the highest distance of land from water.
        return level ;
        
    }
    
}
