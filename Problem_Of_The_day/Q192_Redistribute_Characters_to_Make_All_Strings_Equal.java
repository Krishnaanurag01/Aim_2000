package Problem_Of_The_day;
import java.util.*;

public class Q192_Redistribute_Characters_to_Make_All_Strings_Equal {

    public boolean makeEqual(String[] words) {
        if(words.length <= 1) return true; // base case.
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        // the question is about can we make every word have equal count of letters.
        
        // so count frequency of each letter from each word
        for(String s : words){
            for(char ch : s.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1) ;
            }
        }

        // now check can we divide that letters to all word with same frequency.
        for(Character key : map.keySet()){
            if(map.get(key) % words.length != 0) return false; // if not then return false;
        }
        return true ;
    }
}
