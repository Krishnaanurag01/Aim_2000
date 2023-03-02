package Problem_Of_The_day;
import java.util.*;

public class Q367_Shortest_Path_Using_Atmost_One_Curved_Edge {
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
    
        // make adjency list.
            ArrayList<ArrayList<int[]>> adj = new ArrayList<>() ;
        
            for(int i = 0 ; i <= n ; i++){
                adj.add(new ArrayList<>()) ;
            }
            
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0) ;
                int v = edge.get(1) ;
                int wt = edge.get(2) ;
                adj.get(u).add(new int[]{v,wt}) ; // stores nbbr with cost
                adj.get(v).add(new int[]{u,wt}) ;
            }
            
            
            // now find distance from a and b to all other nodes.
            int[] distFromA = new int[n+1] ;
            int[] distFromB = new int[n+1] ;
            // intiallyy fill infinity
            Arrays.fill(distFromA, (int)1e9) ;
            Arrays.fill(distFromB, (int)1e9) ;
            
            
            // find this distance with dikstra
            dikstra(adj,a,distFromA) ;
            dikstra(adj,b,distFromB) ;
            
      
    
            int ans = distFromA[b] ;
            
            // now run over every curve edge and check if we apply this curve in between a and b then min path cost.
            for(ArrayList<Integer> edge : edges){
                int u = edge.get(0) ;
                int v = edge.get(1) ;
                int cwt = edge.get(3) ; // curve cost
                
                // dist from A to U and U - V cost and V to B cost
                ans = Math.min(ans, distFromA[u] + cwt + distFromB[v]) ;
                // dist from A to V and V - U cost and U to B cost
                ans = Math.min(ans, distFromA[v] + cwt + distFromB[u]) ;
            }
            
            // if ans is infinity then return -1
            return ans == (int)1e9 ? -1 : ans;
        }
        
        static void dikstra(ArrayList<ArrayList<int[]>> adj, int src, int[] dist){
            
            // using dikstra to find single node shoprtest path
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]) ; // comparing on wt.
            pq.add(new int[]{src,0}) ;
            dist[src] = 0 ;
            
            while(pq.size() > 0){
                int[] rn = pq.poll() ;
                int Cnode = rn[0] ;
                int dsf = rn[1] ;
    
                
                for(int[] nbr : adj.get(Cnode)){
                    int nbrNode = nbr[0] ;
                    int wt = nbr[1] ;
                    
                    if(dist[nbrNode] > dsf + wt ){
                        pq.add(new int[]{nbrNode, dsf + wt});
                        dist[nbrNode] = dsf + wt ;
                    }
                }
            }
            
        }
}
