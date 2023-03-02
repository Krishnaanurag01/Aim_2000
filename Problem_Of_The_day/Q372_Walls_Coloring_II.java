package Problem_Of_The_day ;
import java.util.*;

/**
 * Q372_Walls_Coloring_II
 */
public class Q372_Walls_Coloring_II {

    // similar to painting fences with 3 colours question.

	int minCost(int [][] costs) {
	    if(costs.length > 1 && costs[0].length <= 1) return -1 ; // if theres more than 1 house and only one colour  then its impossible to paint
	    
		int[] ans = new int[costs[0].length] ; // storing answers 
		
		// storing ans for 1st wall
		for(int j = 0 ; j < costs[0].length ; j++){
		    ans[j] = costs[0][j] ;
		}
		
		for(int i = 1 ; i < costs.length ; i++){
		    
		    // now we are finding the 2 min cost so far so that we can use it in painting next colour
		    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]) ; // taking max pq
		    
		    for(int k = 0 ; k < costs[0].length ; k++){
		        if(pq.size() < 2){ 
		            pq.add(new int[]{ans[k], k}) ;
		        }
		        else{ // when we already have 2 element in pq
		            pq.add(new int[]{ans[k], k}) ; // add new one
		            pq.poll() ; // and remove the one with max value
		        }
		    }
		    
		    int[] min1 = pq.poll() ;
		    int[] min2 = pq.poll() ;
		    
		    // now storing ans if we colour current wall wth K.
		    for(int k = 0 ; k < costs[0].length; k++){
		        
		        // current wall ko k colour se paint karnen ka cost = k colour cost + last walls ka total min cost
		        
		        if(min1[1] != k && min2[1] != k){ // agar dono min wale colour current k colour ko use nhi kar rhe
		            ans[k] = Math.min(min1[0], min2[0]) + costs[i][k] ; // toh current wall ka cost + last min cost
		        }
		        else if(min1[1] != k){ // agar k colour min1 k equal nhi h toh
		            ans[k] = min1[0] + costs[i][k] ;
		        }
		        else{ // agar min2 barabar nhi h
		            ans[k] = min2[0] + costs[i][k] ;
		        }
		    }
		}
		
		// now return the min ans.
		int result = (int)1e9 ;
		
		for(int val : ans){
		    result = Math.min(result, val) ;
		}
	
		return result;
	}
    
}