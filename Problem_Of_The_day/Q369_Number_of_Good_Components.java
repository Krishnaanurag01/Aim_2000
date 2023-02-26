package Problem_Of_The_day;
import java.util.*;

public class Q369_Number_of_Good_Components {

    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
    
       
        // step 01: first find all the connected component.
        boolean[] visited = new boolean[V+1] ;
        int[] indegree = new int[V+1] ; // and also stores its indegree.
        // indegree means the number nbr it has(as it is undirected graph)
        
        ArrayList<ArrayList<Integer>> allComp = new ArrayList<>() ;
        
        for(int i =1 ; i <= V; i++){
            if(visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>() ;
                getComp(i,visited,comp, adj, indegree) ;
                allComp.add(comp) ;
            }
        }
        
        // now check if every node of every component has indegree equals to it's component size -1 (matlab khud ko chor k sare other node par eska hath h)
        int ans = 0 ;
        
        for(ArrayList<Integer> comp : allComp){
            int in = comp.size()-1 ;
            boolean vulnerable = false ;
            for(int node: comp){
                if(indegree[node] != in) { // agar sare others node par nhi ja sakta toh fully good comp nhi hai
                    vulnerable = true;
                    break;
                }
            }
            
            if(vulnerable == false) ans++ ;
        }
        
        return ans ;
     }
     
     
     public void getComp(int src, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj, int[] indegree){
         
         visited[src] = true ;
         list.add(src) ;
         indegree[src] = adj.get(src).size() ;
         
         for(int nbr : adj.get(src)){
             if(visited[nbr] == false){
                 getComp(nbr, visited, list, adj, indegree) ;
             }
         }
     }
}
