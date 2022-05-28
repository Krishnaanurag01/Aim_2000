package Graph_level_01;
import java.util.*;

public class Q20_Covid_Spread {

    public int helpaterp(int[][] hospital) {
        
        // using bfs :
        LinkedList<int[]> q = new LinkedList<>() ;
        
        int tuinf = 0 ; // total uninfected peoples.
        
        for(int i = 0 ; i < hospital.length ; i++){
            for(int j = 0 ; j < hospital[0].length ; j++){
                
                if(hospital[i][j] == 2){ // adding all infected peoples in graph.
                    q.add( new int[]{i,j} ) ;
                }
                else if(hospital[i][j] == 1){ // and counting the uninfected ones.
                    tuinf++ ;
                }
            }
        }
        
        int time = 0 ; /// time taken to spread virus.
        
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}}; // all four adjecent direction.
        
        while(q.size() > 0 ){
            if(tuinf == 0) return time ; // if at point of time the total uninfected peoples becomes zero then return the time till now
            int size = q.size() ;
            while(size-- > 0){
                int[] rp = q.removeFirst() ;
                
                for(int[] a : direc){
                    int nr = rp[0] + a[0] ;
                    int nc = rp[1] + a[1] ;
                    
                    // checking uninfected peoples in adjecent direction.
                    if(nr >= 0 && nr < hospital.length && nc >= 0 && nc < hospital[0].length && hospital[nr][nc] == 1){
                        tuinf-- ;
                        q.add(new int[]{nr,nc});
                        hospital[nr][nc] = 2 ;
                    }
                }
            }
            time++ ;
        }
        
        // if any uninfected person left then return -1 else return ans.
        return tuinf != 0 ? -1 : time ;        
    }
}
