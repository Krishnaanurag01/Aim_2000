package HashMaps_and_Heaps_Level_02;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Q53_Avoid_Flood_in_The_City
 */
public class Q54_Avoid_Flood_in_The_City {

    public int[] avoidFlood(int[] rains) {
     
          
        int n = rains.length ;
        int[] ans = new int[n] ;
        HashMap<Integer,Integer> rainyDays = new HashMap<>() ;
        TreeSet<Integer> dryThisDay = new TreeSet<>() ;


        for (int i = 0; i < rains.length; i++) {
            
            int x = rains[i] ;

            if(x == 0){ // dry day
                // add this day to set so that we can use in future
                dryThisDay.add(i) ;
                ans[i] = 1 ;
            }
            else{

                if(rainyDays.containsKey(x)){ // if map has this then it means this day is already full so we have to dry this.
                    Integer dryer = dryThisDay.higher(rainyDays.get(x)) ; // getting the last day and checking if any higher days have 0.

                    if (dryer != null) {
                        ans[dryer] = x ; ///drying the x lake on dryer day
                        dryThisDay.remove(dryer) ; // and also removing from set.
                    }
                    else{
                        return new int[]{} ;
                    }
                    
                }
                
                // else not containing.
                // add x lake on mao denotes that it is full now
                rainyDays.put(x, i) ;
                
                ans[i] = -1 ;
            }
        }

        return ans;

    }
}