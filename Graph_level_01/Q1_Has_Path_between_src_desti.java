package Graph_level_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1_Has_Path_between_src_desti {

    /**
     *
     */
    public static class Edge {

        int src ;
        int nebh ;
        int wt ;

        Edge(int src , int nebh , int wt){
            this.src = src ;
            this.nebh = nebh ;
            this.wt = wt ;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        int vert = Integer.parseInt(br.readLine()) ; // taking number of vertex.

        ArrayList<Edge>[] graph = new ArrayList[vert] ; // making a graph of array list of vertix size.

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>() ;     // assigning new array list for each index.
        }

        int edges = Integer.parseInt(br.readLine()) ; // taking number of edges.

        for (int i = 0; i < edges ; i++) {
            String[] eg = br.readLine().split(" ") ; // taking edge :  vertex , its neighbor and the weight of edge , space seperated.
            int v1 = Integer.parseInt(eg[0]); // took vertex
            int v2 = Integer.parseInt(eg[1]); // took neighbor
            int wt = Integer.parseInt(eg[2]); // took weight

            graph[v1].add(new Edge(v1, v2, wt)) ; // adding edge on the v1 
            graph[v2].add(new Edge(v2, v1, wt)) ; // also for v2  because both are connected with same edge.
        }

        int src_vert = Integer.parseInt(br.readLine()) ; // now taking source vertex
        int dest_vert = Integer.parseInt(br.readLine()) ; // now taking destination vertex.

        boolean[] visited = new boolean[vert] ; // this will keep track of vertex which are visited.

        System.out.println( has_path(graph, src_vert, dest_vert, visited) )  ;

    

    }


    public static boolean has_path(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited) {
        
        if(src == dest) return true ; // the moment source == destination then return true.

        visited[src] = true ; // mark source vertex vsisited.

        for (Edge edge : graph[src]) { // now running for each edges in Arraylist of source.
            
            if(visited[edge.nebh] == false) { // if the neighbor is not visited then only run otherwise it won't stop.

            // if the neighbor can reach the destination then we can also reach the destination by going to neighbor.
                boolean path = has_path(graph, edge.nebh, dest, visited) ; // finding has_path with neighbor. 
                
                if (path == true) { // so even if one vertex gives true then immediately return true. 
                    return true ;
                }
            }

        }

// otherwise return false.
        return false ;
    }
    
}
