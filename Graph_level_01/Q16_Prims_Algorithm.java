package Graph_level_01;

import java.util.*;
import java.io.*;

public class Q16_Prims_Algorithm {

    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }

    static class Pair implements Comparable<Pair>{
        int v ;
        int av ;
        int wt ;

        Pair(int v , int av , int wt){
            this.v = v ;
            this.av = av ;
            this.wt = wt ;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt ;
        }
    }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        // write your code here

        PriorityQueue<Pair> queue = new PriorityQueue<>() ;
        boolean[] visited = new boolean[vtces] ;

        queue.add(new Pair(0,-1,0)) ; /// adding first vertex 0 and -1 means 0 comes from -1 vertex with 0 weight.

        while (queue.size() > 0) {
            
            Pair rem = queue.remove() ; // removed pair with lowest weight.

            if(visited[rem.v] == true){ // if already visited then skip it.
                continue ;
            }

            visited[rem.v] = true ;

            if( rem.av != -1){ // and if previous acquire vertex is not -1 then print it.
                System.out.println("["+rem.v +"-"+rem.av +"@"+rem.wt+"]");
            }

            for (Edge e : graph[rem.v]) { // adding neigbours if not visited  before.
                if(visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr, rem.v , e.wt)) ;
                }
            }
        }





     }
  
    
}
