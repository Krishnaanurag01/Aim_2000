package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q26_Permutations_of_a_given_string {

     
    static List<String> list ;
    public List<String> find_permutation(String S) {
        // Code here
        list = new ArrayList<>() ;
        
        printPermutations(S,"") ;
        
        Collections.sort(list) ;
        
        return list ;
    }

    // same as Q25
    
    public static void printPermutations(String str, String asf) {
        
        if(str.length() == 0){
            list.add(asf) ;
            return ;
        }


        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i) ;
            String rest = str.substring(0,i) + str.substring(i+1) ;
            printPermutations(rest,asf+ch) ;
        }
    }
    
}
