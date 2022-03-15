package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q53_Random_Pick_with_Blacklist {

    class Solution {
    
        HashMap<Integer,Integer> map ;
        Random r ;
        int top ;
    
        public Solution(int n, int[] blacklist) {
            map = new HashMap<>() ;
            r = new Random() ;
            top = n - blacklist.length ; // now with this wop we can map the blacklist numbers with the correct numbers that come after top, if all the numbers after top is blaklisted then it does not need to map with any numbers.
            
            HashSet<Integer> set = new HashSet<>() ; // this set will contains all the blacklisted number so that we can access it in o(1) time.
            
            for(int i : blacklist)
                set.add(i) ;
            
            int temp = n -1 ;
            
            for(int i = 0 ; i < blacklist.length ; i++){
                
                int bln = blacklist[i] ;
                
                if(bln < top){ // when any black list num(bln) come before the top then map that number with the correct number that come after top .
                    
                    while(set.contains(temp) == true){ // and set contains bln numbers so if currect temp is lacklisted then decrease and search non black listed number
                        temp-- ;                    
                    }
                    
                    map.put(bln,temp) ; // mapping black listed number with temp(this comes after top and non bln)
                    temp-- ; // as we used current non bln so decrease it.
                }
            }
        }
        
        public int pick() {
            
            int num = r.nextInt(top) ;
            
            if(map.containsKey(num)){ // if random number is blacklisted number then return it's mapped non bln.
                return map.get(num) ;
            }
            
            return num; // else return non bln
        }
    }
    
}
