package Strings;

public class Q7_Longest_Palindrome_in_a_String {
    public static void main(String[] args) {
        
    }
    int resultStart;
    int resultLength;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int i = 0 ; i < s.length()-1 ; i++){
            checkPalindrome(s,i,i);
            checkPalindrome(s,i,i+1);
        }
        
        return s.substring(resultStart, resultStart+resultLength);
    }
    
    public void checkPalindrome(String s , int start , int end){
        while(start >= 0 && end< s.length() && s.charAt(start)== s.charAt(end)){
            start--;
            end++;
        }
        
        if(resultStart < end- start - 1){
            resultStart  = start+1;
            resultLength = end- start -1;
        }
    }
}
