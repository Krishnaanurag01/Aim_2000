package Recursion_and_backtracking_level_01;

public class Q21_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        
        return helper(t,s,0,0) ;
        
    }
    
    public boolean helper(String s , String t , int x , int y){

        // y -> index for t string
        // x -> index for s string (text that we want to identify)
        
        if( y == t.length() ){
            return true ;
        }
        else if( x == s.length()){
            return false;
        }
        else if(s.charAt(x) == t.charAt(y)){
           return helper(s,t,x+1,y+1) ;
        }
        else{
           return helper(s,t,x+1,y) ;
        }
    }
    
}
