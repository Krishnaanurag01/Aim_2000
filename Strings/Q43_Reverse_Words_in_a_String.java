package Strings;

public class Q43_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        
        s = s.trim() ; // this will remove any extra space outside the string. ex : " abc  "
        StringBuilder sb = new StringBuilder() ;
        int m = s.length() ;
        
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char ch = s.charAt(i) ;
            if(ch== ' ' && s.charAt(i+1) == ' '){ // this handles -> "abs  abd"  // if extra space inbetween
                m = i ; // update it most recent white space
                continue ;
            }
            else if(ch == ' '){
                sb.append(s.substring(i+1,m)) ; // adding to string builder
                sb.append(" ") ; // and also a space
                m = i ; // updating space index
            }
        }
        
        sb.append(s.substring(0,m)); // adding first word. ex -"abc" of  "abc edf edf". 
        
        return sb.toString() ;
    }
    
}
