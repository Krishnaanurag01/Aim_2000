package Strings;

public class Q25_Longest_Common_Prefix {
    public static void main(String[] args) {
     String[] arr = {"flower","flow","fight"};
     System.out.println(getLongestCommonPrefix(arr));
    }
    
    public static String getLongestCommonPrefix(String[] arr) {
        // took first string as prefix and then comparing with next string in array after comparing result will get stored in prefix.
        String prefix = arr[0];

       for (int i = 1; i < arr.length; i++) {
           prefix = compareIt(prefix,arr[i]);
       }
       return prefix;
    }

    private static String compareIt(String prefix, String string) {
        String result = "";

        // comparing string 1 && string2.
        for (int i = 0, j = 0; i < prefix.length() && j < string.length() ; i++ , j++) {
            if(prefix.charAt(i) != string.charAt(j)){
                break;
            }
            result += prefix.charAt(i);
        }
        return result;
    }

    

}
