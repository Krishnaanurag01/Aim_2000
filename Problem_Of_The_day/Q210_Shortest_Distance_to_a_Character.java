package Problem_Of_The_day;
import java.util.*;

public class Q210_Shortest_Distance_to_a_Character {

    public int[] shortestToChar(String s, char c) {
        
        TreeSet<Integer> set = new TreeSet<>() ;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            if(ch == c) set.add(i) ;
        }
        
        int[] ans = new int[s.length()] ;
        
        for(int i = 0 ; i < s.length() ; i++){
            Integer floor = set.floor(i) ;
            Integer ceil = set.ceiling(i) ;
            
            if(floor == null) ans[i] = ceil - i  ;
            else if(ceil == null) ans[i] = i - floor ;
            else{ // when both present.
                if(Math.abs(ceil - i) < Math.abs(i - floor)){
                    ans[i] = ceil - i ;
                }
                else ans[i] = i - floor ;
            }
        }
        
        return ans ;
    }
}
