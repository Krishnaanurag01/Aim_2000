package Binary_Search;
import java.util.*;

public class Q2_Time_Based_Key_Value_Store {

    class TimeMap {   
        HashMap<String, TreeSet<Pair>> map ;
        public TimeMap() {
            map = new HashMap<>() ;
        }
        
        public void set(String key, String value, int timestamp) {
            TreeSet<Pair> set = map.getOrDefault(key, new TreeSet<>()) ;
            set.add( new Pair(value, timestamp)) ; // storing in a treeSet.
            map.put(key,set) ;
        }
        
        public String get(String key, int timestamp) {
            
            if(map.containsKey(key) == false) return "" ; // if map does not have key
            
            TreeSet<Pair> set = map.get(key) ;
            
            Pair pair = set.floor(new Pair("xx",timestamp)) ; // making a pair with random value and given time stamp so that we can get floor of current pair.
            
            if(pair == null) return "" ; // if it is null then return ""
            
            return pair.value ;
        }
        
        class Pair implements Comparable<Pair>{
            String value ;
            int ts ; // time stamp
            
            Pair(String x, int y){
                value = x ;
                ts = y ;
            }
            
            public int compareTo(Pair p){ // sorting on the basis of value.
                return this.ts - p.ts ;
            }
            
            public String toString(){
                return this.value +" -- " + this.ts ;
            }
        }
    }
    
    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
}
