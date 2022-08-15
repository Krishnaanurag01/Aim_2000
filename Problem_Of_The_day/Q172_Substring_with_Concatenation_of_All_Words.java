package Problem_Of_The_day;
import java.util.*;

public class Q172_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
     
        List<Integer> ans = new ArrayList<>() ;
        int size = words[0].length() * words.length ; // etna size hoga string agar sare element words ke substring me ho to.
        if(s.length() < size) return ans ;// agar s ka size < sum(sare element ka length)
        
        HashMap<String,Integer> map = new HashMap<>() ; // storing each word and their freq
        HashSet<Character> set = new HashSet<>() ; // here we will store, kis kis starting char se  word h apni words arry me.
        for(String word : words){
            set.add(word.charAt(0));
            map.put(word, map.getOrDefault(word,0)+1) ;
        }

        for(int i = 0 ; i + size <= s.length() ; i++){
            char ch = s.charAt(i) ;
            if(set.contains(ch) == false) continue ; //agar current char is koi word he nhi h words me to yha se join valid substring start nhi hogi
            
            if(isValidSubString(s,i,i+size, map, words[0].length() )){ // otherwise check this potential string
                ans.add(i) ;
            } 
        }
        
        return ans ;
    }
    
    boolean isValidSubString(String s, int si, int ei, HashMap<String,Integer> map, int sSize){
       
        HashMap<String, Integer> tMap = new HashMap<>() ;// making new hashmap for this s so that our original hashmao will not face any inconsistency
        
        for(int i = si ; i + sSize <= ei ; i += sSize){
            String word = s.substring(i, i + sSize) ; // extracting current word of sSize from string
            // System.out.println(word) ;
            if(map.containsKey(word) == false) return false; // agar original map me ye string he nhi to return false
            int freq = map.get(word) ;
            int tfreq = tMap.getOrDefault(word,0) ;
            tfreq++ ;
            
            if(tfreq > freq) return false; // ya phir agar eski freq jyda h toh return false;
            tMap.put(word, tfreq);
        }
        
        return tMap.equals(map) ;
    }
}
