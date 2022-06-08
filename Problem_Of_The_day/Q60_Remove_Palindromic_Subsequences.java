package Problem_Of_The_day;

public class Q60_Remove_Palindromic_Subsequences {
    // as string contains only "a" and "b" hence if string is palindrome then answer is 1 otherwise it is 2
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString().equals(s) ? 1 : 2;
    }
}
