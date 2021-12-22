package Strings;
import java.util.*;


// finding same thing which was done in Q 17.
public class Q18_KMP_Algo {
    public static void main(String[] args) {
        String txt = "hqg";
        String pat = "q";
        KMP_Algo(pat,txt);
    }

    static ArrayList<Integer> KMP_Algo(String pat, String txt)
    {
        String s = pat+"#"+txt ; // making new string with pattern + "#" + text 
        System.out.println(s);
        int[] lps = lps_func(s) ; // now finding lps of new string s.

        int m = pat.length() ; // length of pattern
        System.out.println(m);
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        for(int i = m+1+1 ; i < lps.length ; i++ ) {
            if(lps[i] == m ){ // wherever the lps value equals to m then add first calculate its first index and add to list

                if(m == 1){ // if size is 1 then we don't have to find first pos as it has only one char so it is already first

                    list.add(i - m ); // so just subtracting m(length of patter) and as we have to give answer in 1 based indexing so not removing "#" size , it work as giving 1 based indexing.
                }
                else{
                    list.add(i - m - 1 - m + 2) ; // when m > 1 then first subtract pattern size and # size from indexing and then go to first positon from last position and then adding 2 for 1 based indexing.
                }
            }
        }

        System.out.println(list);
       return list ;
    }
    
    // check q19 for better explanation.
    static int[] lps_func(String s) {
        // code here
        int n = s.length() ;
        int[] lps = new int[n] ;
        
        int len = 0 ; // denotes last size of lps.
        int i = 1 ;
        // starting from 1 as when i = 0 (so it has no proper prefix and suffix so ans is 0 which is already present by default)
        
        while( i < n ){
            
            char ch = s.charAt(i) ;
            
            if(ch == s.charAt(len)){
                len++ ;
                lps[i] = len ;
                i++ ;
            }
            else{
                if(len > 0 ){
                    len = lps[len - 1] ;
                }
                else{
                    lps[i] = 0 ;
                    i++ ;
                }
            }
            
        }
        
        return lps ;
        
    }
}
