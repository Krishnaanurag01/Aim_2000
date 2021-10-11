package Dynamic_Programming_level_02;

import java.util.HashMap;
import java.util.HashSet;

public class Q65_Frog_jump {

    public static void main(String[] args) {
        
    }

    public static boolean can_frog_jump(int[] stones) {
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>() ;

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>()) ;
        }

        map.get(stones[0]).add(1) ;

        for (int i = 0; i < stones.length; i++) {

            int currentStone = stones[i] ;
            HashSet<Integer> jumps = map.get(currentStone) ;

            for (Integer jummp : jumps) {
                int position = currentStone + jummp ;

                if(position == stones[stones.length-1]){
                    return true ;
                }

                if(map.containsKey(position) ){
                    if(jummp - 1 > 0){
                        map.get(position).add(jummp-1);
                    }

                    map.get(position).add(jummp);
                    map.get(position).add(jummp+1);

                }
            }

            
        }

        return false ;

    }
    
}
