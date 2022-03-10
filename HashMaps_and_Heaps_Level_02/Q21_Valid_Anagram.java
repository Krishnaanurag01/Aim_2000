package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q21_Valid_Anagram {
    
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character,Integer> map= new HashMap<>() ;
        
        // addin all char of s
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        
        // substracting char of t.
        for(char ch : t.toCharArray() ){
            int freq = map.getOrDefault(ch,0) ;
            
            if(freq == 1){
                map.remove(ch) ;
            }
            else if(freq == 0){
                return false ; // means do not exist
            }
            else{
                map.put(ch,freq-1) ;
            }
        }
        
        // if after substraction size becomes 0 then it means you are done.
        return map.size() == 0 ;
        
    }


}
