package LeetCode_Contests.BiWeekly_90;
import java.util.*;

public class Q1_Odd_String_Difference {

    public String oddString(String[] words) {
        
        HashMap<String,Integer> map = new HashMap<>() ;
        HashMap<String, String> tmap = new HashMap<>() ;
        
        for(String word : words){
            String ptrn = "" ;
            for(int i =  1; i < word.length() ; i++){
                int ch = word.charAt(i) - word.charAt(i-1) ;
                ptrn += ch + " - " ;
            }
            tmap.put(ptrn,word) ;
            map.put(ptrn, map.getOrDefault(ptrn,0)+1) ;
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1) return tmap.get(key) ; 
        }
        
        return "" ;
    }
}
