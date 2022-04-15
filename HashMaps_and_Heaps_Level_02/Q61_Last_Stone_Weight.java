package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q61_Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>( (a,b) -> b -  a ) ;
        
        for(int val : stones)
            q.add(val) ;
        
        while(q.size() > 1){
            int max1 = q.poll() ;
            int max2 = q.poll() ;
            
            if(max1 == max2)
                continue ;
            
            q.add( Math.abs(max1-max2) ) ;
        }
        
        return q.size() > 0 ? q.poll() : 0 ; 
    }
}
