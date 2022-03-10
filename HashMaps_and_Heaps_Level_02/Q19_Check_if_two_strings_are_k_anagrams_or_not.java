package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q19_Check_if_two_strings_are_k_anagrams_or_not {

    boolean areKAnagrams(String s1, String s2, int k) {
       
        // when both length not equal then false.
        if(s1.length() != s2.length() )
        return false ;
        
        HashMap<Character,Integer> map = new HashMap<>() ;
        

        // adding all char of s1 in map.
        for(char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        

        // now for each char of s2 if it is present in map then substract else skip.
        for(char ch : s2.toCharArray() ){
            
            if(map.getOrDefault(ch,0) > 0){
                map.put(ch,map.get(ch) -1 ) ;
            }
        }
        
        int count = 0 ;
        
        // getting the count of char that are not subtracted in second loop.
        /// this means if this count is lesser than or equals to k then we can change the character and can made anagram else false.
        for(Character ch : map.keySet()){
            count += map.get(ch) ;
        }
        
        if( count <= k ){
            return true ;
        }
        else{
            
            return false;
        }
        
    }
    
}
