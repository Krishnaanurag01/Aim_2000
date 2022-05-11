package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q62_Custom_Sort_String {

    public String customSortString(String order, String s) {
        
        StringBuilder sb = new StringBuilder() ;
        
        HashMap<Character,Integer> map = new HashMap<>() ;
        for(char ch : s.toCharArray()) // step 1 : storing every char of s in map
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        
        for(int i =  0 ; i < order.length() ; i++){ // now traversing each char of order and if same char is present for s then add to sb
            char ch = order.charAt(i);
            
            if(map.containsKey(ch)){
                int freq = map.get(ch) ;
                while(freq-- > 0 )
                    sb.append(ch);
                map.remove(ch);
            }
        }
        
        for(char key : map.keySet()){ // adding rest of the char of s which are not present in order string so adding them in the end.
            int freq = map.get(key);
            while(freq-- > 0){
                sb.append(key);
            }
        }
        
        return sb.toString() ;
    }
}