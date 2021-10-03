package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class Q31_Smallest_Distinct_Window {
    public static void main(String[] args) {
        System.out.println(getSmallestWindow("AABBBCBBAC"));
        System.out.println(getSmallestWindowSize("AABBBCBBAC"));
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

    // using hashmap and hashset.
    // time complexicity  : 0(n)

    public static int getSmallestWindowSize(String s) {
        
        // getting all the distinct characters.
        HashSet<Character> set = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            set.add(ch);
        }

        int i = -1 ; 
        int j = -1 ;

        HashMap<Character,Integer> mHashMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // first acquire the characters.
            while (i < s.length()-1 &&  mHashMap.size() < set.size() ) {
                i++;
                char ch = s.charAt(i);

                mHashMap.put(ch, mHashMap.getOrDefault(ch,0) + 1 );
                f1 = true;
            }
            // now release.

            while (j < i && set.size() == mHashMap.size()) {
                int currentLen = i-j;
                if(currentLen < ans){
                    ans = currentLen;
                }
                j++;
                char ch = s.charAt(j);
                if(mHashMap.get(ch)== 1){
                    mHashMap.remove(ch);
                }
                else{
                    mHashMap.put(ch, mHashMap.get(ch) - 1);
                }
                f2 = true;
            }
            if(f1 == false && f2  == false){
                break;
            }

        }
        return ans;
    }
}
