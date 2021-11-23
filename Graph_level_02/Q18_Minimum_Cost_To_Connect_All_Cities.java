package Graph_level_02;

import java.util.*;
import java.io.*;

/// we are simply finding the MST using prims algo.

public class Q18_Minimum_Cost_To_Connect_All_Cities {

    static class Edge implements Comparable<Edge> {
        int v;
        int wt;
    
        Edge(int nbr, int wt) {
          this.v = nbr;
          this.wt = wt;
        }
    
        @Override
        public int compareTo(Edge o) {
          return this.wt - o.wt;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
          graph.add(new ArrayList<>());
        }
    
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
          String[] parts = br.readLine().split(" ");
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          int wt = Integer.parseInt(parts[2]);
          graph.get(v1).add(new Edge(v2, wt));
          graph.get(v2).add(new Edge(v1, wt));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>() ;
        
        pq.add( new Edge(0,0) ) ;
        boolean[] visited = new boolean[vtces] ;
        
        int ans = 0 ;
        
        while( pq.size() > 0 ){
            
            Edge rem = pq.remove() ;
            
            if(visited[rem.v] == true ){
                continue ;
            }
            
            visited[rem.v] = true ;
            
            ans += rem.wt ;
            
            ArrayList<Edge> nbrs = graph.get(rem.v) ;
            
            for(Edge nbr : nbrs){
                if( visited[nbr.v] == false){
                    pq.add( nbr ) ;
                }
            }
        }
        
        
        System.out.print(ans) ;
    
    
      }
    
}
