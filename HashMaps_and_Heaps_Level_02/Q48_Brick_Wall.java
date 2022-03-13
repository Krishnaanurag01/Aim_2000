package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q48_Brick_Wall {

    public int leastBricks(List<List<Integer>> wall) {
        
        // this will store total number of split at particular column in each row and the col which has maximum split will have minimum number of block which is to be splited so that column is our answer column and count of split will be total row - max no of splits in columns (gives the minimum no of split we need to do )
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int max = 0 ;
        
        for(List<Integer> list : wall){
            
            // we can find the split with prefix sum.
            int ps = 0 ; //prefix sum 
            
            for(int i = 0 ; i < list.size() - 1 ; i++){ // not visiting the last most brick becuase it's end is common for all so that will not be considered.
                
                int val = list.get(i) ;
                ps += val ;
                
                map.put(ps, map.getOrDefault( ps , 0 ) +1 ) ;
                // keeping eye on max splits.
                max = Math.max(max,map.get(ps)) ;

            }
        }

        // total row - max no of already done split in any column.
        return wall.size() - max ;   
    }
}
