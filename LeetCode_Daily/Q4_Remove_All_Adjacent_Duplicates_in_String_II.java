package LeetCode_Daily;
import java.util.*;

public class Q4_Remove_All_Adjacent_Duplicates_in_String_II {

    // method 01 : using extra class and stack.

    class Pair {
        char ch;
        int freq;

        Pair(char x, int y) {
            ch = x;
            freq = y;
        }

        public String toString() {
            return ch + " : freq -> " + freq;
        }
    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.size() > 0 && st.peek().ch == ch) { // if stack top char is same then increase the freq
                Pair rp = st.pop();
                rp.freq++;
                st.push(rp);
            } else { // else add new pair
                st.push(new Pair(ch, 1));
            }

            if (st.size() > 0 && st.peek().freq == k)
                st.pop();
        }

        StringBuilder sb = new StringBuilder();

        // now forming the answer string from stack.
        while (st.size() > 0) {
            Pair rp = st.pop();
            while (rp.freq-- > 0) {
                sb.insert(0, rp.ch);
            }
        }

        return sb.toString();
    }


    // using int array instead of pair class.
    
    public String removeDuplicates2(String s, int k) {
        
        Stack<int[]> st = new Stack<>() ;
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            if(st.size() > 0 && st.peek()[0] == ch){
                st.peek()[1]++ ;
            }
            else{
                st.push(new int[]{ch,1}) ;
            }
            
            if(st.peek()[1] == k)
                st.pop();
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        while(st.size() > 0 ){
           int[] rp = st.pop() ;
            while(rp[1]-- > 0){
                 sb.append((char)rp[0]);                
            }
        }
        
        return sb.reverse().toString() ;
    }
}
