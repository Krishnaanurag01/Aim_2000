package Stack_and_Queue;
import java.util.*;

public class Q27_Remove_Duplicate_Letters { 

    public static void main(String[] args) {
        
       System.out.println(  removeDuplicateLetters("bcabc") );
    }
    
    public static String removeDuplicateLetters(String s) {
        
        int[] count = new int[26] ;
        
        for(int i = 0 ; i < s.length() ; i++){   // counting freq of each letter
            char ch = s.charAt(i);
            count[ ch - 97 ]++ ;
        }
        
        boolean[] isIn = new boolean[26] ; /// define if any letter is already existing or not
        Stack<Character> stack = new Stack<>() ; 
        
        for(int i = 0 ; i < s.length() ; i++) {
            
            
            char ch = s.charAt(i);
            count[ch - 97]-- ; // decreamenting the freq
            if(isIn[ch - 97]) continue ; // if already exist then skip
            
            
            
            while(stack.size() > 0 && stack.peek() > ch && count[ stack.peek() - 97 ] > 0){ // remove those element which is larger than current char( ascii) and that element must have freq greater than 0, also make their isExist arr to false.
                
                isIn[ stack.peek() - 97 ] = false ;
                stack.pop() ;
                
            }
            
            stack.push(ch) ; // now pushing current char
            
            
            isIn[ch - 97] = true ; // making true
        }


        // making string

        char[] arr = new char[stack.size()] ;

        for (int i = stack.size() - 1 ; i >= 0 ; i--) {
            arr[i] = stack.pop() ;
        }


        
        return new String(arr) ;
    }
        
    }
