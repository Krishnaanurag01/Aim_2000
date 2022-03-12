package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q37_Rabbits_in_Forest {

    public int numRabbits(int[] ans) {
        
        // this will store group size as key and value as "how many rabitts are saying that they belong to key size group colours"
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        for(int i = 0 ; i < ans.length ; i++){
            map.put( ans[i] , map.getOrDefault(ans[i],0) + 1 ) ;
        }
        
        int totalRabits = 0 ;
        
        for(Integer key : map.keySet()){
            int gs = key + 1 ; // getting group size and adding 1 in it becuase we have stored the group size excluding the rabit who is saying the excluding him there are x others members so group size(gs) is x+1
            int repotees = map.get(key) ; // total rabits who is saying that they belong to gs size group
            
            // calculating how many groups are needed of size gs for repotees .
            int tg = (int) Math.ceil( repotees * 1.0 / gs*1.0 ) ; // total group
            
            totalRabits += (tg*gs) ; // and calculating the total rabits and adding them to answer.
        }
        
        
        return totalRabits ;
    }
    
}
