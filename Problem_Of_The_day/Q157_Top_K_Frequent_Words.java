package Problem_Of_The_day;
import java.util.*;

public class Q157_Top_K_Frequent_Words {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1) ;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( ) ;
        
        for(String key  : map.keySet()){
            pq.add(new Pair(key,map.get(key))) ;
        }
        
        List<String> ans = new ArrayList<>() ;
        
        while(k-- > 0){
            ans.add(pq.poll().key) ;
        }
        
        return ans ;
    }
    
    class Pair implements Comparable<Pair>{
        String key ;
        int freq ;
        Pair(String x, int y){
            key = x ;
            freq = y ;
        }
        
        public int compareTo(Pair o){
            if(o.freq != this.freq){
                return o.freq - this.freq ;
            }
            else{
                return this.key.compareTo(o.key) ; // if freq is same the sort lexicographically based on key
            }
        }
    }
}
