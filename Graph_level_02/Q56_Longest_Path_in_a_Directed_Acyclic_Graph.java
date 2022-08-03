package Graph_level_02;

import java.util.*;

public class Q56_Longest_Path_in_a_Directed_Acyclic_Graph {

    static class Pair {
        int wt;
        int v;

        Pair(int vr, int wt) {
            this.v = vr;
            this.wt = wt;
        }
    }

    // this is exact opposite of dikstra algo
    public static int[] maximumDistance(int v, int e, int src, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int nbr = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(nbr, wt));
        }

        int[] ans = new int[v];
        Arrays.fill(ans, Integer.MIN_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.wt - a.wt);
        pq.add(new Pair(src, 0));
        ans[src] = 0;

        while (pq.size() > 0) {
            Pair p = pq.poll();

            if (p.wt > ans[p.v]) { // if curr cost is greater then update it.
                ans[p.v] = p.wt;
            }

            for (Pair nbr : adj.get(p.v)) {
                if (ans[nbr.v] < p.wt + nbr.wt) {
                    pq.add(new Pair(nbr.v, p.wt + nbr.wt));
                }
            }
        }

        return ans;
    }


    // method 2 : using topo sort.

    public static int [] maximumDistance2(int v, int e, int src, int[][] edges) {
        
        int[] ans = new int[v] ;
        int[] indegree = new int[v] ;
        
        Arrays.fill(ans, Integer.MIN_VALUE) ;
        ans[src] = 0 ;
        
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int nbr = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(nbr, wt));
            indegree[nbr]++ ; // increasing the indegree of neighbours
        }
        
        LinkedList<Integer> q = new LinkedList<>() ;
        
        for(int i = 0 ; i < v ; i++){
            if(indegree[i] == 0){
                q.add(i) ;
            }
        }
        
        
        
        while(q.size() > 0 ){
            int rv = q.removeFirst() ;
            
            for(Pair nbr : adj.get(rv)){
                
                if(ans[rv] != Integer.MIN_VALUE){  // if the distance of removed vertice is not infinity then store the maax distance for nbr
                    ans[nbr.v] = Math.max(ans[nbr.v] , nbr.wt + ans[rv]) ;
                }
                
                indegree[nbr.v]-- ;
                
                if(indegree[nbr.v] == 0){
                    q.add(nbr.v) ;
                }
            }
            
        }
        
        return ans ;
    }
}
