package Problem_Of_The_day;
import java.util.*;

public class Q317_Find_if_Path_Exists_in_Graph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ; // making adjency list
        
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>()) ;
        }
        
        for(int[] e:  edges){
            int u = e[0] ;
            int v = e[1] ;
            
            list.get(u).add(v) ;
            list.get(v).add(u) ;
        }
        
        /// this helps in identifying where we already have visited
        boolean[] visited = new boolean[n] ;
        
        return helper(source, list, destination, visited) ;
    }
    
    boolean helper(int src, ArrayList<ArrayList<Integer>> list, int dst, boolean[] visited){
        if(src == dst) return true ;
        
        // making src visited
        visited[src] = true ;
        
        for(int nbr : list.get(src)){
            if(visited[nbr] == false){
                if(helper(nbr, list, dst, visited)) return true ;
            }
        }
        
        // now we don't have to backtrack visited because from that node we didn't reach dstn so we won't pick that node again 

        return false;
    }
}
