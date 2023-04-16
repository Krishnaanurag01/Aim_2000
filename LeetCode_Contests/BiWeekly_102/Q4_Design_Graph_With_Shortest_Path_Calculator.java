package LeetCode_Contests.BiWeekly_102;

public class Q4_Design_Graph_With_Shortest_Path_Calculator {
    
    class Graph {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>() ;
        int m ;
        
        public Graph(int n, int[][] edges) {
            m = n ;
            for(int i = 0 ; i < n ; i++){
                adj.add(new ArrayList<>()) ;
            }
                
                for(int[] e : edges){
                    Pair to = new Pair(e[1], e[2]) ;
                    adj.get(e[0]).add(to) ;
                }
            
        }
        
        public void addEdge(int[] e) {
            Pair to = new Pair(e[1], e[2]) ;
            adj.get(e[0]).add(to) ;
        }
        
        public int shortestPath(int node1, int node2) { // applying dikstras.
            
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost) ;
            pq.add(new Pair(node1, 0)) ;
            boolean[] visited = new boolean[m] ;
            
            while(pq.size() > 0){
                Pair p = pq.poll() ;
                
                if(p.val == node2) return p.cost ;
                
                if(visited[p.val] == true) continue ;
                visited[p.val] = true ;
                
                
                for(Pair nbr : adj.get(p.val)){
                    if(visited[nbr.val] == false){
                        pq.add(new Pair(nbr.val, p.cost + nbr.cost)) ;
                    }
                }
            }
            
            return -1;
            
        }
    }
    
    class Pair{
        int val ;
        int cost ;
        
        Pair(int x, int y){
            val = x ;
            cost= y ;
        }
    }
    
}
