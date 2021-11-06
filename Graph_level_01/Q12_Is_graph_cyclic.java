package Graph_level_01;

import java.util.*;
import java.io.*;

public class Q12_Is_graph_cyclic {
    
    static class Edge {
        int src; // denotes vertex.
        int nbr; // denotes neigbours.
        int wt; // denotes weight.
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }

     // making an extra custom pair class.
     static class Pair{
        int v ;
        String psf ;

        Pair(int v , String psf){
            this.v = v;
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
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        // write your code here

        boolean[] visited = new boolean[vtces] ;

        for (int v = 0; v < vtces ; v++) {
            
            if( visited[v] == false){ // check for each vertex if it is not visited.
                boolean is_cyclic = check_if_cyclic(graph,visited,v) ;

                if( is_cyclic){
                    System.out.println(true);
                    break ;
                }
            }
        }

        System.out.println(false);

    }



    // Using bfs.
    private static boolean check_if_cyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {

        ArrayDeque<Pair> queue = new ArrayDeque<>() ;
        queue.add(new Pair(src, src+"")) ;

        while (queue.size() > 0) {
            
            Pair removed_pair = queue.removeFirst() ;

            if( visited[removed_pair.v] == true ){ // when the removed pair is already visited then it means theres some loop so return.
                return true ;
            }

            visited[removed_pair.v] = true ; //else mark visited and add its neigbour.

            for (Edge e : graph[removed_pair.v]) {
                if(visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr, removed_pair.psf + e.nbr)) ;
                }
            }
        }

        return false;
    }
}
