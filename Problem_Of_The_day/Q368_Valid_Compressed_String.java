package Problem_Of_The_day ;
/**
 * Q368_Valid_Compressed_String
 */
public class Q368_Valid_Compressed_String {

    static int checkCompressed(String S, String T) {
        int idx = 0 ; // for S
 
 // iterate over T
        for(int i = 0 ; i < T.length() ; i++){
            char ch = T.charAt(i) ;
            if(idx >= S.length()) return 0 ; // means T has more elements so return false
            
            // if current char is digit then extract the digit
            if(Character.isDigit(ch)){
                int temp = 0 ;
                while(i < T.length() && Character.isDigit(T.charAt(i))){
                    int t = T.charAt(i) - '0' ;
                    temp = temp*10 + t ;
                    i++ ;
                }
                i-- ; // as we incremented one extra
                
                // and skip temp char in S
                idx += temp ;
                if(idx > S.length()) return 0 ;
                
                continue ;
            }
            // otherwise compare with S char
            if(S.charAt(idx) != T.charAt(i)) return 0 ;
            idx++ ;
        }
        
        return 1 ;
    }
}