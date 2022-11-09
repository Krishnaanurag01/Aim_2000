package Problem_Of_The_day;
import java.util.*;

public class Q289_Distribute_Candies {

    public int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>() ;
        
        for(int val : candyType){
            types.add(val) ;
        }
        
        int maxEat = candyType.length / 2 ;
        
        return Math.min(types.size(), maxEat) ;
    }
}
