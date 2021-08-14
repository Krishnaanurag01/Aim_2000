package Strings;

import java.util.ArrayList;

// we can't use the to print larger size string as it take 2^n-1 . n character space. for example : if our string is of 31 length then it takes 31gb of memory to store all the characters. so better use print sub_sequence code.

public class Q9_Get_SubSequence {
 public static void main(String[] args) {
     System.out.println(getAllSubsequences("abc"));
 }   

 public static ArrayList<String> getAllSubsequences(String str) {
     

    // taking first character.
    
    if (str.length()==0) {
        ArrayList<String> lastChar = new ArrayList<>();
        lastChar.add("");
        return lastChar;
    }
    char fc = str.charAt(0);

    // taking substring . i have written 1 in substring means it will include current index character till the end.
    String s = str.substring(1);
    ArrayList<String> tempList = getAllSubsequences(s);

    // adding current fc(first character) to the element of templist and storing in a new list.

    ArrayList<String> resultList = new ArrayList<>();

    for (String c : tempList) {
        resultList.add(""+c);
    }
    for (String c : tempList) {
        resultList.add(fc+c);
    }

    return resultList;
 }
}
