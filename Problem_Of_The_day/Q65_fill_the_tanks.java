package Problem_Of_The_day;
import java.util.*;

public class Q65_fill_the_tanks {

    public static void main(String[] args) {
        
    }

    boolean[] visited ;
    long minimum_amount(int [][]Edges, int N, int S, int []Cap){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        visited = new boolean[N+1] ;
        
        for(int i = 0 ; i <= N ; i++){
            graph.add( new ArrayList<>() ) ;
        }
        
        for(int[] e : Edges){
             int u = e[0] ;
             int v = e[1] ;
             graph.get(u).add(v) ;
            //  graph.get(v).add(u) ;
        }
        
        return helper(graph,S,Cap) ;
    }
    
    long helper(ArrayList<ArrayList<Integer>> list, int s, int[] Cap){
        visited[s] = true ;
        
        long max = 0 ;
        for(int nbr : list.get(s) ){
            if(visited[nbr] == false ){
                long temp = helper(list,nbr,Cap) ;
                max = Math.max(max,temp) ;
            }
        }
        
        
        visited[s] = false ;
        return max*list.get(s).size() + Cap[s-1] ;
    }
}
