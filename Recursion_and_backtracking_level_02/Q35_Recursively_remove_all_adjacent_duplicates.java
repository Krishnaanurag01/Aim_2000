package Recursion_and_backtracking_level_02;

public class Q35_Recursively_remove_all_adjacent_duplicates {

    String rremove(String s) {
        // code here
        return helper(s) ;
    }
    
    String helper(String s){
        if(s.length() <= 1) return s ; // when string is of length 1 or 0 return directly
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0; i < s.length() ; i++ ){ // if prev and next char of current char is different then we can add the current char in new string
            char ch = s.charAt(i) ;
            char prev = i > 0 ? s.charAt(i-1) : '#' ;
            char next = i < s.length() - 1 ? s.charAt(i+1) : '#' ;
            
            if(ch != prev && ch != next)
            sb.append(ch) ;
        }
        
        if(sb.toString().equals(s)) return s ; // if given string and new string both are equal then it means there's no duplicacy left so return string directly.
        return helper(sb.toString()); // else remove it in next call.
    }
}
