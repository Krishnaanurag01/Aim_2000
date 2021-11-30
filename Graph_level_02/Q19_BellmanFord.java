package Graph_level_02;
import java.util.*;
import java.io.* ;

public class Q19_BellmanFord {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in)) ;

        String[] fl = br.readLine().split(" ") ;

        int v = Integer.parseInt(fl[0]) ; // vertices
        int e = Integer.parseInt(fl[1]) ; // edges

        int[][] graph = new int[e][3] ;

        for (int i = 0; i < e ; i++) {
            String[] path = br.readLine().split(" ") ;

            int u = Integer.parseInt(path[0]) ;
            int nbr = Integer.parseInt(path[1]) ;
            int wt = Integer.parseInt(path[2]) ;

            graph[i][0] = u ;
            graph[i][1] = nbr ;
            graph[i][2] = wt ;

        }

        int[] path = new int[v] ; // this will store the max weight from source to current vertex(i)

        Arrays.fill(path, Integer.MAX_VALUE); // storing max by default
 
        path[0] = 0 ; // storing 0 for source.


        for (int i = 0; i < v - 1 ; i++) {   // runs for v  - 1 edges
            for (int j = 0; j < e ; j++) { // running for each edges.
                
                int u = graph[j][0] - 1;  // making 0 based vertex insted of 1
                int nbr = graph[j][1] - 1;
                int wt= graph[j][2] ; 

                if(path[u] == Integer.MAX_VALUE){ // if u doesn't have weight yet then skip
                    continue ;
                }

                if(path[u] + wt < path[nbr]){ // else check if u's weight + current weight ( between u and v) < path[nbr] then update it.
                    path[nbr] = path[u] + wt ;
                }
            }
        }

        for (int i = 1; i < path.length; i++) { // now printing from 1 to n.
            
            if(path[i] != Integer.MAX_VALUE){ // this denotes that there's no cycle and must be answer then print
                System.out.print(path[i] + " ");
            }
            else{// else print 1e9 for negative cycle....
                System.out.print("1000000000"+" ");
            }
        }
	}
}
