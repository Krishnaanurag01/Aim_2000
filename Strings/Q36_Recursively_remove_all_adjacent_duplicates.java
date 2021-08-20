package Strings;

public class Q36_Recursively_remove_all_adjacent_duplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicate("geeksforgeeg"));
    }
    public static String removeDuplicate(String s) {
        // adding base char.
        char lastRemoved = '\0' ;
        return removeIt(s,lastRemoved); 

    }
    private static String removeIt(String s, char lastRemoved) {

        if(s.length() < 2 ) return s;

        // this will run when there's same adjecent character.
        if(s.charAt(0) == s.charAt(1)){
            lastRemoved = s.charAt(0);
            while (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
                s = s.substring(1, s.length());
            }
            // this will add the last adjecent char. for example : abbbz. so it will remove last remove b as well.
            s = s.substring(1, s.length());

            return removeIt(s,lastRemoved);
        }


        // when there are different characters in start.
        String rem_str = removeIt(s.substring(1, s.length()), lastRemoved);

        // this will check if the current string 0th index is equals to removed string which we got.
        if(rem_str.length()!= 0 && s.charAt(0) == rem_str.charAt(0)){
            lastRemoved = s.charAt(0);
            return rem_str.substring(1, rem_str.length());
        }

        // if the removed string length is 0 means duplicate characters are removed and 0th char of string is equals to last removed character then we'll simply return removed string.
        if(rem_str.length() == 0 && lastRemoved == s.charAt(0)){
            return rem_str;
        }

        return  s.charAt(0) + rem_str ;
    }
}
