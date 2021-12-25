package Problem_Of_The_day;

public class Q29_Valid_SubString {

    static int findMaxLen(String S) {
        
        int n = S.length() ;
        int o = 0 ;
        int c = 0 ;

        int ans = 0 ;

        for (int i = 0; i < n ; i++) {
            
            char ch = S.charAt(i) ;

            if(ch == '('){
                o++ ;
            }
            else {
                c++ ;
            }

            if(o == c){
                ans = Math.max(ans, c*2) ;
            }

            if(c > o){
                o = c = 0 ;
            }
        }

        o = c = 0 ;

        
        for (int i = n-1 ; i >= 0 ; i--) {
            
            char ch = S.charAt(i) ;

            if(ch == '('){
                o++ ;
            }
            else {
                c++ ;
            }

            if(o == c){
                ans = Math.max(ans, c*2) ;
            }

            if(c < o){
                o = c = 0 ;
            }
        }



        return ans ;
    }
    
}
