package Problem_Of_The_day ;
import java.util.*;
public class Q149_Count_Vowels_Permutation {
    
        HashMap<String,Long> dpMap;
        int mod = (int)1e9+7 ;
        public int countVowelPermutation(int n) {
            if(n == 1) return 5 ;
            dpMap = new HashMap<>() ;
           char[] arr = {'a','e','i','o','u'} ;
            long count = 0 ;
            
            for(char ch : arr){
                count = (count + helper(n-1,ch))% mod;
            }
            
            return (int)count;
        }
        
        long helper(int n, char last){
            
            if(n == 0) return 1 ;
            StringBuilder sb = new StringBuilder() ;
            sb.append(n+"-");
            sb.append(last) ;
            String key = sb.toString() ;
            if(dpMap.containsKey(key)) return dpMap.get(key) ;
            long count = 0 ;
            
            switch(last){
                case 'a' : 
                    count = helper(n-1,'e') ;
                    break;
                case 'e' :
                    count = (helper(n-1,'a')%mod + helper(n-1,'i')%mod)%mod ;
                    break ;
                case 'i' :
                    count = (helper(n-1,'a')%mod + helper(n-1,'e')%mod + helper(n-1,'o')%mod + helper(n-1,'u')%mod)%mod;
                    break;
                case 'o' :
                    count = (helper(n-1,'i')%mod + helper(n-1,'u')%mod)%mod ;
                    break;
                case 'u' : 
                    count = helper(n-1,'a')%mod ;
            }
            
            dpMap.put(key,count) ;
            return count  ;
        }
}
