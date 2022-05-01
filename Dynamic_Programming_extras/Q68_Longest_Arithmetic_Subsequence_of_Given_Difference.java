package Dynamic_Programming_extras;
import java.util.*;

public class Q68_Longest_Arithmetic_Subsequence_of_Given_Difference {

    // method 01 : recursive approach

    public int longestSubsequence(int[] arr, int difference) {

        return helper(0,arr,difference,null);
    }
    
    int helper(int idx, int[] arr, int diff, Integer prev){
        
        if(idx == arr.length) return 0;
        
        int took = 0 ;
        int notTook =  helper(idx+1,arr,diff,prev) ;

        
        if(prev == null){ 
            took = 1 + helper(idx+1,arr,diff,arr[idx]) ;        
        }
        else{
            if(arr[idx] - prev == diff)
                took = 1 + helper(idx+1,arr,diff,arr[idx]) ;
        }
        
        return Math.max(took, notTook) ;
    }


    // method 02 : using hashmap.

    public int longestSubsequence2(int[] arr, int difference) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int longestSub = 0 ;

        for(int i = 0 ; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i] - difference,0) + 1) ; // storing longest subseq till current num (including current num)
            longestSub = Math.max(longestSub,map.get(arr[i])); // updating the longest subseq
        }
        
        return longestSub ;
    }
}
