package Graph_level_01;
import java.util.*;
import java.io.*;

public class Q18_Iterative_Depth_First_Traversal {

    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }

     // making custom pair class
     static class Pair{
         int vertex ;
         String psf ;

         Pair(int vertex , String psf){
            this.vertex = vertex ;
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
  
        // logic starts from here.

        boolean[] visited = new boolean[vtces] ;
        Stack<Pair> stack = new Stack<>() ; // using stack instead of queue.

        stack.push(new Pair(src, src + "")) ;

        while (stack.size() > 0) {
            
            Pair rem = stack.pop() ; // removing the top pair.

            if( visited[rem.vertex] == true){ // means already visited.
                continue ;
            }

            // else make it visit.

            visited[rem.vertex] = true ;

            System.out.println(rem.vertex + "@" + rem.psf);

            for (Edge e : graph[rem.vertex]) { // adding neigbours if they are not viisted before.
                if(visited[e.nbr] == false){
                    stack.push(new Pair(e.nbr, rem.psf + e.nbr)) ;
                }
            }
        }
        



    }
    
}
