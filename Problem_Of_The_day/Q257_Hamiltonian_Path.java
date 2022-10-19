package Problem_Of_The_day ;
import java.util.*;

public class Q257_Hamiltonian_Path {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        
        for(int i = 0 ; i <= N ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        for(ArrayList<Integer> edge : Edges){
            adj.get(edge.get(0)).add(edge.get(1)) ;
            adj.get(edge.get(1)).add(edge.get(0)) ;
        }
        
        HashSet<Integer> visit_set= new HashSet<>() ;
        
        for(int i = 0 ; i < N ; i++){
            if(hasPath(i, adj, visit_set, N)) return true;
        }
        
        return false ;
    }
    
    
    boolean hasPath(int src, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited, int N){
        
        if(visited.size() == N - 1) return true ;
        visited.add(src) ;
        
        for(Integer nbr : adj.get(src)){
            if(visited.contains(nbr) == false){
                if(hasPath(nbr, adj, visited, N)) return true ;
            }
        }
        
        visited.remove(src) ;
        return false;
    }
}
