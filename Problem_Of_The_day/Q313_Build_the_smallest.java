package Problem_Of_The_day ;
import java.util.*;

public class Q313_Build_the_smallest {
    static String buildLowestNumber(String str, int K){
        
        // finding next smaller using stack.
        int N = str.length() ;
        int[] ns = new int[N] ;
      
        Stack<Integer> st = new Stack<>() ;
        
        for(int i = N - 1 ; i >= 0 ; i--){
            int num = str.charAt(i) - '0' ;
            while(st.size() > 0 && (str.charAt(st.peek()) - '0') >= num){
                st.pop() ;
            }
            
            if(st.size() > 0){
                ns[i] = st.peek() ;
            }
            else{
                ns[i] = N ;
            }
            st.push(i) ;
        }
        
        
        // now making answer.
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < N ; i++){
            int num = str.charAt(i) - '0' ;
            if(ns[i] - i <= K){ // if all chhar before next smaller char can be removeed then do it 
                K = K - ( ns[i] - i ) ; // and also decrease the k
                i = ns[i] - 1 ; // and move to next smaller
                continue ;
            }
            sb.append(num) ; // making up the answer.
        }
        
        // below loop helps in getting rid of prefix zeros 
        
        StringBuilder ans = new StringBuilder() ;
        for(int i = 0 ; i < sb.length() ; i++){
            char num = sb.charAt(i) ;
            if(num == '0' && ans.length() == 0){
                continue ;
            }
            ans.append(num) ;
        }
        
        if(ans.length() == 0) return "0" ;
        return ans.toString() ;
    }    
}
