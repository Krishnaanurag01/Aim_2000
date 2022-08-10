package Graph_level_02;
import java.util.*;

public class Q64_Travelling_Salesman_Problem {
    
    public int total_cost(int[][] cost)
    {
        HashSet<Integer> set = new HashSet<>() ; // this is a visited set.
        set.add(0) ;
        return helper(0,cost,set) ;
    }
    
    int helper(int src, int[][] cost, HashSet<Integer> set){
        
        if(set.size() - 1 == cost.length - 1){ // if visited set has n-1 element already so current iteration src is last element so we will return the cost of last element to 0th node.
            return cost[src][0] ;
        }

        int ans = (int)1e9 ;
        for(int i = 0 ; i < cost.length ; i++){
            if(set.contains(i) == false){ // going to all non visited city 
                set.add(i);
                int temp = cost[src][i] + helper(i,cost,set) ;
                set.remove(i) ; // backtracking
                ans = Math.min(ans,temp) ; // and comparing the answer
            }
        }
        
        return ans ;
    }
}
