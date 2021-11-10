package Graph_level_01;
import java.util.*;

public class Topological_Sort_List_Representation {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(visited[i] == false){
                find_topo(i,visited , stack , adj) ;
            }
        }
        
        int[] ans = new int[V] ;
        int i = 0 ;
        
        while(!stack.isEmpty()){
            
            ans[i++] = stack.pop() ;
        }
        
        return ans ;
    }
    
    
    static void find_topo(int src , boolean[] visited , Stack<Integer> stack , ArrayList<ArrayList<Integer>> adj){
        
        visited[src] = true ;
        
        for(Integer in : adj.get(src)){
            if(!visited[in]){
                find_topo(in,visited , stack , adj) ;
            }
        }
        
        stack.push(src) ;
    }
    
}
