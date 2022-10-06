package Problem_Of_The_day;
import java.util.*;

public class Q243_Lexicographically_smallest_string {

    static String lexicographicallySmallest(String S, int k) {
        
        int p = 0 ;
        
        // finding whether current length of S is power of 2 or not.
        while(Math.pow(2,p) < S.length()){
            p++ ;
        }
        
        // if it is then divide k by 2
        if(Math.pow(2,p) == S.length()){
            k = k/2 ;
        }
        else{ // otherwise
            k = k * 2 ;
        }
        
        // System.out.println(k) ;
        
        // A case when k is larger than S then return -1;
        if( k > S.length()) return "-1" ;
        
        // using stack to find the next smaller element.
        int[] next_smaller = new int[S.length()] ;
        Stack<Integer> st = new Stack<>() ;
        
        for(int i = S.length() - 1 ; i >= 0 ; i--){
            char ch = S.charAt(i) ;
            
            while(st.size() > 0 && S.charAt(st.peek()) >= ch ){
                st.pop() ;
            }
            
            if(st.size() == 0){
                next_smaller[i] = S.length() ;
            }
            else{
                next_smaller[i] = st.peek() ;
            }

            st.push(i) ;
            // System.out.println(i + " - " + next_smaller[i]) ;
        }
        
        
        
        // final step of forming the string.
        int i = 0 ;
        StringBuilder sb = new StringBuilder() ;
        
        while(i < S.length()){
            int next = next_smaller[i] ;
            // if before the next smaller element characters are less or equal as of k then remove all
            if(next - i  <= k){
                k = k - (next - i) ; // decresing k as well
                i = next ; // and moving to next smaller element
            }
            else{
                sb.append(S.charAt(i)) ; // otherwise append it.
                i++ ;
            }
            // System.out.println(sb + " - " + i + " -- "+ k) ;
        }
        
        if(k > 0) return "-1" ;
        return sb.length() == 0 ? "-1" : sb.toString() ; // if string becomes empty then return -1
    }
}
