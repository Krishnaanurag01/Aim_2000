package Stack_and_Queue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q67_Game_with_String {

    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> map = new HashMap<>() ;

        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i) ;
            map.put(ch, map.getOrDefault(ch, 0)+1) ;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>( Collections.reverseOrder() ) ; 

        for (Map.Entry<Character,Integer> e : map.entrySet() ) {
            q.add(e.getValue()) ;
        }

        for (int i = 0; i < k ; i++) {
            int val = q.remove() - 1 ;
            if(val > 0) q.add(val) ;
        }

        int ans = 0 ;

        while (q.size() > 0) {
            ans += Math.pow(q.remove() , 2 ) ;
        }


        return ans ;
    }
    
}
