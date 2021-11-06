package Graph_level_01;
import java.util.*;
import java.io.*;

public class Q14_Spread_Infection {

    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
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
  
        int src = Integer.parseInt(br.readLine());  // this is source where first person gets  infected.
        int t = Integer.parseInt(br.readLine()); // time 
        
        // write your code here

        ArrayDeque<Pair> queue = new ArrayDeque<>() ; // made an queue and insertd the first pair .
        int[] visited = new int[vtces] ; // visited array where 0 denotes any element is not visited.

        queue.add( new Pair(src, 1) ) ; // first source with 1 time is inserted as pair in queue.

        int count = 0 ;

        while (queue.size() > 0 ) {
            Pair rem = queue.removeFirst() ; // removed first.

            if(visited[rem.src] > 0){ // if visited array has value greater than 0 then it means value is already visited.
                continue ; // so we'll skip it.
            }

            visited[rem.src] = rem.time ; // stroing the time in visited array.

            if ( rem.time > t) { // if the given time (t) becomes less than removed pair then break;
                break ;
            }

            count++; // counting the infected patient.

            for (Edge e : graph[rem.src]) { // running for each edge of rem.src
                if ( visited[ e.nbr ] == 0){ // if neigbour is not visited(means visited value is 0) then add neigbour to queue.
                    queue.add(new Pair(e.nbr, rem.time + 1 )) ;
                }
            }
        }

        System.out.println( count ); // printing count.

     }
  


     static class Pair{ // using custom pair.
         int src  , time ;

         Pair(int src , int time){
             this.src = src ;
             this.time = time ;
         }
     }
    
}
