package Graph_level_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q4_Get_Connected_Components_Of_A_Graph {


    static class Edge{
        int src, nbr , wt ;

        Edge(int src, int nbr , int wt){
            this.src = src ;
            this.nbr = nbr ;
            this.wt = wt ;
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in)) ;

        int vert = Integer.parseInt(br.readLine()) ;

        ArrayList<Edge>[] graph = new ArrayList[vert] ;
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>() ;
        }

        int edges = Integer.parseInt(br.readLine()) ;

        for (int i = 0; i < edges ; i++) {
            String[] path = br.readLine().split(" ") ;
            int v1 = Integer.parseInt(path[0]) ; 
            int v2 = Integer.parseInt(path[1]) ;
            int wt = Integer.parseInt(path[2]) ;
            graph[v1].add(new Edge(v1, v2, wt)) ;
            graph[v2].add(new Edge(v2, v1, wt)) ;
        }
        
        boolean[] visited = new boolean[vert] ;

        ArrayList<ArrayList<Integer>> comp = new ArrayList<>() ;

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false){
                ArrayList<Integer> inner_comp = new ArrayList<>() ;
                get_component(graph,i,visited,inner_comp) ;
                comp.add(inner_comp) ;
            } 
        }
//
        System.out.println( comp );
    }

    private static void get_component(ArrayList<Edge>[] graph, int src, boolean[] visited,
            ArrayList<Integer> inner_comp) {

                visited[src] = true ;
                inner_comp.add(src) ;

                for (Edge e : graph[src]) {
                    if( visited[ e.nbr ] != true){
                        get_component(graph, e.nbr , visited, inner_comp);
                    }
                }

    }

}
