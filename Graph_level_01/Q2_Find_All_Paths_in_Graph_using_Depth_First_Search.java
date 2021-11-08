package Graph_level_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2_Find_All_Paths_in_Graph_using_Depth_First_Search {

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

        int vert = Integer.parseInt( br.readLine() ) ;

        ArrayList<Edge>[] graph = new ArrayList[vert] ; 

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>() ;
        }

        int edges = Integer.parseInt( br.readLine() ) ;

        for (int i = 0; i < edges; i++) {
            String[] path = br.readLine().split(" ") ;
            int v1 = Integer.parseInt(path[0]) ;
            int v2 = Integer.parseInt(path[1]) ;
            int wt = Integer.parseInt(path[2]) ;
            graph[v1].add(new Edge(v1, v2, wt)) ;
            graph[v2].add(new Edge(v2, v1, wt)) ;
        }

        int src =  Integer.parseInt(br.readLine() ) ;
        int destination =  Integer.parseInt(br.readLine() ) ;
        
        boolean[] visited = new boolean[vert] ;

        print_all_paths(graph, src, destination, visited, "");
        
    }

    // almost same as Questions 01.
    public static void print_all_paths(ArrayList<Edge>[] graph , int source , int dest , boolean[] visited , String psf) {
        
        if( source == dest ) { // when source == destination then print the path so far.
            System.out.println( psf ); // printing the path.
            return ;
        }

        visited[source] = true ; // making it visited.

        for (Edge edge : graph[source]) {
            if(visited[edge.nebh] != true){ // if neigbours are not visited then call the function with source = neigbours.
                print_all_paths(graph, edge.nebh , dest, visited, psf+edge.nebh);
            }
        }

        visited[source] = false ; // making it unvisited. so that, we can run with another vertex.

    }
    
}
