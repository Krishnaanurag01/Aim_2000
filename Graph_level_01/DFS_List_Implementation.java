package Graph_level_01;

import java.util.*;


public class DFS_List_Implementation {
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> dfs_list = new ArrayList<>() ;

        boolean[] visited = new boolean[V+1] ;
    
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == false){
                find_dfs(i,adj,visited,dfs_list);
            }
        }

        return dfs_list ;
    }

    private void find_dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs_list) {
    
        dfs_list.add(v) ;
        visited[v] = true ;

        for (Integer i : adj.get(v)) {
            if(visited[i] == false){
                find_dfs(i, adj, visited, dfs_list);
            }   
        }
    
    }
}
