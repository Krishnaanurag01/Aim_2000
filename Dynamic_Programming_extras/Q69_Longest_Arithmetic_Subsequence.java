package Dynamic_Programming_extras;
import java.util.*;

public class Q69_Longest_Arithmetic_Subsequence {

    public int longestArithSeqLength(int[] nums) {
        
        HashMap<Integer,Integer>[] dp = new HashMap[nums.length] ; // we will store hashmap for each element that will contains the gap and longest subseq.
        int maxLength = 0 ; // will hold answer
        
        for(int i = 0 ; i < nums.length ; i++){
            HashMap<Integer,Integer> currentMap = new HashMap<>() ;  // initializing hashMap in current ith index of dp
            dp[i] = currentMap ;  
            
            for(int j = 0 ; j < i ; j++){ // now checking from 0th index till current index and finding the subseq with same difference.
                
                int diff = nums[j] - nums[i] ; // current difference
                if(dp[j].containsKey(diff)){ // if the jth index map also has current diff then we can include current ith element with previous jth subseq
                    currentMap.put(diff, dp[j].get(diff) + 1) ;
                }
                else{ // if not has current diff in jth element then store 2 (becuase we are making new subseq of jth element and ith element)
                    currentMap.put(diff, 2) ;
                }
                maxLength = Math.max(maxLength, currentMap.get(diff)) ; // and updating answer.
            }
        }
        
        return maxLength ;
    }
}
