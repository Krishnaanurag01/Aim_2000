package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q44_Powerful_Integers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        // total time comp : O(log(x) * log(y)) ;
        
        HashSet<Integer> set = new HashSet<>() ; // for removing the duplicacy.
        
        for(int i = 1 ; i < bound ; i *= x){ // this will run log(x) time becuase we are multiplying here till it is  less than bound(becuase we have to consider the sum of both x and y)
            for(int j = 1 ; i + j <= bound ; j *= y){ // this will also run log(y) time.
                set.add(i+j) ;
            }
        }
        
        return new ArrayList<>(set) ;
    }
    
}
