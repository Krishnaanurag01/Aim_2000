package Arrays_and_string;
import java.util.*;

public class Q9_Partition_Labels {

    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        for(int i = 0 ; i < s.length() ; i++){  // storing last index of each character.
            map.put(s.charAt(i),i) ;
        }
        
        List<Integer> ans = new ArrayList<>() ; /// ans list.
        
        int prev = -1 ; /// previous
        int max = 0 ; // max size of part
        
        int i = 0 ;
        
        while(i < s.length()){
            
            int nextMax = map.get(s.charAt(i)) ; 
            
            max = Math.max(max,nextMax) ; // updating the max size of part
            
             if(max == i){  // if the max is current pointer then add its length in the list.
                ans.add(max - prev) ;
                prev = nextMax ; // and update the previous.
            }
            
            i++ ;
        }
        
        
        
        return ans ;
        
    }
    
}
