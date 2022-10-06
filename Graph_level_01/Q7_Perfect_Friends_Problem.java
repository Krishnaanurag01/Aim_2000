package Graph_level_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q7_Perfect_Friends_Problem {

    static class Edge{
        int src , nbr  ;

        Edge(int src , int nbr){
            this.src = src ; 
            this.nbr = nbr ;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        int n = Integer.parseInt(br.readLine()) ; // vertex.
        int k = Integer.parseInt(br.readLine()) ; // edges.

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>() ;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()) ;
        }

        for (int i = 0; i < k ; i++) {
            String[] path = br.readLine().split(" ") ;
            int v1 = Integer.parseInt(path[0]) ;
            int v2 = Integer.parseInt(path[1]) ;
            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));
        }


        ArrayList<ArrayList<Integer>> comp = new ArrayList<>() ;

        boolean[] visited = new boolean[n] ;

        for (int i = 0; i < n ; i++) {
            
            if(visited[i] == false){
                ArrayList<Integer> inner_comp = new ArrayList<>() ;
                get_comp(graph,i,visited,inner_comp);
                comp.add(inner_comp) ;
            }
        }

        // till here code is same as Q4.

        // System.out.println(comp);

        int pairs = 0 ; // this will contains the total pair.

        for (int i = 0; i < comp.size() ; i++) { // now finding combinations
            for (int j = i + 1 ; j < comp.size() ; j++) { // pairing i with i+1 to j.
                pairs += (comp.get(i).size() * comp.get(j).size()) ; // multiplying the size of component and adding it to the path.
            }
        }
        
        System.out.println( pairs );
    }

    // same as Q4.

    private static void get_comp(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited , ArrayList<Integer> list) {
        visited[src] = true ;
        list.add(src) ;
        
        for (Edge e : graph.get(src)) {
            if(visited[e.nbr] == false){
                get_comp(graph, e.nbr , visited, list);
            }
        }
    }
    
}
