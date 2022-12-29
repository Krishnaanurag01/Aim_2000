package Problem_Of_The_day;
import java.util.*;

public class Q321_Remove_Stones_to_Minimize_the_Total {

    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a) ;
        
        for(int pile : piles){
            pq.add(pile) ;
        }
        
        int ans = 0 ;
        
        while(pq.size() > 0){
            int val = pq.poll() ;
            if(k > 0){
                val = val - (val/2) ;
                k-- ;
                pq.add(val) ;
            }
            else{
                ans += val ;
            }
        }
        
        return ans ;
    }
}
