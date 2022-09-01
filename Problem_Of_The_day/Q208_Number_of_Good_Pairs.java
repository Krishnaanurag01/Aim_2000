package Problem_Of_The_day;
import java.util.*;

public class Q208_Number_of_Good_Pairs {

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int count = 0;
        for(int val : nums){
            if(map.containsKey(val)){
                count += map.get(val) ;
            }
            map.put(val, map.getOrDefault(val,0)+1) ;
        }
        
        return count ;
    }
}
