package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q63_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    
    /// brute force but acceptable.
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int count = 0 ;
        for(int val : time){
            int rest = (val % 60) ;
            
            for(int i = 1; i <= 16 ; i++){ // as time[i] can be up to 500 only so finding the second value of pair manually.
                int rem = 60*i - rest ;
                count += map.getOrDefault(rem,0);
            }
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        return count ;
    }

    // method 2 : without using inner loop.
    // here instead of storing the value we store the remainder.
    public int numPairsDivisibleBy602(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int count = 0 ;
        for(int val : time){
            int rest = 60 - (val % 60) ;
            
            count += map.getOrDefault(rest % 60 ,0);// finding if any value with given remainder present or not.
            // storing current value with key as remainder.
            map.put(val % 60 ,map.getOrDefault(val % 60 ,0)+1);
        }
        
        return count ;
    }
}
