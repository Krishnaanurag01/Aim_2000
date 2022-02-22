package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q13_Pallindrome_Patterns {
    
    //used Q12 approach

    static List<String> ans ;
    
    public List<String> all_palindromes(String s)
    {
        // Code here
        
        ans = new ArrayList<>() ;
        
         HashMap<Character, Integer> fmap = new HashMap<>() ;

        
        // storing frequency of each char in string s
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            fmap.put(ch, fmap.getOrDefault(ch, 0)+1) ;
        }


        Character oddch = null ;
        int oddCount = 0 ;
        int totalLen = 0 ;

        // dividing the freq in half 

        for (Map.Entry<Character,Integer> e : fmap.entrySet()) {
            char ch = e.getKey() ;
            int freq = e.getValue() ;

            if(freq % 2 == 1){
                oddch = ch ;
                oddCount++ ;
            }

            fmap.put(ch,freq/2) ;
            totalLen += (freq/2) ;
        }
        
        
        if(oddCount > 1){
            return ans ;
        }
        
        generatepw(1,totalLen,oddch, fmap,"") ;
        
        Collections.sort(ans) ;
       
        return ans ;
    }
    
    
    private static void generatepw(int i, int totalLen, Character oddCh, HashMap<Character, Integer> fmap, String s) {

        if(i > totalLen){ // as we consider 1 based indexing for i so when i is greater than its length then this base condition will get applied
            
            String palin = s ;
            String rev = new StringBuilder(s).reverse().toString() ;

            if(oddCh != null){
                palin += oddCh ;
            }

            palin += rev ;

           ans.add(palin) ;
            return ;
        }

        for(Map.Entry<Character,Integer> e : fmap.entrySet()  ){
            char ch = e.getKey() ;
            int fre = e.getValue() ;

            if(fre > 0) {

                fmap.put(ch, fre-1) ;
                generatepw(i+1, totalLen, oddCh,fmap, s + ch);
                fmap.put(ch, fre) ;
            } 
        }
    }
}
