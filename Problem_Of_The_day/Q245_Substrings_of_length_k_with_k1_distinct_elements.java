package Problem_Of_The_day;
import java.util.*;

public class Q245_Substrings_of_length_k_with_k1_distinct_elements {

    static int countOfSubstrings(String S, int K) {
        HashMap<Character,Integer> map = new HashMap<>() ;
        int count = 0 ;
        
        // first add k chars in map
        for(int i = 0 ; i < K ; i++){
            char ch = S.charAt(i) ;
            map.put(ch, map.getOrDefault(ch,0) + 1) ;
        }
        
        
        // now check whether exatcly k-1 chars present or not.
        if(map.size() == K - 1){
            count++ ;
        }
        
        // now using sliding window concept
        for(int i = K ; i < S.length() ; i++){
            char ch = S.charAt(i) ;  // adding current char
            map.put(ch, map.getOrDefault(ch,0)+ 1) ;
            
            char prev = S.charAt(i - K) ; // removing prev char
            int freq = map.get(prev) ;
            if(freq == 1){
                map.remove(prev) ;
            }
            else{
                map.put(prev, freq - 1 ) ;
            }
            
            
            // checking for exactly k-1 chars.
            if(map.size() == K - 1){
                count++ ;
            }
        }
        
        return count ;
    }
    
}