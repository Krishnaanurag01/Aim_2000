package Strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Q32_Rearrange_Characters {
    public static void main(String[] args) {
        System.out.println(RearrangeIt("kkk"));
        
    }
    public static String RearrangeIt(String s) {
        // first find the frequency of each character of string.
        HashMap<Character,Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            // this method will return 0 if element is not in map o/w it will return freq of c. 
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // now i'll make max priority queue.
// (a,b) -> map.get(b) - map.get(a) is a comparator it will make max priority queue.  based on the frequency of characters in map.
        PriorityQueue<Character> queue = new PriorityQueue<>( (a,b) -> map.get(b) - map.get(a));
        // now adding distint characters of string or else we can say adding all the keys of map.

        queue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        // if queue has more than one characters in it then this loop will execute.
        while ( queue.size() > 1 ) {
            // removes the head of this queue. which has the longest frequency. 
            char currentMax = queue.remove();
            char nextMax = queue.remove(); // removes the second element with higher freq.

            sb.append(currentMax);
            sb.append(nextMax);

            // now decreamenting freq in map as character is already used.

            map.put(currentMax, map.get(currentMax)-1);
            map.put(nextMax, map.get(nextMax)-1);

            // if current and next max element has still freq left then adding back to the queue.

            if(map.get(currentMax) > 0)
            queue.add(currentMax);

            if(map.get(nextMax) > 0)
            queue.add(nextMax);

        }

        // if element left in queue.
        if(! queue.isEmpty()){
            char lastElement = queue.remove();
            // if the last element has frequency greater than one. eg : aa then return empty string.
            if(map.get(lastElement) > 1){
                return null;
            } 
            // if length is 1 then add it to the result.
            sb.append(lastElement);
        }

        return sb.toString();


    }
}
