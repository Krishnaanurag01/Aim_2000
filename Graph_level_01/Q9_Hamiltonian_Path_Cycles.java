package Graph_level_01;
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.util.*;

public class Q9_Hamiltonian_Path_Cycles {
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
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
           graph.add( new ArrayList<>());
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph.get(v1).add(new Edge(v1, v2, wt));
           graph.get(v2).add(new Edge(v2, v1, wt));
        }
  
        int src = Integer.parseInt(br.readLine());
  
        // write all your codes here

        HashSet<Integer> visited = new HashSet<>() ; // work same as boolean visited array.

        print_path(graph,src,visited , src +"",src) ;
     }

    private static void print_path(ArrayList<ArrayList<Edge>> graph, int src, HashSet<Integer> visited, String psf,int original_src) {

        if( visited.size() == graph.size() - 1 ) { // the moment visited set becomes equal to graph.length -1 which means that visited set contains all the vertex of graph.
            System.out.print(psf); // so printint the path.
            boolean is_cycle = false ; // this will denotes if path is hamiltonian cycle.

            for (Edge e : graph.get(src) ) { // if any of the edge node is equal to original source then it is cycle. 
                if(e.nbr == original_src){
                    is_cycle = true ; // so make true and break the loop.
                    break ;
                }
            }

            if(is_cycle == true){ // if it's cycle then add " * " at the end of the path.
                System.out.print("*");
            }
            else{ // if it's not cycle then it is hamiltonian path so adding " . " at the end of the path.
                System.out.print(".");
            }
        }


        visited.add(src) ; // adding vertex to the set.

        for (Edge e : graph.get(src)) { // running loop on all its edges.
            if(visited.contains(e.nbr) == false){
                print_path(graph, e.nbr , visited, psf + e.nbr, original_src);
            }
        }

        visited.remove(src) ; // now removing the vertex from set as it is visited so making unvisited for next iteration.
    
    }
}
