package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q24_Permutations_of_a_given_string {

    static List<String> list ;
    public List<String> find_permutation(String S) {
        // Code here
        list = new ArrayList<>() ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        for(char ch : S.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        
        printPermutations(1,S.length(),map, "") ;
        
        Collections.sort(list) ;
        
        return list ;
    }
    
    public static void printPermutations(int ci , int ti, HashMap<Character,Integer> map, String asf) {
        
        if(ci > ti){
            list.add(asf) ;
            return ;
        }


        // chossing character for current box

        for(char ch : map.keySet()){
            if(map.get(ch) > 0 ){
                
            map.put(ch,map.get(ch)-1) ;
            printPermutations(ci+1, ti ,map, asf+ch) ;
            map.put(ch,map.get(ch)+1) ;
        }
        }
    }

    
}
