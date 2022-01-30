package Arrays_and_string_level_02;

import java.util.*;

public class Q51_Find_And_Replace_Pattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        // step 01 : make a string of pattern consist of numbers that will identify the
        // string.

        HashMap<Character, Integer> map = new HashMap<>();

        int x = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : pattern.toCharArray()) {
            if (map.containsKey(ch)) { // if char comes before then append it's corresponding value.
                sb.append(map.get(ch));
            } else { // else append new x in sb and also store in map
                sb.append(x);
                map.put(ch, x);
                x++; // incrementing the value for new characters.
            }
        }

        String patt = sb.toString(); // pattern identifier.

        // Step 02 : Now get each word from the array and make their string identifer
        // then check with the original pattern string identifier. if it matches then
        // add to the ans list.

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            // making identifier of each string.
            HashMap<Character, Integer> inmap = new HashMap<>();

            int y = 0;
            StringBuilder mb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (inmap.containsKey(ch)) {
                    mb.append(inmap.get(ch));
                } else {
                    mb.append(y);
                    inmap.put(ch, y);
                    y++;
                }
            }

            String inStr = mb.toString();

            // if the pattern identifier matches with the current word then add it to the ans list.
            if (patt.equals(inStr)) {
                ans.add(s);
            }

        }

        return ans;
    }

}
