package Dynamic_Programming_level_02;

import java.util.HashMap;
import java.util.HashSet;

public class Q65_Frog_jump {

    public static void main(String[] args) {
        
    }

    public static boolean can_frog_jump(int[] stones) {
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>() ;

        // initalizing hashset for each stone which will store how long frog can jump from current i'th stone.

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>()) ;
        }

        map.get(stones[0]).add(1) ; // adding 1 for first stone which denotes that frog can jump 1 step from first stone

        /// now accessing each stone
        for (int i = 0; i < stones.length; i++) {

        
            int currentStone = stones[i] ;
           // getting all the jumps frog can do from current stone
            HashSet<Integer> jumps = map.get(currentStone) ;

            for (Integer jummp : jumps) {
                // finding the next position after current jummp from current position
                int position = currentStone + jummp ;

                // if it is last stone then return true
                if(position == stones[stones.length-1]){
                    return true ;
                }

                // checking if the next position has stone or not. if yes it has then do oprations
                if(map.containsKey(position) ){

                    // if it is not zero then add jumps.
                    if(jummp - 1 > 0){
                        map.get(position).add(jummp-1);
                    }

                    // adding current jump
                    map.get(position).add(jummp);
                    // adding current jump + 1
                    map.get(position).add(jummp+1);

                }
            }

            
        }

        return false ;

    }
    
}
