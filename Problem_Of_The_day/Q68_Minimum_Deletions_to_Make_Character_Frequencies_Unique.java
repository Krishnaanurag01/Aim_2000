package Problem_Of_The_day;
import java.util.*;

public class Q68_Minimum_Deletions_to_Make_Character_Frequencies_Unique {

    public int minDeletions(String s) {
        /// storing freq for each char
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        
        HashSet<Integer> set = new HashSet<>() ; // helps in identifying the duplicate frequency
        int count = 0 ;
        for(char ch : map.keySet()){
            int freq = map.get(ch) ;   
            while(set.contains(freq)){ 
                freq-- ;
                count++ ;
            }
            if(freq > 0) set.add(freq) ;
        }
        return count ;
    }
}
