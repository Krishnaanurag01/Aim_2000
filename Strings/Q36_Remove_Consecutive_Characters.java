package Strings;

import java.util.Arrays;

// import java.util.Stack;

public class Q36_Remove_Consecutive_Characters {
 public static void main(String[] args) {
     System.out.println(removeDuplicate("geeksforgeeks"));
 }   
 public static String removeDuplicate(String s) {
     

    // Stack<Character> stack = new Stack<>();
    // stack.add(s.charAt(0));
    // for (int i = 1; i < s.length(); i++) {
    //     if(stack.peek() != s.charAt(i)){
    //         stack.add(s.charAt(i));
    //     }
    // }


    char[] sArr = s.toCharArray();
    if(s.length() < 2){
        return s;
    }
    int j = 0 ;
    for (int i = 1; i < sArr.length; i++) {
        if(sArr[j] != sArr[i]){
            j++;
            sArr[j] = sArr[i];
        }
    }
    return String.valueOf(Arrays.copyOfRange(sArr,0,j+1));
 }
}
