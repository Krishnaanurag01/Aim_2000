package Problem_Of_The_day;
import java.util.*;

public class Q46_Gadgets_of_Doraland {

   class Pair implements Comparable<Pair>{

    int value ;
    int freq ;

    Pair(int x , int y){
        value = x ;
        freq = y ;
    }

    public int compareTo(Pair o){
        
        if(this.freq != o.freq){
            return o.freq - this.freq ;
        }
        else{
            return o.value - this.value ;
        }

    }

   }

    ArrayList<Integer> TopK (ArrayList<Integer> array, int k)
    {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for (Integer in : array) {
            map.put(in, map.getOrDefault(in, 0) + 1) ;
        }

        PriorityQueue<Pair> q = new PriorityQueue<>() ;

        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            q.add( new Pair(e.getKey(),e.getValue())) ;
        }

        ArrayList<Integer> ans = new ArrayList<>() ;

        while (k-- > 0) {
            // ans.add(q.poll()[0]) ;
            System.out.print(q.poll().value + " ");
        }


        return ans ;
    }
    
}
