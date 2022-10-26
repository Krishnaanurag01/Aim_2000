package Problem_Of_The_day;
import java.util.*;

public class Q263_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    
    public int maxLength(List<String> arr) {
        return helper(0, arr, new StringBuilder()) ;
    }
    
    int helper(int idx, List<String> arr, StringBuilder sb){
        if(idx >= arr.size()){
            
            HashSet<Character> set = new HashSet<>() ;
            for(char ch : sb.toString().toCharArray()){
                if(set.contains(ch)) return 0 ;
                set.add(ch) ;
            }
            
            return set.size() ;
        }
        
        int np = helper(idx+1, arr, sb) ;
        int p= 0 ;
        if(sb.length() + arr.get(idx).length() <= 26){
            StringBuilder temp = new StringBuilder(sb) ;
            temp.append(arr.get(idx)) ;
            p = helper(idx+1, arr, temp);
        }
        
        return Math.max(p,np) ;
    }
}
