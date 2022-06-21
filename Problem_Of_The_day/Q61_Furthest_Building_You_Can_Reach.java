package Problem_Of_The_day;
import java.util.*;

public class Q61_Furthest_Building_You_Can_Reach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>( ) ; // this will store different size of ladder that we have used.
       
        for(int i = 0 ; i < heights.length ; i++){
            if(i == heights.length - 1) return i ;
            int curr = heights[i] ;
            int next = heights[i+1] ;
            int diff = next - curr ;
            
            if(curr >= next){
                continue ;
            }
            else if(q.size() < ladders){ // if we can use ladder then go for it first.
                q.add(diff) ;
            }
            else if(q.size() > 0 && q.peek() < diff){ // now check if the ladder size is smaller than current diff then swap the ladder with bricks and new ladder will be of current diff. 
                int removed = q.poll() ;
                q.add(diff) ;
                if(bricks >= removed)
                bricks -= removed ;
                else return  i ;
            }
            else if(bricks >= diff) bricks -= diff ; // else if enough bricks present then use it.
            else return i ; // else return index.
        }
        
        return heights.length-1 ;
    }
}
