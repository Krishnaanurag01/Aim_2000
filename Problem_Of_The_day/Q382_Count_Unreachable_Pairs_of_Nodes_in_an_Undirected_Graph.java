package Problem_Of_The_day;

public class Q382_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {
    
    public long countPairs(int n, int[][] edges) {
        // making adj  list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        for(int[] e : edges){
            int a = e[0] ;
            int b = e[1] ;
            
            adj.get(a).add(b) ;
            adj.get(b).add(a) ;
        }
        
        
        ArrayList<Integer> allCompSize = new ArrayList<>() ; // stores all comp size
        boolean[] visited = new boolean[n] ;
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                // ArrayList<Integer> comp = new ArrayList<>() ;
                // getConnectedComp(i, adj, comp, visited) ;
                // allComp.add(comp) ; 
                
                // instead of getting whole comp when we want only size of it then just find the size and store 
                int[] size = {0} ;
                getConnectedCompSize(i, adj, size, visited) ;
                allCompSize.add(size[0]) ;
            }
        }
        
        // System.out.println(allComp) ;
        
        long ans = 0 ;
        
        for(int size : allCompSize){ // getting size of each comp
            n = n - size ; // getting the rest nodes and updating n with rest
            ans += (n *1L* size) ; // making pair
        }
        
        return ans ;
    }
    
    
    void getConnectedCompSize(int src, ArrayList<ArrayList<Integer>> adj, int[] size, boolean[] visited){
        visited[src] =  true ;
        size[0]++ ;
        
        for(int nbr : adj.get(src)){
            if(visited[nbr] == false){
                getConnectedCompSize(nbr, adj, size, visited) ;
            }
        }
    }
}
