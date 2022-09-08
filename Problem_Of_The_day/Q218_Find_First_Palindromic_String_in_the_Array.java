package Problem_Of_The_day;

public class Q218_Find_First_Palindromic_String_in_the_Array {

    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word)) return word;
        }
        return "" ;
    }
    
    boolean isPalindrome(String s){
        int i = 0 ; 
        int j = s.length() - 1 ;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
