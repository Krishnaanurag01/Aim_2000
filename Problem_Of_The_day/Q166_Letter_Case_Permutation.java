package Problem_Of_The_day;
import java.util.*;

public class Q166_Letter_Case_Permutation {

    List<String> ans ;
    public List<String> letterCasePermutation(String s) {
     ans =new ArrayList<>();
        dfs(0,new StringBuilder(s)) ;
        return ans ;
    }
    
    void dfs(int i, StringBuilder s){
        if(i >= s.length()){
           ans.add( s.toString()) ; 
            return;
        }
        
        char ch = s.charAt(i) ;
        if(Character.isDigit(ch)) { // if current char is digit then go to next index only
            dfs(i+1,s) ;
            return; // and return
        }
        
        dfs(i+1,s) ;
        
        if(Character.isUpperCase(ch)){ // if current char is upper case the convert to lower and vice versa
            s.setCharAt(i, Character.toLowerCase(ch)) ;
            dfs(i+1,s) ;
        }
        else{
            s.setCharAt(i, Character.toUpperCase(ch)) ;
            dfs(i+1,s) ;
        }
    }
}
