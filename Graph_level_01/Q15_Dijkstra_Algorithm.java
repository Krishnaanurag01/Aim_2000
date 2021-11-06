package Graph_level_01;

import java.util.*;
import java.io.*;

public class Q15_Dijkstra_Algorithm {

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
  
        int src = Integer.parseInt(br.readLine());
        

        // *************************** Same as BFS with Priority Queue ****************************

        PriorityQueue<Pair> queue = new PriorityQueue<>() ;
        boolean[] visited = new boolean[vtces] ; // identify if vertex is visisted or not.

        queue.add(new Pair(src, src + "", 0)); // adding first source pair with 0 weight.

        while (queue.size() > 0) {
            Pair rem = queue.remove() ;

            if( visited[rem.src] == true){ // if removed pair is already visited then we don't have to print it.
                continue ;
            }

            visited[rem.src] = true ; // making visited and printing.

            System.out.println(rem.src + " via " + rem.psf + " @ "+rem.wsf);

            for (Edge e : graph[rem.src]) { // adding neigbours if they are not visited.
                if( visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr , rem.wsf + e.wt)) ; // adding neigbour with removed pair weight and psf.
                }
            }
        }
        
     }



     static class Pair implements Comparable<Pair> {
        int src ; // denotes vertex
        String psf ; // denotes path so far.
        int wsf ; // denotes weight so far.

        Pair(int src , String psf , int wsf ){
            this.src = src ;
            this.psf = psf ;
            this.wsf = wsf ;
        }

        @Override
        public int compareTo(Pair o) { // comparision based on the  weight.
         return this.wsf - o.wsf ;
        }
     }
    
}
