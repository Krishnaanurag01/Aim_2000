package HashMaps_and_Heaps_Level_01;
import java.util.*;

public class Q2_Longest_Consecutive_Sequence {


    // method 02 : Will give you TLE. There's a better approch You have done it please check that out

    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer,Boolean> map= new HashMap<>() ;

        // assigning true when element does not have any element -1 neighbour in map so it denotes subsequence starting point
        
        for(int i :  nums ){
            
            if(map.containsKey(i-1)){
                map.put(i,false) ;
            }
            else{
                map.put(i,true) ;
            }
            
        }
        
        
        int ll = 0 ; // longest length
        
        for(int i : nums){
            
            if(map.get(i) == false) 
                continue ;
            
                // now calcualting the count of all subseq from starting point
            int initialCount = 1 ;
            int next = i+1 ;
            
            while(map.containsKey(next)){
                next++ ;
                initialCount++ ;
            }
            
            ll = Math.max(ll,initialCount) ;
            
        }
        
        return ll ;
        
    }
    
}
