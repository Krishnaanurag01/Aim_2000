package Dynamic_Programming_level_01;

/**
 * Q16_Count_subsequences_of_type_ai_bj_ck
 */
public class Q16_Count_subsequences_of_type_ai_bj_ck {

    public static void main(String[] args) {
        
    }

    public static int getCount(String s){
        
        int a = 0 ; // store a count
        int ab = 0 ;// store ab count
        int abc = 0; // store abc count
        
        int mod  = 1000000007 ;  // given in question to use mod.
        for(int i = 0 ; i < s.length() ; i++){
            
            if(s.charAt(i) == 'a'){ // when a then add it to the a with formula : 2 * a + 1( which means current a is added or current a is not added in previous value or current a start new sequence.)
                a = ((2*(a % mod ))%mod + 1)%mod ;
            }
            else if(s.charAt(i) == 'b' ) {// when b then add it to the ab with formula : 2 * ab + a ( which means current b is added or current b is not added in previous value or current b is added to the every value of a which will make ab.)
                ab = ((2 * (ab % mod ))%mod + a)%mod ;
            } 
            else{ // when c then add it to the abc with formula : 2 * abc + ab ( which means current c is added or current c is not added in previous value or current c is added with all the values of current ab which will make abc.)
                abc = ((2*(abc % mod))%mod + ab)%mod ;
            }
            
        }
        
        return (abc)%mod ;
    }
}
