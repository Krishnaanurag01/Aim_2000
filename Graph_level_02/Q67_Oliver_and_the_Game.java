package Graph_level_02;
import java.util.*;
import java.io.*;

public class Q67_Oliver_and_the_Game {

    static long[] inTime ; // here we will store in time of each city
    static long[] outTime ; // and exit time for each city
    static boolean[] visited ;
    static long time;

    public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //total city
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){ 
            graph.add( new ArrayList<>()) ;
        }

        for(int i = 0 ; i < n - 1 ; i++){ // makig graph at the same time while taking edges
            String ed = br.readLine() ;
            String[] edge = ed.split(" ") ;
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.get(u).add(v) ;
            graph.get(v).add(u) ;
        }

        visited = new boolean[n+1] ;
        inTime = new long[n+1] ;
        outTime = new long[n+1] ;
        time = 1 ;

        dfs(1,graph) ; // now calculating the intime and outtime of every city
        int Q = Integer.parseInt(br.readLine()) ; // query 
        while(Q-- > 0){
            String[] query = br.readLine().split(" ") ;
            int id = Integer.parseInt(query[0]) ;
            int x = Integer.parseInt(query[1]) ; 
            int y = Integer.parseInt(query[2]) ; 

            if(id == 0){
                if(checkIsYSubtreeOfX(x,y)){ // this checks whether y is subtree in x
                    System.out.println("YES") ;
                }
                else{
                    System.out.println("NO") ;
                }
            }
            else{
                if(checkIsYSubtreeOfX(y,x)){ // and checks whether x is subtree in y
                    System.out.println("YES") ;
                }
                else{
                    System.out.println("NO") ;
                }
            }

        }

    }

    static void dfs(int src, ArrayList<ArrayList<Integer>> adj){
        inTime[src] = time ; // storing the intime
        visited[src] = true; 
        time++ ;

        for(int nbr : adj.get(src)){
            if(visited[nbr] == false){
                dfs(nbr,adj) ;
            }
        }

        outTime[src] = time ; // outime
        time++ ;
    }

    static boolean checkIsYSubtreeOfX(int x, int y){

        // if y intime is greater than x means y comes after x and it's outime is less than x outime means y ends before ending the x then y is subtree of x
        if(inTime[y] >= inTime[x] && outTime[y] <= outTime[x]) return true;
        return false;
    }

}
