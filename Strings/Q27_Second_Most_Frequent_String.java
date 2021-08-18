package Strings;

import java.util.HashMap;
import java.util.Map;



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

    int maxFreq = 0;
    int secondMostFreq = 0;
    for (Map.Entry<String,Integer> e : map.entrySet()) {
        maxFreq = Math.max(maxFreq, (int) e.getValue());
       if(secondMostFreq < (int) e.getValue() && (int) e.getValue() < maxFreq){
           secondMostFreq = (int) e.getValue();
       }
    }

    for (Map.Entry<String,Integer> e : map.entrySet()) {
        if( (int) e.getValue() == secondMostFreq){
            return (String) e.getKey();
        }
    }


    return null;
 }
}
