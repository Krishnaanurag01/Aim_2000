package Problem_Of_The_day;
import java.util.*;

public class Q248_Save_Your_Life {

    // kadanes algorithm on String.
    static String maxSum(String w,char x[],int b[], int n){
        StringBuilder sb = new StringBuilder() ;
        HashMap<Character,Integer> map = new HashMap<>();
        
        // storing given characters with their redefined ascii value.
        for(int i = 0; i < n ; i++){
            map.put(x[i], b[i]) ;
        }
        
        String ans = "";
        int best = (int)-1e9 ;
        int curr = (int)-1e9 ;
        
        for(int i = 0 ; i < w.length() ; i++){
            char ch = w.charAt(i) ;
            int ascii = 0 ;
            
            if(map.containsKey(ch)){ // if the redefined value of curr ch is present then use that
                ascii = map.get(ch) ;
            }
            else{ // o/w take original ascii 
                ascii = (int)(ch) ;
            }
            
            curr += ascii ;
            
            if(curr < ascii){ //now if curr get smaller then make curr equals to ascii
                curr = ascii ;
                sb = new StringBuilder() ;
            }
            
            sb.append(ch) ;
            
            if(curr > best){ // store the max value ascii substring
                best = curr ;
                ans = sb.toString() ;
            }

        }
        
        return ans ;
    }
}
