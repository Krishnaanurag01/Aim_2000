package Problem_Of_The_day;
import java.util.*;

public class Q206_Longest_Substring_Of_All_Vowels_in_Order {

    public int longestBeautifulSubstring(String word) {
        
        HashSet<Character> map = new HashSet<>();
        int j = 0 ; // this is start of string.
        int ans = 0;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            
            if(ch == 'a'){ // for a no other vowels should be present in order to maintain order.
                if(map.contains('e') || map.contains('i') || map.contains('o') || map.contains('u')){
                    map = new HashSet<>() ;
                    map.add(ch) ;
                    j = i ; // new start
                }
                else{
                    if(map.contains(ch) == false){
                        j = i ; // first a par start initialize karo
                    }
                    map.add(ch) ;
                }
            }
            else if(ch == 'e'){              // a must be present and other not.
                if(!map.contains('a') || map.contains('i') || map.contains('o') || map.contains('u')){
                    map = new HashSet<>() ;
                }
                else{
                    map.add(ch) ;
                }
            }
            else if(ch == 'i'){ // a and e must present and other not.
                if(!map.contains('a') || !map.contains('e') || map.contains('o') || map.contains('u')){
                    map = new HashSet<>() ;
                }
                else{
                    map.add(ch) ;
                }
            }
            else if(ch == 'o'){   // a, e, i must be there and others not.
                if(!map.contains('a') || !map.contains('e') || !map.contains('i') || map.contains('u')){
                    map = new HashSet<>() ;
                }
                else{
                    map.add(ch) ;
                }
            }
            else{ // every vowel must be present.
                if(!map.contains('a') || !map.contains('e') || !map.contains('i') || !map.contains('o')){
                    map = new HashSet<>() ;
                }
                else{
                    map.add(ch) ;
                }
            }

            if(map.size() == 5){
                ans = Math.max(ans, i - j + 1) ;
            }
            
        }
        
        return ans ;   
    }
}
