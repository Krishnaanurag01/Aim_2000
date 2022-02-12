package Arrays_and_string_level_02;
import java.util.*;

public class Q26_Reverse_Vowels_of_a_String {

    public static void main(String[] args) {
        
        reverseVowels("hello");
    }

    // method 01 : brute force


    public static String reverseVowels(String s) {
        
        HashSet<Character> set = new HashSet<>() ;
        
        set.add('a') ;
        set.add('i') ;
        set.add('e') ;
        set.add('o') ;
        set.add('u') ;
        set.add('A') ;
        set.add('I') ;
        set.add('E') ;
        set.add('O') ;
        set.add('U') ;
        
        ArrayList<Character> vowels = new ArrayList<>() ;
        
        for(int i = 0 ; i < s.length() ; i++){ // adding all the vowels of string into arraylist.
            if(set.contains(s.charAt(i))){
                vowels.add(s.charAt(i)) ;
            }
        }
        
        ArrayList<Character> rev = new ArrayList<>() ;
        
       while(vowels.size() != 0 ){ // now adding vowels from old array list to new one this will make arraylist reverse.
            rev.add(vowels.remove(vowels.size()-1)) ;
        }
        
        StringBuilder sb = new StringBuilder() ;
       
        for(int i = 0 ; i < s.length() ; i++ ){
            char ch = s.charAt(i) ;
            
            if(set.contains(ch)){ // now if current char is vowels then insert the reverse char from rev
                sb.append( rev.size() > 0 ? rev.remove(0) : 'n') ;
            }
            else{ // else place the same character.
                sb.append(ch) ;
            }
        }
        
        
        return sb.toString() ;
        
        
    }

    // method 02 : more optimized method


    public String reverseVowels1(String s) {

        char[] arr = s.toCharArray() ;

        int left = 0 ; 
        int right = arr.length - 1 ;

        while (left < right) {
            
            // it will find the vowels from left
            while (left < right && isValid(arr,left) == false) {
             left++ ;   
            }

            
            
            // it will find the vowels from right
            while (left < right && isValid(arr,right) == false) {
             right-- ;   
            }

            // now we'll swap both the vowels
            swap(arr,left,right) ;
            left++ ; // and point left to next and right to previous.
            right-- ;
        }

        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {

        char temp = arr[left] ;
        arr[left] = arr[right] ;
        arr[right] = temp ;

    }

    private boolean isValid(char[] arr, int i) {

        if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U'  ) {

            return true ;
        }
        return false;
    }
    
}
