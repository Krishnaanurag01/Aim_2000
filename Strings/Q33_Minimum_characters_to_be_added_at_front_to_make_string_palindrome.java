package Strings;


public class Q33_Minimum_characters_to_be_added_at_front_to_make_string_palindrome {
    public static void main(String[] args) {
        System.out.println(makePalindrommic("AACECAAAA"));
    }
    public static int makePalindrommic(String s) {
        
        int last = s.length()-1;
        int start = 0 ;

        int count = 0;
        // "A A C E C  A A A A"
        while (start < last) {
            if(s.charAt(last) == s.charAt(start)){
                start++;
                last--;
            }else{
                count++;
                last--;
            }
        }
        return count;
    }
}
