package Problem_Of_The_day;
import java.util.* ;

public class Q357_Minimum_Fuel_Cost_to_Report_to_the_Capital {
    
    long ans ;
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        
        // making graph
        for(int  i = 0 ; i <= roads.length ; i++){
            adj.add(new ArrayList<>()) ;
        }
        
        for(int[] r : roads){
            int u = r[0] ;
            int v = r[1] ;
            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        
        ans = 0 ;
        
        helper(0, adj, seats, -1) ;
        
        return ans ;
    }
    
    int helper(int currCity, ArrayList<ArrayList<Integer>> adj, int cap, int par){
        
        int people = 1 ; // each city has one person intially
        
        for(int nbr : adj.get(currCity)){
            if(nbr != par){
                people += helper(nbr, adj, cap, currCity) ; // getting other peoples
            }
        }
        
        if(currCity != 0){
            ans += Math.ceil((double)people/(double)cap) ; // people/seats -> no of cars moves 1 steps.
        }
        
        return people ;
    }
}
