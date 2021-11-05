package Graph_level_01;

import java.io.*;
import java.util.*;

public class Q11_BFS {


    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
     
     // extra pair class.
     static class Pair{
         int src ;
         String psf ;
         
         Pair(int src , String psf){
             this.src = src ;
             this.psf = psf ;
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
           graph[v1].add(new Edge(v1, v2));
           graph[v2].add(new Edge(v2, v1));
        }
  
        int src = Integer.parseInt(br.readLine());
  
        // write your code here  

        LinkedList<Pair> queue = new LinkedList<>() ; // using queue for level order traversal.
        boolean[] visited = new boolean[vtces] ;

        queue.add(new Pair(src, src + "")) ; // adding first pair manually.

        while (queue.size() > 0) {
            Pair removed_Pair = queue.removeFirst() ; /// removing the first pair of queue

            if( visited[ removed_Pair.src ] == true ){ // if it is already visited then skip.
                continue ;
            }

            visited[ removed_Pair.src ] = true ; // else make it visited and print the vertex with path so far.

            System.out.println( removed_Pair.src + " @ " + removed_Pair.psf );

            for (Edge e : graph[removed_Pair.src]) { // adding all the neigbours if they are not visited.
                
                if( visited[e.nbr] == false ){
                    queue.add( new Pair(e.nbr, removed_Pair.psf + e.nbr)) ;
                }
            }



        }
     }
    
}
