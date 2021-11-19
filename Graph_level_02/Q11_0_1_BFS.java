package Graph_level_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q11_0_1_BFS {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ) ;

        String[] fl = br.readLine().split(" ");
        int n =  Integer.parseInt( fl[0] ) ; // number of vertices.
        int m =  Integer.parseInt( fl[1] ) ; // number of edges.

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;

        for (int i = 0; i <  n ; i++) {
            graph.add( new ArrayList<>() ) ;
        }


        for (int i = 0; i < m ; i++) {
            
            String[] input_edges = br.readLine().split(" ") ;

            int u = Integer.parseInt(input_edges[0]) - 1 ; // converting vertex to start from 0 not from 1.
            int v = Integer.parseInt(input_edges[1]) - 1 ; // converting vertex to start from 0 not from 1.

            graph.get(u).add( new Pair(v, 0)) ; // and this is already gieven so adding it with weight 0.
            graph.get(v).add( new Pair(u, 1)) ; // adding reverse edge by giving weight 1.
        }

        LinkedList<Pair> queue = new LinkedList<>() ; // helps in bfs.
        boolean[] visited = new boolean[n] ; 

        queue.add(new Pair(0,0)) ;

        while ( queue.size() > 0) {

            Pair rem = queue.removeFirst() ; // removing first pair.

            if( rem.src == n-1) { // if we got the last vertex then print the weight and return.
                System.out.println( rem.weight );
                return ;
            }

            visited[rem.src] = true ; // making it visited.

            for (Pair b : graph.get(rem.src)) { // going through all the pairs.
                
                if( visited[ b.src ] == true){ // if vertex is already visited then skip.
                    continue ;
                }

                if( b.weight == 0){ // if weight is zero then add it to the front.
                    queue.addFirst(new Pair(b.src, rem.weight + 0));
                }
                else{ // else add it to the end.
                    queue.addLast(new Pair(b.src, rem.weight + 1));
                }


            }

        }

        System.out.println(-1);

    }




    static class Pair {
        int src , weight ;

        Pair( int src , int weight){
            this.src = src ;
            this.weight = weight ;
        }
    }
    
}
