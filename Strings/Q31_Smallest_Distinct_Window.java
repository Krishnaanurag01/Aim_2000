package Strings;

import java.util.HashSet;

public class Q31_Smallest_Distinct_Window {
    public static void main(String[] args) {
        System.out.println(getSmallestWindow("AABBBCBBAC"));
    }

    public static String getSmallestWindow(String s) {

        // using set to get the total ditinct element.
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
        }

        int distinctChars = set.size();
        int start = 0  , startIndex = 0 , min_window = Integer.MAX_VALUE;
        int counter = 0;
        int[] charArray = new int[256];

        for (int i = 0; i < s.length() ; i++) {
            // increaing the character ascii value - 65 index data.
            charArray[s.charAt(i)-65]++;

            // if only 1 element present then we increase the counter. actually we are uniquely identifying here.
            if(charArray[s.charAt(i)-65]== 1) counter++;

            // if counter is equals to total ditinct element then we'll perform this.
            if(counter == distinctChars){

                // if the data is more than 1s then we'll decrease it and move further.
                while (charArray[s.charAt(start)-65] > 1) {
                    if(charArray[s.charAt(start)-65] > 1){
                        charArray[s.charAt(start)-65]--;
                    }
                    start++;
                }

               if(i-start+1 < min_window){
                   min_window = i-start+1;
                   startIndex =start;
               }
            }
        }

        return s.substring(startIndex, startIndex + min_window);
    }
}
