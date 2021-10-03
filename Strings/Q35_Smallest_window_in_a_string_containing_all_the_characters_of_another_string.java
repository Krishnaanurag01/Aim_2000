package Strings;

import java.util.HashMap;



public class Q35_Smallest_window_in_a_string_containing_all_the_characters_of_another_string {
    public static void main(String[] args) {

        System.out.println(getSmallestWindow("zoomlazapzo","oza"));
    }

    public static String getSmallestWindow(String s1, String s2) {
        
        HashMap<Character , Integer> mapForStr2 = new HashMap<>();
        for (Character ch : s2.toCharArray()) {
            mapForStr2.put(ch, mapForStr2.getOrDefault(ch, 0) + 1);
        }

        int i = -1;
        int j = -1;
        String ans = "";
        int msc = 0;  // mesured string count.
        int dsc = s2.length();  // desired string count.

        HashMap<Character,Integer> mapForStr1 = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // first acquire the characters int string 1.
            while (i < s1.length()-1 && msc < dsc) {
                i++;
                char ch = s1.charAt(i);
                // increasing the freq in mapforstring 1.
                mapForStr1.put(ch, mapForStr1.getOrDefault(ch, 0) +1);

                // incrementing msc if freq of ch in map 1 is less than or equal to freq in map 2.
                if (mapForStr1.getOrDefault(ch,0) <= mapForStr2.getOrDefault(ch,0)) {
                    msc++;
                }

                f1 = true;
            }

            // now collecting the string and releasing it till it becomes msc < dsc.

            while (j < i && msc == dsc) {
                String currentString = s1.substring(j+1, i+1);
                if(ans.length() == 0 || currentString.length() < ans.length()){
                    ans = currentString;
                }
                j++;
                char ch = s1.charAt(j);

                if (mapForStr1.get(ch)==1) {
                    mapForStr1.remove(ch);
                }
                else {
                    mapForStr1.put(ch, mapForStr1.get(ch)-1);
                }

                if(mapForStr1.getOrDefault(ch,0) < mapForStr2.getOrDefault(ch,0)){
                    msc--;
                }
                
                f2 = true;
            }

            if( f1 == false && f2 == false){
               break;
            }            
        }
        return ans ;
    }
}
