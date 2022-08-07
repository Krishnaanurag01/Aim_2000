package Graph_level_02;
import java.util.*;

public class Q63_Maximal_Network_Rank {

    public int maximalNetworkRank(int n, int[][] roads) {
        
        // initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        
        for(int i = 0 ; i <= n ; i++){
            adj.add( new ArrayList<>());
        }
        
        for(int[] e : roads){
            adj.get(e[0]).add(e[1]) ;
            adj.get(e[1]).add(e[0]) ;
        }
        // end of ini
        
        
        // now calculating the indegree of each vertices
        int[] indegree = new int[n] ;
        
        for(int i = 0 ; i < n ; i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++ ;
            }
        }
        

        int ans = 0 ;
        // selecting the pair of vertices with max roads
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int temp = indegree[i] + indegree[j] ;
                if(adj.get(i).contains(j)){ // if i and j are connected the remove 1 from ans that is common between both
                    temp--;
                }
                ans = Math.max(ans,temp) ;
            }
        }

        return ans ;
    }
}
