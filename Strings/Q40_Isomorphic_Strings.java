package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


// Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
// Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.
// Note: All occurrences of every character in ‘str1’ should map to the same character in ‘str2’

public class Q40_Isomorphic_Strings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
        System.out.println(isIsomorphic2("badc","baba"));
    }
    public static boolean isIsomorphic(String s1 , String s2) {
        
        if(s1.length() != s2.length()) return false;

        HashMap<Character,Character> map = new HashMap<>();

        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i);

            if(map.containsKey(ch) ){
                char value = map.get(ch);
                if(value != s2.charAt(i)) return false;
            }
            else{
                map.put(ch,s2.charAt(i));
            }
        }
        HashSet<Character> set = new HashSet<>();
        for (Map.Entry<Character,Character> e : map.entrySet()) {
            if(set.contains((char)e.getValue())){
                return false;
            }
            set.add((char)e.getValue());
        }

        return true;
    }

    // same logic as above but just using one loop.
    public static boolean isIsomorphic2(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();


        for(int i = 0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);


            if(map1.containsKey(ch1) == true ){
                char value = map1.get(ch1);
                if(value != ch2) return false;
            }
            else{
                if(map2.containsKey(ch2) == true){ // if it is true then it means that character of string 2 is already mapped with someone else.
                    return false;
                }else{
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }

        return true;
    }
}
