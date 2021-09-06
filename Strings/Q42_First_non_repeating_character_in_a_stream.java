package Strings;

import java.util.HashSet;

public class Q42_First_non_repeating_character_in_a_stream {

    public static void main(String[] args) {

        getString("aabb");
        
    }

    public static void getString(String A) {
        HashSet<Character> set = new HashSet<>();

        String s= "";

        char fnc = ' ' ;

        for (int i = 0; i < A.length(); i++) {
            if(set.contains(A.charAt(i))){
                s += "#";
            }
            else{
                fnc = A.charAt(i);
                s += A.charAt(i);

                set.add(A.charAt(i));
            }
        }

        System.out.println(s);
    }
    
}
