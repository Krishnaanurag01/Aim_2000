package Problem_Of_The_day;
import java.util.*;

public class Q270_Find_All_Lonely_Numbers_in_the_Array {

    public List<Integer> findLonely(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1) ;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int key : map.keySet()){
            if(map.get(key) == 1 && !map.containsKey(key - 1) && !map.containsKey(key + 1)) ans.add(key) ;
        }
        
        return ans ;
    }
}
