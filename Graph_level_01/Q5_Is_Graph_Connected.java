package Graph_level_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q5_Is_Graph_Connected {

    static class Edge{
        int src , nbr , wt ;

        Edge(int src , int nbr , int wt){
            this.src = src ; 
            this.nbr = nbr ;
            this.wt = wt ;
        }
    }


    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in)) ;

        int vertex = Integer.parseInt(br.readLine()) ;

        ArrayList<Edge>[] graph = new ArrayList[vertex] ;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>() ;
        }

        int edges = Integer.parseInt(br.readLine()) ;

        for (int i = 0; i < edges ; i++) {
            String[] path = br.readLine().split(" ") ;
            int v1 = Integer.parseInt(path[0]);
            int v2 = Integer.parseInt(path[1]);
            int weight = Integer.parseInt(path[2]);

            graph[v1].add(new Edge(v1, v2, weight)) ;
            graph[v2].add(new Edge(v2, v1, weight)) ;
        }                                                            // rest of the code is same as Q4.

        boolean[] visited = new boolean[vertex] ;

        ArrayList<ArrayList<Integer>> compo = new ArrayList<>() ;

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false){

                ArrayList<Integer> inner_comp = new ArrayList<>() ;
                get_component(graph,i,visited,inner_comp) ;
                compo.add(inner_comp) ;
            }
        }

        System.out.println( compo.size() == 1); // if graph has only one component then it will return true otherwise false.

    }


    private static void get_component(ArrayList<Edge>[] graph, int src, boolean[] visited,
            ArrayList<Integer> inner_comp) {

                visited[src] = true ;
                inner_comp.add(src) ;
                for (Edge e : graph[src]) {
                    if(visited[e.nbr] != true){
                        get_component(graph, e.nbr , visited, inner_comp);
                    }
                }

    }

    
    
}
