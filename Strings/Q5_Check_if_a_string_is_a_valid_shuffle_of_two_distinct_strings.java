package Strings;

import java.util.Arrays;

public class Q5_Check_if_a_string_is_a_valid_shuffle_of_two_distinct_strings {
    public static void main(String[] args) {
        System.out.println(isValid("XY", "12", "Y21XX"));
    }
    public static boolean isValid(String str1, String str2 , String shuffledString) {
        
        // checking the length of suspected string if it is not equal to str1 + str2 length then the shuffled string is wrong.
        if(str1.length() + str2.length() != shuffledString.length()) return false;

        // now sorting the string in ascending order.
        str1 = sortString(str1);
        str2 = sortString(str2);
        shuffledString = sortString(shuffledString);

        // initialization of pointers of each string.

        int i = 0 ; // for string 1.
        int j = 0 ; // for string 2.
        int k = 0 ; // for string 3.

        // now checking the char of shuffled string with both str 1 and str2 if it does not found char in any on those string then it will return false. else if it  found the character then pointer i or j get increamented .

        while (k != shuffledString.length()) {
            if(i < str1.length() && str1.charAt(i) == shuffledString.charAt(k)) i++;
            else if(j < str2.length() && str2.charAt(j) == shuffledString.charAt(k)) j++;
            else{
                return false;
            }
            k++;
        }

        // now if loop is doesn't found any error then we have to check the length of both the string 1 and string 2 . if the length of i & j both is not equal to length of string 1 and string 2 then it means that some characters doesn't checked in both string means some characters are left then it will return false else return true.
        if(i < str1.length() || j < str2.length()){
            return false;
        }
        return true;
    }

    // used this for sorting the string.
    public static String sortString(String str) {
        char[] stringArray = str.toCharArray();
        Arrays.sort(stringArray);

        return String.valueOf(stringArray);
    }
}
