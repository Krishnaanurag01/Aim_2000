package HashMaps_and_Heaps_Level_02;

import java.util.*;

public class Q18_Find_All_Anagrams_in_a_String {

    // method 01 :

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) // base case.
            return list;

        int len = p.length();
        int n = s.length();

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        // adding first pmap into hashmap and also adding same length window in smap.
        for (int i = 0; i < len; i++) {

            char ch1 = p.charAt(i);
            char ch2 = s.charAt(i);

            pMap.put(ch1, pMap.getOrDefault(ch1, 0) + 1);
            smap.put(ch2, smap.getOrDefault(ch2, 0) + 1);
        }

        // int j = 0;

        for (int i = len; i < n; i++) {
            // comparing if both map contains same number of element then add the first index.
            if (compare(pMap, smap) == true) {
                list.add(i - len);
            }
            // aquiring ith char

            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            // releasing the jth char

            char ch2 = s.charAt(i - len);
            int freq = smap.get(ch2);

            if (freq == 1) {
                smap.remove(ch2);
            } else {
                smap.put(ch2, freq - 1);
            }
        }

        // checking last window.
        if (compare(pMap, smap) == true) {
            list.add(n - len);
        }

        return list;

    }

    static boolean compare(HashMap<Character, Integer> pMap, HashMap<Character, Integer> smap) {

        for (char ch : pMap.keySet()) {

            if (smap.getOrDefault(ch, 0) != pMap.get(ch)) {
                return false;
            }
        }

        return true;

    }

}
