package Dynamic_Programming_level_02;

import java.util.HashMap;

public class Q58_Arithmetic_Slices_2 {
    
    public static void main(String[] args) {
        
    }

    public static int get_total_arithmatic_subsec(int[] arr) {
        
        HashMap<Integer,Integer>[] map = new HashMap[arr.length] ; // making an hashmap array

        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>() ;    // now initializing each hashmap.
        }

        int ans = 0 ;

        for (int i = 1 ; i < map.length; i++) { // now starting from 1st index to last
            for (int j = 0; j < i ; j++) { // and 0 to i
                
                long cd = (long)arr[i] - (long)arr[j] ; /// finding common difference.. converting to long as if we find differnece if  - infinity - (plus infinity) then it will givem 2*infinity

                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue ; // so if that occurs then skip it
                }

                // otheriwse check in j and i map that is it contains any key with cd value
                int valueEndAtJ = map[j].getOrDefault((int)cd,0);
                int valueEndAtI = map[i].getOrDefault((int)cd,0);

                ans += valueEndAtJ ; // for j map we add it to the answer (for exam : it has 1 sequence like : 2-5 so if add current value then it becomes something like : 2-5-x) so total sequence remains same but length of sequence increase and we just have to give count.

                map[i].put((int)cd, valueEndAtI + valueEndAtJ + 1 ) ;// and putting cd key with j value + i value(if it already has this key)+1(current value).
            }
        }

        return ans ;

    }
}
