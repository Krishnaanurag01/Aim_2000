package Strings;

public class Q1_ReverseAString {
    public static void main(String[] args) {
        char[] arr = {'r','a','c','e','c','a','r','a','f'};
        reverseString(arr);
        for (char c : arr) {
            System.out.print(c+" ");
        }
    }
    public static void reverseString(char[] s) {
        
        int left = 0 ;
        int right  = s.length-1;
        
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            right--;
            left++; 
        }
        
    }
}
