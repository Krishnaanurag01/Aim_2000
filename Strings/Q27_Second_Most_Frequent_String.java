package Strings;

import java.util.HashMap;

import java.util.PriorityQueue;



public class Q27_Second_Most_Frequent_String {
    public static void main(String[] args) {
        String[] s = { "aaa" , "bbb" , "ccc" , "bbb" , "aaa" , "aaa"};
     System.out.println( getSecondMostFrequentString(s));
    }
       
 public static String getSecondMostFrequentString(String[] arr) {
    
    HashMap<String,Integer> map = new HashMap<>();

    for (String string : arr) {
        if(map.containsKey(string)){
            map.put(string, map.get(string)+1 );
        }
        else{
            map.put(string,1);
        }
    }

    // making a maxheap by using comparator in priority queue it will have value at head which have max freq in map and so on.
    PriorityQueue<String> queue = new PriorityQueue<>( (a,b) -> map.get(b) - map.get(a));
    queue.addAll(map.keySet());
    queue.remove();




    return queue.remove();
 }
}
