package Graph_level_02 ;
import java.util.*;

public class Q71_Map_of_Highest_Peak {
    
    public int[][] highestPeak(int[][] isWater) {
        
        // using bfs.
        LinkedList<int[]> q = new LinkedList<>() ;
        boolean[][] visited = new boolean[isWater.length][isWater.length] ;
        
        // add all the water cell in q and make them visited.
        for(int i = 0 ; i < isWater.length ; i++){
            for(int j = 0 ; j < isWater[0].length ; j++){
                if(isWater[i][j] == 1){
                    q.add( new int[]{i,j,0}) ;
                    isWater[i][j] = 0 ; // making water cell 0
                    visited[i][j] = true ; // and visited
                }
            }
        }
        
        
        // if no water cells are present then add the first cell with 1.
        if(q.size() == 0){
            q.add(new int[]{0,0,1}) ;
            visited[0][0] = true ;
        }
        
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}} ;
        
        while(q.size() > 0){
            int[] rp = q.removeFirst() ;
            
            for(int[] d : direc){
                int i = rp[0] + d[0];
                int j = rp[1] + d[1];
                
                // if out of bound or already visited then skip.
                if(i < 0 || j < 0 || i >= isWater.length || j >= isWater[0].length || visited[i][j] == true) continue ;
                
                visited[i][j] = true ; // make visited
                isWater[i][j] = rp[2] + 1 ; // assign height
                q.add( new int[]{i,j,rp[2] + 1}) ; // and also add it to the queue.
            }
        }
        
        return isWater ;
    }
}
