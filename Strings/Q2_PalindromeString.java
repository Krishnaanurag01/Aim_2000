package Strings;

public class Q2_PalindromeString {
    public static void main(String[] args) {
        String S = "racecar";
        System.out.println(isPlaindrome(S));
    }
    static int isPlaindrome(String S) {
        // code here
    int left = 0;
    int right = S.length()-1;
    
    while(left < right){
        if(S.charAt(left) == S.charAt(right)){
            right--;
            left++;
        }
        else{
            return 0 ;
        }
    }
    return 1;
    }
}
