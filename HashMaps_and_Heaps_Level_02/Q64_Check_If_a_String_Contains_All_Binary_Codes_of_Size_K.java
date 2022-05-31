package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q64_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    
    public boolean hasAllCodes(String s, int k) {
        
        if(s.length() < k ) return false; 
        // instead for checking every substring, simply make a set and store all the substring of size k if set contains the enough substring then it if true else false;
        HashSet<String> set = new HashSet<>() ; 
        
        for(int i = 0 ; i <= s.length() - k ; i++ ){
            set.add( s.substring(i,i + k) ) ;
        }
        
        return set.size() == (int)Math.pow(2,k) ;
    }

}
