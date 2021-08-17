package Strings;

import java.util.HashMap;
import java.util.Map;
/**
 * Q3_DuplicateCharacterInString
 */
public class Q3_DuplicateCharacterInString {

    public static void main(String[] args) {

        // findDuplicateChar("LuffyTheBeast");
        findDuplicateCharUsingHash("LuffyTheBeast");

        
    }

    // time comp : o(n).
    // space comp : o(256).

    public static void findDuplicateChar(String str) {
        
        int[] charArray = new int[256];

        for (int i = 0; i < str.length(); i++) {
            charArray[str.charAt(i)]++;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 1) {
                System.out.println((char)(i)+" : " + charArray[i]);
            }
        }
    }

    // using hashmap : o(N logn)

    public static void findDuplicateCharUsingHash(String str) {
        
        HashMap<Character,Integer> map = new HashMap<>();


        // first storing each characters in hashmap .
        for (int i = 0; i <str.length(); i++) {
            if(map.get(str.charAt(i))== null){
                map.put(str.charAt(i), 1);
            }
            else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }

        // now checking the entry with value more than 1 and then printing it.
        for (Map.Entry<Character,Integer> e : map.entrySet()) {
            char key = (char) e.getKey();
            int value = (int) e.getValue();

            if(value > 1){
                System.out.println(key + " : " +value);
            }
        }
    }
}