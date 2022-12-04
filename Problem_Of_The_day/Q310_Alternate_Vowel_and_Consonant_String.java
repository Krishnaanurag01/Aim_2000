package Problem_Of_The_day;

public class Q310_Alternate_Vowel_and_Consonant_String {

    public String rearrange(String S, int N){
        
        int[] cons = new int[26] ; // stores consonats freq
        int[] vowels = new int[26] ; // store vowels freq
        
        // counting both so that we ccan decide who will come first based on which is larger
        int consonants = 0 ;
        int vowel_count = 0 ;
        
        if(Math.abs(vowel_count - consonants) > 1) return "-1" ;
        
        for(char ch : S.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){ // means vowels
                int idx = ch - 'a' ;
                vowels[idx]++ ;
                vowel_count++ ;
            }
            else{ // means consonants
                int idx = ch - 'a' ;
                cons[idx]++ ;
                consonants++ ;
            }
        }
        
        if(Math.abs(vowel_count - consonants) > 1) return "-1" ; // means we won't be having enough count so to make alternate string
        
        if(consonants > vowel_count){ // when consonant count is more conso comes first
            return helper(vowels, cons, S, N, 1) ; // first conso
        }
        else{ // when vowels count is larger means vowel comes first
            return helper(vowels, cons, S, N, 0) ; // first vowel
        }
    }
    
    String helper(int[] vowels, int[] cons, String S, int N, int flag){
        
        int c = 0 ; // consonant index
        int v = 0 ; // vowel index
        
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < N; i++){
            if(flag == 0){ // vowels.
                while(v < 26 && vowels[v] <= 0){ // go to a vowel which is present
                    v++ ;
                }
                
                if(v == 26){
                   return "-1" ;
                }
                else{
                    char ch = (char)('a' + v) ;
                    vowels[v]-- ; // decreasing the count
                    sb.append(ch) ; // and adding it to the String
                }
                flag = 1 ; // now changing it to the consonant for next char
            }
            else{
                // consonant.
                while(c < 26 && cons[c] == 0){ // go to consonant which is present
                    c++ ;
                }
                
                if(c == 26) return "-1" ;
                
                if(c < 26){
                    char ch = (char)('a' + c) ;
                    cons[c]-- ; // decreasing the count
                    sb.append(ch) ; // and adding it to the string
                } 
                
                flag = 0 ; // now changing it to the vowel for next char
            }
        }
        
        return sb.toString() ;
    }
}
