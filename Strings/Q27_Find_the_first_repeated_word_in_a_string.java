package Strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Q27_Find_the_first_repeated_word_in_a_string
 */
public class Q27_Find_the_first_repeated_word_in_a_string {

    public static void main(String[] args) {
        System.out.println(getFirstRepeatedWord("he had had he"));
        System.out.println(getFirstWordWhichIsRepeating("he had had he"));
    }

    // using hashset : o(n) time complex. 
    // use this when finding "First repeating word". 
    //for  example : "he had had he" output : had
    public static String getFirstRepeatedWord(String txt) {
        String[] strArr = txt.split(" ");

        HashSet<String> set = new HashSet<>();

        for (String string : strArr) {
            
            if (set.contains(string)) {
                return string;
            }
            set.add(string);
        }
        return "NoRepetition";
    }

    // using hashmap : time comp : o(n) and space is o(n).
    // use this when finding  "FIRST WORD which is repeating" .
    // for example : "he had had he" output : he (as he comes first)
    public static String getFirstWordWhichIsRepeating(String s) {
        
        String[] strArr = s.split(" ");
        HashMap<String , Integer> map = new HashMap<>();

        for (String string : strArr) {
            if(map.containsKey(string)){
                map.put(string, map.get(string)+1);
            }else{
                map.put(string, 1);
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            if(map.get(strArr[i]) > 1){
                return strArr[i];
            }
        }



        return "No Repetitions";
    }
}