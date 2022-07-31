package Problem_Of_The_day;
import java.util.*;

/**
 * Q130_Sorting_Elements_of_an_Array_by_Frequency
 */
public class Q130_Sorting_Elements_of_an_Array_by_Frequency {

    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
         HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ch : arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( ) ;
        
        for(int key : map.keySet()){
            Pair p = new Pair(key,map.get(key)) ;
            pq.add(p) ;
        }
        
       ArrayList<Integer> ans = new ArrayList<>() ;
        
        while(pq.size() > 0){
            Pair p = pq.poll() ;
            int itr = p.count ;
            while(itr-- > 0){
                ans.add(p.ch) ;
            }
        }
        
        return ans ;
    }
    
    static class Pair implements Comparable<Pair> {
        int ch ;
        int count ;
        
        Pair(int x, int y){
            ch = x ;
            count = y;
        }
        
        public int compareTo(Pair ob){
            if(ob.count != this.count){
                return ob.count - this.count ;
            }
            else{
                return this.ch - ob.ch ;
            }
        }
    }
}