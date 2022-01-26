package Arrays_and_string_level_02;
import java.util.*;

public class Q75_Top_K_Frequent_Elements {


    // leetcode solution : 

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1) ;
        }
        
        PriorityQueue<int[]> q =new PriorityQueue<>( (a,b) -> b[1] - a[1] ) ;
        
        for(Map.Entry<Integer,Integer> e : map.entrySet() ) {
            q.add(new int[]{(int)e.getKey() , (int)e.getValue() }) ;
        }
        
        int[] ans = new int[k] ;
        int j = 0 ;
            
        while( k-- > 0){
            ans[j++] = q.poll()[0] ;
        }
        
        return ans ;
    }



    // gfg solution : 

    class comp implements Comparator<int[]>{
        
        public int compare(int[] o1 , int[] o2){
            if(o2[1] > o1[1] ){
                return 1 ;
            }
            else if(o2[1] == o1[1]){
                if(o2[0] > o1[0]){
                    return 1 ;
                }
                else{
                   return -1 ;
                }
            }
            else{
                return -1 ;
            }
        }
    }

   
    
    public int[] topK(int[] nums, int k) {
        // Code here
        
            HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1) ;
        }
        
        PriorityQueue<int[]> q =new PriorityQueue<>( new comp() ) ;
        
        for(Map.Entry<Integer,Integer> e : map.entrySet() ) {
            q.add(new int[]{(int)e.getKey() , (int)e.getValue() }) ;
        }
        
        int[] ans = new int[k] ;
        int j = 0 ;
            
        while( k-- > 0){
            ans[j++] = q.poll()[0] ;
        }
        
        return ans ;
    }
    
}
