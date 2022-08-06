package Problem_Of_The_day;
import java.util.*;

public class Q148_Permutation_in_String {
    
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length()) return false;
        
        HashMap<Character,Integer> map = new HashMap<>() ;
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        
        HashMap<Character,Integer> map2 = new HashMap<>() ;
        
        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s2.charAt(i) ;
            map2.put(ch,map2.getOrDefault(ch,0)+1) ;
        }
        
        if(map.equals(map2)) return true ;
        
        for(int i = s1.length(), j = 0 ; i < s2.length() ; i++, j++){
            char ch = s2.charAt(i) ;
            char dch = s2.charAt(j) ;
            
            map2.put(ch,map2.getOrDefault(ch,0)+1) ;
            
            int freq = map2.get(dch) ;
            if(freq == 1){
                map2.remove(dch) ;
            }
            else{
                map2.put(dch,freq -1) ;
            }
            
            if(map.equals(map2)) return true;
        }
                
        return false;
    }
}
