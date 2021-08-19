package Strings;

import java.util.ArrayList;
import java.util.HashMap;


public class Q34_Print_Anagram_Together {
    public static void main(String[] args) {
        String[] s = { "act" , "god" , "cat" , "dog" , "tac" };
        System.out.println(getAnagrams(s));
    }

    public static ArrayList<ArrayList<String>> getAnagrams(String[] arr) {
        
        ArrayList<ArrayList<String>> ParentList = new ArrayList<>();
        HashMap < HashMap<Character,Integer> , ArrayList<String> > Parentmap = new HashMap<>();

        for (String s : arr) {
            HashMap<Character , Integer> innerMap = new HashMap<>();

            
            for (int m = 0; m < s.length(); m++) {

                char ch= s.charAt(m);                
                    innerMap.put(ch, innerMap.getOrDefault(ch, 0) + 1);
                
            }

            if (Parentmap.containsKey(innerMap) == false) {
                ArrayList<String> innerList = new ArrayList<>();
                innerList.add(s);
                Parentmap.put(innerMap, innerList);
            }else{
                ArrayList<String> existedList = Parentmap.get(innerMap);
                existedList.add(s);

            }
        }

        for (ArrayList<String> values : Parentmap.values()) {
            ParentList.add(values);
        }
    
        return ParentList;
    }
}
