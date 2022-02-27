package Graph_level_02;
import java.util.*;

public class Q24_Mother_Vertex {

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        Stack<Integer> stack = new Stack<>() ; // this will store the vertices.
        boolean[] visited = new boolean[V] ;
        
        // this is nothing but topo sort
        for( int i = 0 ; i < V ; i++){
            
            if(visited[i] == false){ // calling dfs1 for non visited neigbours and storing value in stack.
                dfs1(i,adj,visited,stack) ;
            }
        }
        
        int ans = stack.pop() ; // the top element might be our answer. // this becuase in  topo sort we arrange element in a way such that for any edge uv (u->v) v comes first the u should come so for mother vertex every nodes must be deriving from it so mother vertex(u) will come on top. 
        
        visited = new boolean[V] ; // again initialzing.
        
        count = 0 ; // finding the count of element that we accessed through dfs2.
        
        dfs2(ans,adj,visited);
        
        if( count == V ){ // if the count becomes equal to V then it means ans is our mother vertex else return -1.
            return ans ;
        }
        else{
            return -1 ;
        }
         
    }
    
    public static void dfs1(int src , ArrayList<ArrayList<Integer>>adj , boolean[] visited, Stack<Integer> stack){
        
        visited[src] = true ;
        
        ArrayList<Integer> innerComp = adj.get(src) ;
        
        for( Integer in : innerComp){
            if(visited[in] == false){
                 dfs1(in,adj,visited,stack) ;
            }
        }
        
        stack.push(src) ;
    }
    
    static int count  ;
    
    public static void dfs2(int src , ArrayList<ArrayList<Integer>>adj , boolean[] visited ){
        
        visited[src] = true ;
        count++ ;
        
        ArrayList<Integer> innerComp = adj.get(src) ;
        
        for( Integer in : innerComp){
            if(visited[in] == false){
                 dfs2(in,adj,visited) ;
            }
        }
    }
    
}
