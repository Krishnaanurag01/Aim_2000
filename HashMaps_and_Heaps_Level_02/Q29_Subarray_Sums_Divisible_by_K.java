package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q29_Subarray_Sums_Divisible_by_K {

    // same as Q28
    // here we storing remainder as key and value as frequency.
    
    public int subarraysDivByK(int[] a, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
       
       int n = a.length ;
       
       map.put(0, 1) ;
       int sum = 0 ;
       int ans = 0 ;
       
       for(int i = 0 ; i < n ; i++){
           sum += a[i] ;
         
           int rem = sum % k ;
           
           if(rem < 0 ){
               rem += k ;
           }
           
           if(map.containsKey(rem) ){
               ans += map.get(rem) ;
           }
           
           
               map.put(rem, map.getOrDefault(rem, 0) + 1) ;
           
           
       }
       
       return ans ;
       
   }


}
