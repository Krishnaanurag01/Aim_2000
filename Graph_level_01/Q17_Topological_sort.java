package Graph_level_01;
import java.util.*;
import java.io.*;

public class Q17_Topological_sort {

    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }

     // topological sort : is a permutation of vertices in directed acyclic graph such that for any edge (u,v) -> u must appears before v.
  
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
        }
  
        // write your code here
        Stack<Integer> stack = new Stack<>() ; // this will store the answer.
        boolean[] visited = new boolean[vtces] ;

        for (int v = 0; v < vtces ; v++) {
            if(visited[v] == false){
                arrange_topologically(graph,v,visited,stack) ;
            }
        }

        while (stack.size() > 0) { // printing answer.
            System.out.println(stack.pop());
        }
    }



    private static void arrange_topologically(ArrayList<Edge>[] graph, int v, boolean[] visited, Stack<Integer> stack) {

        visited[v] = true ;

        for (Edge e : graph[v]) {
            if(visited[e.nbr] == false){ // adding neigbours if they are not visited.
                arrange_topologically(graph, e.nbr , visited, stack);
            }
        }

        stack.push(v) ; // adding verteces in post order...

    }
    
}
