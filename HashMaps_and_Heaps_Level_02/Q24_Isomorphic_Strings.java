package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q24_Isomorphic_Strings {

    // takes O(n) space
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>() ;
        
        // checking s - t mapping.
        for(int i = 0 ; i < s.length() ; i++){
            char ch1 = s.charAt(i) ;
            char ch2 = t.charAt(i) ;

            if(map.containsKey(ch1) && map.get(ch1) != ch2){
                return false; 
            }
            else{
                map.put(ch1,ch2) ;
            }
        }
        
        map.clear() ;

        // checking t - s mapping.
        
         for(int i = 0 ; i < s.length() ; i++){
            char ch1 = s.charAt(i) ;
            char ch2 = t.charAt(i) ;

            if(map.containsKey(ch2) && map.get(ch2) != ch1){
                return false; 
            }
            else{
                map.put(ch2,ch1) ;
            }
        }
        
        return true ;
    }
    

    // takes O(2n) space. checking both string mapping in a single loop.

    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Character> smap = new HashMap<>() ;
        HashMap<Character,Character> tmap = new HashMap<>() ;

        
        for(int i = 0 ; i < s.length() ; i++){
            char ch1 = s.charAt(i) ;
            char ch2 = t.charAt(i) ;

            if(smap.containsKey(ch1) && smap.get(ch1) != ch2){
                return false; 
            }
            else{
                smap.put(ch1,ch2) ;
            }
            
            
            if(tmap.containsKey(ch2) && tmap.get(ch2) != ch1){
                return false; 
            }
            else{
                tmap.put(ch2,ch1) ;
            }
            
        }

        
        return true ;
    }
}
