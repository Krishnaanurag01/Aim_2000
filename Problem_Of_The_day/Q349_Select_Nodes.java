package Problem_Of_The_day;
import java.util.*;

public class Q349_Select_Nodes {

    public int countVertex(int N, int[][] edges){
        
        // making adj list.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        int dp[][] = new int[N][2] ; // 0th index denote if current src is not lightened up and 1 denotes if it is lightend
        
        for(int i = 0 ; i < N ; i++){
            adj.add(new ArrayList<>()) ;
            dp[i] = new int[]{0,1} ; // agar light up nhi hoga toh 0 cost aur hoga toh 1 cost.
        }
        
        for(int[] e : edges){
            adj.get(e[0] - 1).add(e[1] - 1) ;
            adj.get(e[1] - 1).add(e[0] - 1) ;
        }
        
        // using dp where 0 denotes not picked and 1 denotes picked.
        
        
        dfs(adj, 0, 0, dp) ; // giving src and parent.
        
        return Math.min(dp[0][0], dp[0][1]) ;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj, int src, int par, int[][] dp){
        
        for(int nbr : adj.get(src)){ // going to childs.
            if(nbr != par){
                dfs(adj, nbr, src, dp) ;
            }
        }
        
        
        for(int nbr : adj.get(src)){
            if(nbr != par){
               dp[src][0] += dp[nbr][1] ; // agar src ko nhi lenge toh eske child ko lena padega
               dp[src][1] += Math.min(dp[nbr][0], dp[nbr][1]) ;/// agar src ko lete h toh eske child ko le bhi saktey aur nhi bhi jisme min answer usko le lo.
            }
        }

    }
}
