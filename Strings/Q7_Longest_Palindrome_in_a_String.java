package Strings;

public class Q7_Longest_Palindrome_in_a_String {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("rfkqyuqfjkxy"));
    }


    static int resultStart = 0;
    static int resultLength = 0 ;


    ///Time complexity: O(n^2), where n is the length of the input string. 
// A nested traversal of the string is needed. So time complexity is O(n^2).
// Auxiliary Space: O(1). 
// No extra space is needed.


    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int i = 0 ; i < s.length()-1 ; i++){
            expandAndCheck(s,i,i); // this will check for odd length string.
            expandAndCheck(s,i,i+1); // this will check for even length string.
        }
        
        return s.substring(resultStart, resultStart+resultLength);
    }
    
    public static void expandAndCheck(String s , int start , int end){
        while(start >= 0 && end < s.length() && s.charAt(start)== s.charAt(end)){
            start--;
            end++;
        }
        
        if(resultLength < end - start - 1){ // here using -1  becuase we have extra start and extra end pointer. from above.
            resultStart  = start +1;
            resultLength = end - start -1;
        }
    }
}
