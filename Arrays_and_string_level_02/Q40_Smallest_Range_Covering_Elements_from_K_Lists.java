package Arrays_and_string_level_02;
import java.util.*;

public class Q40_Smallest_Range_Covering_Elements_from_K_Lists {


    public int[] smallestRange(List<List<Integer>> nums) {
        
        int[] ans = new int[]{-100000,100000} ;
        int max = Integer.MIN_VALUE ;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> (a[0] - b[0]) ) ;  // sorting based on first element of array.
        
        for(int i = 0 ; i < nums.size() ; i++){ 
             int[] firstElem = new int[3] ;
            
            firstElem[0] = nums.get(i).get(0) ; // first element of list[i] ;
            firstElem[1] = 0 ; // index of first elment ;
            firstElem[2] = i ; // denotes the ith index of list.
            
            max = Math.max(max , firstElem[0]) ; // finding the max value.
            pq.add(firstElem) ;
        }
        
        while(true){
            int[] min = pq.poll() ;
            
            if(max - min[0] + 1 < (ans[1] - ans[0] + 1 )){  // if the length of max and min is smaller than last ans then update it.
                ans[0] = min[0] ;
                ans[1] = max ;
            }
            
            min[1]++ ; // incrementing index of min element.
            
            if(min[1] == nums.get(min[2]).size()){ // if the min element index + 1(incremented in above line ) becomes equal to that list size that means we have used all the values of the list so directly break it.
                break ;
            }
            else{
                min[0] = nums.get(min[2]).get(min[1]) ; // getting the next element of min element list
                max = Math.max(max,min[0]) ; // checking for max
                pq.add(min) ; // and adding to pq
            }
        }
        
       
        
        return ans ;
    }
    
}
