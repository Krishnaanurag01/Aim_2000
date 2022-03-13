package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q50_The_Skyline_Problem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        
        // step 1 : make a pair of starting point and height  AND ending point and height.
        ArrayList<pair> list = new ArrayList<>() ;
        
        for(int[] building : buildings){
            int sp = building[0] ; // starting point
            int ep = building[1] ; // ending point
            int ht = building[2] ; // height
            
            list.add( new pair(sp,-ht)) ; // adding pair of starting point and height(as negative becuase it will help us in identifying that this pair is starting pair.)
            list.add( new pair(ep,ht)) ; // adding pair of ending point and height
        }
        
        Collections.sort(list); // sorting the pairs
        
        int ch = 0 ; // current height contains the max height always
        
        // makinng a max priority queue which will help us in choosing the max height.
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(0) ; // adding 0 as height
        
        List<List<Integer>> ans = new ArrayList<>() ;
        
        for(pair p : list){
            
            int sp = p.x ;
            int ht = p.ht ;
            
            if(ht < 0){ // when negative -> denotes it is starting pair so starting pair height is added in q
                q.add(-ht); // adding it by making positive
                
            }
            else{ // for ending pair
                 q.remove(ht) ; // removing because this height could will not be used.
            }
            
            if(ch != q.peek()){
                // when current height is not equals to pq's max height then this is one the output point.
                List<Integer> subAns = new ArrayList<>() ;
                subAns.add(sp); // adding starting point
                subAns.add(q.peek()); // adding pq's max heihgt
                
                ans.add(subAns) ;
                ch = q.peek() ;
            }
            
            
        }
        
        return ans;        
        
    }
    
    
    static class pair implements Comparable<pair>{
        int x ;  // starting point Or ending point
        int ht ;  // height
        
        pair(int a , int b){
            x = a ;
            ht = b ;
        }
        
        public int compareTo(pair o){
            if(this.x != o.x){
                return this.x - o.x ; /// sorting based on the starting point when not same
            }
            else{ // else sorting on the height basis
                return this.ht - o.ht ;
            }
        }
        
    }
    
}
