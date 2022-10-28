package Problem_Of_The_day;
import java.util.*;

public class Q271_Maximum_Number_of_Occurrences_of_a_Substring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        HashMap<String, Integer> map = new HashMap<>() ;
        int[] farr = new int[26] ;
        int unique = 0 ;
        
        // first count the unique chars of min size.
        for(int i = 0 ; i < minSize ; i++){
            if(farr[s.charAt(i) - 'a']++ == 0){
                unique++ ;
            }
        }
       
        
        // if unique size is less or equal to maxLetters then update the answer.
        int max = 0 ;
        if(unique <= maxLetters){
            String t1 = s.substring(0, minSize) ;
            map.put(t1, 1) ; // and also put string in map
            int freq = 1 ;
            
            if(freq > max){
                max = freq ;
            }
        }
        
    
        // now check for the rest of the part.
        for(int i = minSize ; i < s.length() ; i++){
            // remove left char 
            if( farr[ s.charAt(i - minSize)- 'a']-- == 1){ // agar freq count 1 thi toh wo left char k hatne k baad unique count bhi kam hogi
                unique-- ;
            }
            
            // and add new char
            if( farr[ s.charAt(i)- 'a']++ == 0){ // agar new char ki freq 0 thi phle se toh unique count badh jayegi
                unique++ ;
            }
            
            if(unique <= maxLetters){
                // store in map
                String temp = s.substring(i - minSize + 1, i + 1) ;
                map.put(temp, map.getOrDefault(temp,0) + 1) ;
                int freq = map.get(temp) ;
            
                // and update the answer with max occurances.
                if(freq > max){
                    max = freq ;
                }
            }
            
        }
        
        return max ;
    }
}
