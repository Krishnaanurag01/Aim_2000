package Stack_and_Queue;

public class Q55_longest_valid_substring {

    static int findMaxLen(String S) {
        // code here
        
        int o = 0 ; // count of opening brackets.
        int c = 0 ; // count of closing brackets.
        int ans = 0 ; // this will be containing our answer.

        // first starting from left to right.
        
        for(int i = 0 ; i < S.length() ; i++ ) {
            if(S.charAt(i) == '('){
                o++ ; // increasing count of opening.
            }
            else{
                c++ ; // for closing
            }
            
            if( o == c ){ // the moment count of both becomes equal this means we got one valid substring so calculate answer.
                ans = Math.max(ans , c*2) ;
            }
            
            if(c > o){ // from left to right iteration we check if closing count becomes greater then intialize both count with 0 as we got an extra closing bracket which make our string invalid. 
                o = c = 0 ;
            }
        }
        
        o = c = 0 ; // now intializing both count 0 and we'll try to figure out answer from right to left.
        
        for(int i = S.length() - 1 ; i >= 0 ; i-- ) {
            if(S.charAt(i) == '('){
                o++ ;
            }
            else{
                c++ ;
            }
            
            if( o == c ){
                ans = Math.max(ans , c*2) ;
            }
            
            if(c < o){ // here we'll check if opening count becomes greater then intialize both count with 0 as we got an extra opening bracket which make our string invalid.
                o = c = 0 ;
            }
        }
        
        return ans ;
        
        
    }
    
}
