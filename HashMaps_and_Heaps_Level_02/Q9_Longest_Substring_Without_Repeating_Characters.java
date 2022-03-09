package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q9_Longest_Substring_Without_Repeating_Characters {


    // using Acquire and Release startegy.
    // same as Q8

    public int lengthOfLongestSubstring(String s) {
        
        if(s.equals(" ")){
            return 1 ;
        }
        
        int i = 0 ;
        int j = 0 ;
        
        int ans = 0 ;
        
        char dupl = '0' ;
        
        HashSet<Character> set = new HashSet<>() ;

        while(true){
            boolean f1 = false ;
            boolean f2 = false ;
        
            // acquiring
            while(i < s.length() && dupl == '0' ){
                char ch = s.charAt(i) ;
                
                if(set.contains(ch)){
                    dupl = ch ;
                }

                set.add(ch) ;
                i++ ;
                
                f1 = true ;
            }

            // releasing
            
            while( j < s.length() && dupl != '0' ){
                ans = Math.max(ans,set.size()) ;
                char ch = s.charAt(j) ;
                
                if(ch == dupl){
                    dupl = '0' ;
                }else{
                
                set.remove(ch) ;
                
                }
                
                j++ ;
                
                f2 = true ;
            }
            
            if(f1 == false && f2 == false){
                break ;
            }
               
        }
        
        ans = Math.max(ans, set.size()) ;
        
     return ans ;   
        
    }
    
}
