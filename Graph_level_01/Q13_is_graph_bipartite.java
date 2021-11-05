package Graph_level_01;

import java.util.*;
import java.io.*;

public class Q13_is_graph_bipartite {
    
    
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
 
 static class Pair{ // custom pair class.
     int v ;
     String psf ;
     int level ;
     
     Pair(int v , String psf , int level){
         this.v = v ;
         this.psf = psf ;
         this.level = level ;
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
    
    int[] visited = new int[vtces] ; // making an integer visited array where -1 denotes that some particular vertex is not visited.
    Arrays.fill(visited,-1) ;
    
    for( int v = 0 ; v < vtces ; v++){
        if(visited[v] == -1){ // if vertex is not visited then check it is bipartite of  not.
            boolean is_bipartite = check_bipartitness(graph,v,visited) ;
            
            if(is_bipartite == false){ // if it's not bipartite then return false directly.
                System.out.print(false);
                return ;
            }
        }
    }
    
    System.out.print(true); // else true.
 }
 
 public static boolean check_bipartitness(ArrayList<Edge>[] graph , int src , int[] visited){
     ArrayDeque<Pair>  queue= new ArrayDeque() ;
     
     queue.add(new Pair(src , src + " ",0)) ; /// adding first vertex with path and level is 0.
     
     while(queue.size() > 0 ){
         Pair rp = queue.removeFirst(); // removing first pair of queue.
         
         if( visited[rp.v] != -1){ // if it is not -1 then it,
             // means already visited. so we'll check
             if(rp.level != visited[rp.v] ) { // if removed pair level is different than level in visited array then it means same vertex is getting used in different place so not bipartite.
                 return false ; // so returning false.
             }
         }
         else{ // else make it visited by storing the level in it.
             visited[rp.v] = rp.level ;
         }
         
         
         
         for( Edge e : graph[rp.v]){ // now accessing all the edges.
             if(visited[e.nbr] == -1){ // if neigbour of current vertex is not visited means is -1 then add it to the queue.
                 queue.add(new Pair(e.nbr , rp.psf + e.nbr , rp.level + 1 )); // adding with increased level.
             }
         }
     }
     
     return true  ; // if loop didn't gave false then return true.
 }
 

}
