package Problem_Of_The_day;
import java.util.*;

public class Q281_Orderly_Queue {

    public String orderlyQueue(String s, int k) {
        if(k>1){ // if k is greater and it is mentioned that we can repeat step infinite times so just sort the char and return
            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray);
        } else {
            // when we can swap only one char then do following
            String ans = s;
            for(int i=0;i< s.length(); i++){
                // swap first char every time.
                s = s.substring(1) + s.substring(0,1); // and attach it to the end.
                // System.out.println(s + " -- " + ans + " ----- comp - > " + ans.compareTo(s)) ;
                if(ans.compareTo(s) >0){ // now just compare with the answer.
                    ans = s;
                }
            }
            return ans;
        }
    }

    
    /*
    s1.compareTo(s2) -> give positive if s1 is greater lexicographically
    s1.compareTo(s2) -> give negative if s1 is smaller lexicographically
    s1.compareTo(s2) -> give zero if s1 == s2
    
    */
}
