package Graph_level_02;
import java.util.*;


public class Q23_Strongly_Connected_Components_Kosarajus_Algo {
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V] ;   
        LinkedList<Integer> stack = new LinkedList<>() ; // this will store all the vertex after dfs call

        // step 01 :
        for( int i = 0 ; i < adj.size() ; i++ ) {
                if(visited[i] == false){
                    // calling dfs
                    dfs1(i,adj,stack,visited);
                }
        }
            
        // step 02 : reversing the graph
        ArrayList<ArrayList<Integer>> nGraph = new ArrayList<>() ;
        
        for( int i = 0 ; i < V ; i++){
            nGraph.add( new ArrayList<>() ) ; // initializing the new graph.
        }
        
        
        
         for( int i = 0 ; i < adj.size() ; i++ ) {
            ArrayList<Integer> innerComp = adj.get(i) ; // finding all the neigbours.
            for(Integer nbr : innerComp){ 
                    nGraph.get(nbr).add(i) ; // now adding reverse edge of nbr to i ( originally it was i to nbr )
            }
        }
        
        // step 3 : calculating the answer.
        visited = new boolean[V] ;
        int ans = 0 ;
        while(stack.size() > 0 ){
            int rem = stack.removeFirst() ;
            if( visited[rem] == false ){ // if not visited then calling dfs2
                dfs2(rem , nGraph , visited) ;
                ans++ ; // increamenting by one.
            }
        }
        
        return ans ;
    
    }
    
    
    public static void dfs1(int src ,  ArrayList<ArrayList<Integer>> adj, LinkedList<Integer> stack , boolean[] visited){
        
        visited[src] = true ; // making visited.
        ArrayList<Integer> innerNbrs = adj.get(src) ; // going through all the neigbours.
        
        for( int in : innerNbrs){
            if( visited[in] == false){ // if not visiting then call dfs for its child
                dfs1(in,adj,stack,visited);
            }
        }
        stack.addFirst(src) ; // and In the end add src at first. ( so that it will work like stack)
    }
    
    public static void dfs2(int src ,  ArrayList<ArrayList<Integer>> adj ,  boolean[] visited){
        
        visited[src] = true ; // only make true.
        ArrayList<Integer> innerNbrs = adj.get(src) ;
        
        for( int in : innerNbrs){  // add neigbours if not visited only
            if( visited[in] == false){
                dfs2(in,adj,visited);
            }
        }
    }
}
