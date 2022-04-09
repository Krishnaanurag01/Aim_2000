package Dynamic_Programming_extras;
import java.util.*;

public class Q38_Longest_String_Chain {


    // Approch 01 :


    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length()) ; // sorting based on length becuase we have to find subset not subsequence
        
        int[] dp = new int[words.length] ;
        int ans = 0 ;
        HashMap<String,Integer> map = new HashMap<>() ; // here we will store each string with it's corres index.
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i] ;
            map.put(s,i) ;
        }
        
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i] ; // getting ith word
            
            int max = 0 ;
            for(int k = 0 ; k < word.length() ; k++){  
                String pre = word.substring(0,k) + word.substring(k+1) ; // forming string by removing kth char and checking if it was present or not
                if(map.containsKey(pre)){
                    int idx = map.get(pre) ;
                    max = Math.max(max, dp[idx]) ; // if present then find it's logest answer 
                }
            }
            dp[i] = max + 1 ; // and 1 (for current word)
            ans = ans < dp[i] ? dp[i] : ans ; // updating answer.
        }       
        
        return ans ;
    }
    
}
