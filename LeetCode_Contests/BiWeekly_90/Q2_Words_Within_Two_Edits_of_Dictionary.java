package LeetCode_Contests.BiWeekly_90;
import java.util.*;

public class Q2_Words_Within_Two_Edits_of_Dictionary {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> ans = new ArrayList<>() ;
        
        for(String q : queries){ // check for each query
            if(helper(q,dictionary)){ // if any dictionary word can be made with or without edit then this is one of the answer.
                ans.add(q) ;
            }
        }
        
        return ans ;
    }
    
    boolean helper(String q, String[] dict){
        
        for(String s : dict){ // check query word with every dict word
            int false_count = 0;
            
            for(int i = 0 ; i < q.length() && false_count <= 2 ; i++){
                char qch = q.charAt(i) ;
                char sch = s.charAt(i) ;
                
                if(qch != sch) false_count++;  // if char is not same
            }
            
            // agar false count less or equal to 2 hai toh yeh dictionary word me convert ho sakta within 2 edits.
            if(false_count <= 2) return true;
        }
        
        return false;
    }
}
