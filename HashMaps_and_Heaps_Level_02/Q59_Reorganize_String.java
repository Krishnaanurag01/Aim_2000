package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q59_Reorganize_String {

    // already explained in string package

    public String reorganizeString(String s) {
        
        HashMap<Character,Integer> count = new HashMap<>() ;
        
        for(char ch : s.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1) ;
        }
        
        PriorityQueue<Character> q = new PriorityQueue<>( (a,b) -> count.get(b) - count.get(a) ) ;
        
        q.addAll(count.keySet()) ;
        
        StringBuilder sb = new StringBuilder() ;
        
        while(q.size() > 1){
            char greatest = q.poll() ;
            char nextGreater = q.poll() ;
            
            sb.append(greatest) ;
            sb.append(nextGreater);
            
            count.put(greatest, count.get(greatest) - 1) ;
            count.put(nextGreater, count.get(nextGreater) - 1) ;
            
            if(count.get(greatest) > 0){
                q.add(greatest) ;
            }
           
            
            if(count.get(nextGreater) > 0){
                q.add(nextGreater) ;
            }
           
        }
        
        if(q.size() != 0 ){
            char lastChar = q.poll() ;
            
            if(count.get(lastChar) > 1){
                return "" ;
            }
            
            return sb.toString() + lastChar ;
        }
        
        return sb.toString() ;
    }
    
}
