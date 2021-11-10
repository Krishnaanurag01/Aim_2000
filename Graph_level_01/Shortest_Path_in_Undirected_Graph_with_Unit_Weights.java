package Graph_level_01;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Shortest_Path_in_Undirected_Graph_with_Unit_Weights {
    

    public static void print_shorted_path_from_source(ArrayList<ArrayList<Integer>> adj , int V , int source) {
      
        int[] dist = new int[V] ;

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE ;
        }

      ArrayDeque<Integer> queue = new ArrayDeque<>() ;

      queue.add(source) ;

      dist[source] = 0 ;
      
      while (queue.size() > 0) {
          int rem = queue.removeFirst() ;

          for (Integer in : adj.get(rem)) {
              if(dist[rem] + 1 < dist[in]){
                dist[in] = dist[rem] + 1;
                queue.add(in);
              }
          }
      }

      for (int i = 0; i < dist.length; i++) {
          System.out.println( source +" - > " + i + " is " + dist[i] + " " );
      }
      
    }
}
