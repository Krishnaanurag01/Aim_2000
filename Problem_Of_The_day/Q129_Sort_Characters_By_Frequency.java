package Problem_Of_The_day ;
import java.util.*;

public class Q129_Sort_Characters_By_Frequency {

    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> b.count - a.count ) ;
        
        for(Character key : map.keySet()){
            Pair p = new Pair(key,map.get(key)) ;
            pq.add(p) ;
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        while(pq.size() > 0){
            Pair p = pq.poll() ;
            int itr = p.count ;
            while(itr-- > 0){
                sb.append(p.ch) ;
            }
        }
        
        return sb.toString() ;
    }
    
    class Pair{
        char ch ;
        int count ;
        
        Pair(char x, int y){
            ch = x ;
            count = y;
        }
    }
}
