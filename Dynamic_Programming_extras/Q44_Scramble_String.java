package Dynamic_Programming_extras;
import java.util.*;

public class Q44_Scramble_String {

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return helper(s1,s2);
    }
    
    static boolean helper(String s1, String s2){
        
        
        if(s1.equals(s2)) return true ; // when equal return true.
        if(s1.length() <= 1) return false; // when it is of 1 length then it is leaf so we wont't compare here so return false.
        
        
        for(int i = 1 ; i < s1.length() ; i++){
            
            if(helper(s1.substring(0,i) , s2.substring(0,i))  && // comparing without swapping
               helper(s1.substring(i) , s2.substring(i))  ) return true ;
            
            if(helper(s1.substring(0,i) , s2.substring(s2.length()-i ))  && // comparing with swapping
               helper(s1.substring(i) , s2.substring( 0,s2.length()-i ))) return true ;
            
        }
        
        return false;
    }




    // memoized code using hashMap.

    public boolean isScramble2(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        HashMap<String,Boolean> map = new HashMap<>() ; // using map for memoization
        return helper(s1,s2,map);
    }
    
    static boolean helper(String s1, String s2, HashMap<String,Boolean> map){
        
        if(s1.equals(s2)) return true ;
        if(s1.length() <= 1) return false;
        
        String key = s1 +"#"+s2 ; // forming key
        if(map.containsKey(key)) return map.get(key) ; // returning if already solved
        
        for(int i = 1 ; i < s1.length() ; i++){

            if(helper(s1.substring(0,i) , s2.substring(0,i), map)  &&
               helper(s1.substring(i) , s2.substring(i),map)  ){
                map.put(key,true) ;  // storing and returning
                return true ;
            } 
            
            if(helper(s1.substring(0,i) , s2.substring(s2.length()-i ),map)  &&
               helper(s1.substring(i) , s2.substring( 0,s2.length()-i ),map)){
               map.put(key,true) ; // storing and returning
                return true ;  
            } 
        }
        
        map.put(key,false) ;
        return false;
    }
}
