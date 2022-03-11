package HashMaps_and_Heaps_Level_02;
import java.util.*;

// same as ISOMORPHIC String.

public class Q25_Word_Pattern {
    
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split(" ") ;
        
        if(pattern.length() != arr.length)
            return false;
        
        HashMap<Character,String> map = new HashMap<>() ;
        HashMap<String,Character> wmap = new HashMap<>() ;

        
        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i) ;
            
            if(map.containsKey(ch) && map.get(ch).equals(arr[i]) == false ){
                // System.out.println(ch + " - " + arr[i]) ;
                return false; 
            }
            else{
                map.put(ch,arr[i]) ;
            }
            
            
            if(wmap.containsKey(arr[i]) && wmap.get(arr[i]) != ch ){
                // System.out.println(ch + " - " + arr[i]) ;
                return false; 
            }
            else{
                wmap.put(arr[i],ch) ;
            }
        }
        
        
        return true ;
        
    }
}
