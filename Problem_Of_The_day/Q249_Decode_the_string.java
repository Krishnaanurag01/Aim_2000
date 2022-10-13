package Problem_Of_The_day;
import java.util.*;

public class Q249_Decode_the_string {

    static String decodedString(String s){
        Stack<Character> stack = new Stack<>() ;
              
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            
            if(ch == ']'){ // when get the ending bracket then perform following.
                StringBuilder swb = new StringBuilder(); // string within bracket (swb)
                
                while(stack.size() > 0 && stack.peek() != '['){
                    swb.append(stack.pop()) ;
                }
                
                swb = swb.reverse() ; // revrseing becuase stack reversed the string.
                stack.pop() ; // removing opening bracket.
                StringBuilder freq = new StringBuilder() ; // now finding the digit i.e Multiplier of current string.
                
                while(stack.size() > 0 && Character.isDigit(stack.peek())){
                    freq.append(stack.pop()) ;
                }
                
                int number = Integer.parseInt(freq.reverse().toString()) ;
                
                // now repeat string within bracket number times.
                
                StringBuilder repeated = new StringBuilder() ;
                
                for(int f = 1; f <= number ; f++){
                    repeated.append(swb) ;
                }
                
                //  and again push chaaracters in the stack.
                for(int k = 0 ; k < repeated.length() ; k++){
                    stack.push(repeated.charAt(k)) ;
                }
            }
            else{
                stack.push(ch) ;
            }
        }
        
        
        // now making the answer.
        StringBuilder ans = new StringBuilder() ;
        
        while(stack.size() > 0){
            ans.append(stack.pop()) ;
        }
        
        
        // and return answer by reversing it becuase stack made it reverse.
        return ans.reverse().toString() ;
    }
}
