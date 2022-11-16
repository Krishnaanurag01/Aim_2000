package Problem_Of_The_day;
import java.util.*;

public class Q297_Longest_Perfect_Piece {

    static int longestPerfectPiece(int[] arr, int N) {
    
        // using two pq that is maxPQ and minPq
            PriorityQueue<Integer> maxPq = new PriorityQueue<>( Collections.reverseOrder()) ;
            PriorityQueue<Integer> minPq = new PriorityQueue<>() ;
            
            int i = -1 ; // left window
            int ans = 0 ;
            
            for(int j = 0 ; j < N ; j++){
                // add current val in both min and max pq
                maxPq.add(arr[j]) ;
                minPq.add(arr[j]) ;
                
                // untill the diff between max and min is not less than equal to 1, keep removing elements from left point
                while(maxPq.size() > 0 && maxPq.peek() - minPq.peek() > 1){
                        i++;
                        int val = arr[i] ;
                        maxPq.remove(val) ;
                        minPq.remove(val) ;
                }
                
                
                // if the diff become less than equal to 1 then update the answer with max window size.
                if(maxPq.peek() - minPq.peek() <= 1) ans = Math.max(ans, j - i) ;
            }
            
            return ans ;
        }
}
