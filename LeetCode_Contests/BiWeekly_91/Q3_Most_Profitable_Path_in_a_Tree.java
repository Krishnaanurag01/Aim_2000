package LeetCode_Contests.BiWeekly_91;
import java.util.*;

public class Q3_Most_Profitable_Path_in_a_Tree {

    HashMap<Integer, ArrayList<Integer>> adj ; // adjency map
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        // creating the adjency list
        adj = new HashMap<>() ;
        
        for(int[] e : edges){
            int a = e[0] ;
            int b = e[1] ;
            
            if(adj.containsKey(a) == false) adj.put(a, new ArrayList<>()) ;
            if(adj.containsKey(b) == false) adj.put(b, new ArrayList<>()) ;
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        // 
        
        int n = amount.length ;
        int[] distance = new int[n] ; // and here we will store the distance from root (0 node) to other node.
        int[] parent = new int[n] ; // here we will store parent of every node
        
        // intializing distance and parent arr
        Arrays.fill(distance, -1) ;
        Arrays.fill(parent, -1) ;
        
        // now calculating the distance and parent with below function.
        fill_details(0,distance,parent,0,0);
        
        
        int curr = bob ; // now taking bob in a curr variable
        int curr_distance = 0 ; // this is distance from bob to current node (initially 0)
        
        
        while(curr != 0){
            if(distance[curr] > curr_distance){ // agr alice ka distance curr node tak jyda h bob se toh es node pr bob phle phocheg aur jo bhi cost ya reward hoga wo bob ka hoga and alice k liy ye 0 ho jayega
                amount[curr] = 0 ;
            }
            else if(distance[curr] == curr_distance){ // jab alice and bob ka distance current node k liy same h
                amount[curr] = amount[curr]/2 ;  // then divide the cost or reward in half
            }
            
            curr = parent[curr] ; // go to parent
            curr_distance++ ; // also bob distance will increase 
        }
        
        
        // now just find a path for alice  to leaf node that gives max amount to alice using dfs function below
        dfs(0,0, amount) ;
     
        return ans ;
    }
    
    
    int ans = Integer.MIN_VALUE ;
    HashSet<Integer> visited = new HashSet<>() ;
    
    // it find the path from root (0) to leaf that has maximum value for alice
    void dfs(int curr, int curr_amt, int[] amount){
        
        visited.add(curr) ;
        curr_amt += amount[curr] ;
        int traverse = 0 ;
        
        for(int nbr : adj.get(curr)){
            if(visited.contains(nbr) == false){
                dfs(nbr, curr_amt, amount) ;
                traverse++ ; // denotes ki hum ek baar dusre nbr par ja chuke h
            }
        }
        
        if(traverse == 0){ // means koi nbr par nhi gye hum toh matlab hum leaf node par h toh just update the answer.
            ans = Math.max(ans, curr_amt) ;
        }
    }
  
    
    
    void fill_details(int curr, int[] dist, int[] parent, int curr_dist, int curr_parent){
        
        dist[curr] = curr_dist ; // curr node tak ka distance
        parent[curr] = curr_parent ; // assigning parent
        
        for(int nbr : adj.get(curr)){
            if(nbr == curr_parent) continue ;// agar parent node h toh skip
            fill_details(nbr, dist, parent, curr_dist + 1, curr) ; // now for nbr node curr node is parent and the distnace get incremented by 1
        }
    }
}
