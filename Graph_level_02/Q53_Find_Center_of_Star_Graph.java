package Graph_level_02;
import java.util.*;

public class Q53_Find_Center_of_Star_Graph {
    
    public int findCenter(int[][] edges) {
     
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int[] e : edges){
            map.put(e[0],map.getOrDefault(e[0],0)+1);
            map.put(e[1],map.getOrDefault(e[1],0)+1);
        }
        
        
        // the node with highest freq is centre node
        int ans = 0 ;
        int freq = 0 ;
        for(int key : map.keySet()){
            if(map.get(key) > freq){
                ans = key ;
                freq = map.get(key) ;
            }
        }
        
        return ans ;
    }
}
