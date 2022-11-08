package LeetCode_Contests.Contest_318;
import java.util.*;

public class Q3_Total_Cost_to_Hire_K_Workers {

    public long totalCost(int[] costs, int k, int candidates) {
        
        PriorityQueue<Pair> leftPq = new PriorityQueue<>() ; // it holds candidates from left side of the cost array
        PriorityQueue<Pair> rightPq = new PriorityQueue<>() ; // holds from right side.
        int n = costs.length ;
        
        // now add candidates( this is number of candi from we will pick one) in left side.
        int i = 0;
        for(i = 0; i < candidates ; i++){
            leftPq.add( new Pair(costs[i],i)) ;
        }
        
        int left_boundary = i ; // means the next element that will  be added in left priorityQueue.
        
        
        int remaining_ele = n - left_boundary ;
        // if less candidate present then add them in right side otherwise candidates num from right side.
        remaining_ele = Math.min(remaining_ele, candidates) ;
        
        // adding from right side.
        for(int j = 0 ; j < remaining_ele ; j++){
            rightPq.add( new Pair( costs[ n - 1 - j], n - 1 - j)) ;
        }
        
        int right_boundary = n - 1 - remaining_ele ; // the next element from right that will be added in right priorityQueue.
        long ans = 0 ;
        
        while(k > 0 && leftPq.size() > 0 && rightPq.size() > 0){
            Pair left_min = leftPq.poll() ;
            Pair right_min = rightPq.poll() ;
            
            if(left_min.cost <= right_min.cost){ // if min from left side has lower cost then hire
                ans += (long)left_min.cost ;
                rightPq.add(right_min) ; // and add back right candi
                
                // now as left side has n-1 members and if we have other candidates left then add one to the left
                if(left_boundary <= right_boundary){
                    leftPq.add( new Pair(costs[left_boundary], left_boundary)) ;
                    left_boundary++;
                }
            }
            else{ // when right pq has smaller worker.
                ans += (long)right_min.cost ;
                leftPq.add(left_min) ;
                
                if(left_boundary <= right_boundary){
                    rightPq.add( new Pair(costs[right_boundary], right_boundary)) ;
                    right_boundary--;
                }
            }
            
            k-- ;
        }
        
        if(k > 0){
            PriorityQueue<Pair> pq = leftPq ;
            
            if(leftPq.size() == 0){
                pq = rightPq ;
            }
            
            while(k > 0){
                ans += (long)pq.poll().cost ;
                k-- ;
            }
        }
        
        
        return ans ;
    }
    
    
    class Pair implements Comparable<Pair>{
        int cost ; // cost of hiring 
        int idx ; // index of candidate in the array
        
        Pair(int x, int y){
            cost = x ;
            idx = y ;
        }
        
        public int compareTo(Pair o){
            if(this.cost == o.cost) return this.idx - o.idx ;// if cost is same then sort on the index
            return this.cost - o.cost ; // othwerwise sort on the cost.
        }
        
    }
}
