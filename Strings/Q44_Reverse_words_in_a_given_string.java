package Strings;

public class Q44_Reverse_words_in_a_given_string {

    String reverseWords(String S)
    {

        // same as Q43
       
        StringBuilder sb = new StringBuilder() ;
        int m = S.length() ;
        
        for(int i = S.length() - 1 ; i >= 0 ; i-- ) {
            char ch = S.charAt(i) ;
            
            if(ch == '.'){
                sb.append( S.substring(i+1,m) ) ;
                sb.append(".");
                m = i ;
            }
        }
        
        sb.append(S.substring(0,m)) ;

        

        return sb.toString() ;
    }
    
}
