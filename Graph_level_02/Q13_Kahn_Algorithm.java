package Graph_level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

// This is topological sorts Iterative method.

public class Q13_Kahn_Algorithm {

    public static void main(String[] args) throws NumberFormatException, IOException {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String[] fl = br.readLine().split(" ");
        int n = Integer.parseInt(fl[0]) ;
        int m = Integer.parseInt(fl[1]) ;

        int[][] prerequisites = new int[m][2] ;

        for (int i = 0; i < m ; i++) {
            String[] ip = br.readLine().split(" ") ;
            prerequisites[i][0] = Integer.parseInt(ip[0]);
            prerequisites[i][1] = Integer.parseInt(ip[1]);
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;

        for (int i = 0; i < n ; i++) {
            graph.add(new ArrayList<Integer>()) ;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            graph.get(v).add(u) ;
        }

        int[]  order = findOrder(n,graph) ;

        for (int i : order) {
            System.out.print(i + " ");
        }
    }

    private static int[] findOrder(int n, ArrayList<ArrayList<Integer>> graph) {

        int[] ans = new int[n] ; // this will contain the answer.
        int[] innerCount = new int[n] ; // this will contain the count of each vertex.

        for (int i = 0; i < n ; i++) {
            for (int nbr : graph.get(i)) { // we access the neighbours of every vertex and increase the count.
                innerCount[nbr]++;
            }
        }

        LinkedList<Integer> queue  = new LinkedList<>() ; // for bfs.

        for (int i = 0; i < innerCount.length; i++) {
            if(innerCount[i] == 0){ // now we check if any vertex count is 0 then add it to the queue as it does not depend on any vertex so it can come before in sorting.
                queue.add(i) ;
            }
        }

        int index = 0 ; // for storing in ans array.

        while (queue.size() > 0) {
            
            int rem = queue.removeFirst() ; // removing the first 

            ans[index] = rem ; // adding it to the answer
            index++;

            for (Integer nbr : graph.get(rem)) { // now going to each neigbour of removed vertex and decrementing the count.
                innerCount[nbr]-- ;

                if(innerCount[nbr] == 0){ // if the count becomes 0 then add it to the queue.
                    queue.add(nbr) ;
                }
            }
        }

        
        if(index == n){ // this denotes that we have all the elements in ans array then return answer array.
            return ans ;
        }
        else{ // else can't be topological sort so return -1.
            return new int[]{-1} ;
        }

    }
    
}
