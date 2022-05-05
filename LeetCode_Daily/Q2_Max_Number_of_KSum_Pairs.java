package LeetCode_Daily;
import java.util.*;

public class Q2_Max_Number_of_KSum_Pairs {

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int totalOpr = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            int curr = nums[i] ;
            int rest = k - curr ;
            if(map.containsKey(rest)){
                totalOpr++;
                int freq = map.get(rest) ;
                if(freq == 1) map.remove(rest) ;
                else map.put(rest,freq-1) ;
            }
            else
            map.put(curr, map.getOrDefault(curr,0)+1) ;
        }
        
        return totalOpr ;
    }
}
