package Problem_Of_The_day;
import java.util.*;

public class Q388_Maximum_Intersecting_Lines {
    
    public int maxIntersections(int[][] lines, int N) {
        
        TreeMap<Long,Integer> map = new TreeMap<>() ;
        
        for(int[] l : lines){
            long x = l[0] ;  // left border from where line starts
            long y = l[1] + 1 ; // right border + 1 from where this line is not present
            map.put(x, map.getOrDefault(x,0)+1) ; // increasing count
            map.put(y, map.getOrDefault(y,0) -1) ; // decreasing count on y
        }
        
        int max = 1 ;
        int prefix = 0 ;
        for(Long key : map.keySet()){
            prefix += map.get(key) ; // simple do prefix sum
            max = Math.max(max, prefix) ; // and take the max answer
        }
        
        
        return max ;
    }
}
