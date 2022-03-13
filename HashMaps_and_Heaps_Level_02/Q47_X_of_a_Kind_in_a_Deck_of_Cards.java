package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q47_X_of_a_Kind_in_a_Deck_of_Cards {

    // this question is all about finding the GCD(hcf)
    public boolean hasGroupsSizeX(int[] deck) {
        
        // store frequency of each card in map
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int i : deck )
            map.put(i, map.getOrDefault(i,0)+1) ;
        
        int ans = 0 ;
        
        // now find gcd. this gcd is the highest number/size of group that can be made so that each card can be divided equally
        for(int key : map.keySet()){
            ans = GCD(ans,map.get(key)) ;
        }
        
        return ans >= 2 ? true : false ;
    }
    
    int GCD(int a , int b){
        
        if( b== 0){
            return a ;
        }
        
        return GCD(b,a%b) ;
    }
    
}
