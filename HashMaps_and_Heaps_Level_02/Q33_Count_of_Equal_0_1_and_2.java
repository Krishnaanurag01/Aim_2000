package HashMaps_and_Heaps_Level_02;
import java.util.*;

// same as Q33.
public class Q33_Count_of_Equal_0_1_and_2 {
    
    long getSubstringWithEqual012(String str) 
    { 
        
         HashMap<String,Integer> map = new HashMap<>() ;

        int countz = 0 ; // count of zero
        int counto = 0 ; // count of one
        int countt = 0 ; // count of two

        int delta10 = counto - countz ; // difference of count 1 - count 0 
        int delta21 = countt - counto ; // difference of count 2 - count 1 

        String key = delta10 + "#" + delta21 ;
        map.put(key,1) ; // denotes this key with freq 1.

        int ans = 0 ;
        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i) ;

            if( ch == '0' )
            {
                countz++ ;
            }
            else if( ch == '1' ){
                counto++ ;
            }
            else{
                countt++ ;
            }

            delta10 = counto - countz ;
            delta21 = countt - counto ;

            String tempKey = delta10+ "#" + delta21 ;

            if(map.containsKey(tempKey)){
                ans +=  map.get(tempKey) ; // adding all the freq of this tempKey
            }
            
                map.put(tempKey,map.getOrDefault(tempKey,0)+1) ;// increasing the freq
        }

        return ans;
    }

}
