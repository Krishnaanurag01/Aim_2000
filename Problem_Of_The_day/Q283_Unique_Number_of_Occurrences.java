package Problem_Of_The_day;
import java.util.*;

public class Q283_Unique_Number_of_Occurrences {
 
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int val : arr){
            map.put(val, map.getOrDefault(val,0)+1) ;
        }
        
        HashSet<Integer> set = new HashSet<>() ;
        for(int key : map.keySet()){
            if(set.contains(map.get(key))) return false;
            set.add(map.get(key)) ;
        }
        
        return true ;
    }
}
