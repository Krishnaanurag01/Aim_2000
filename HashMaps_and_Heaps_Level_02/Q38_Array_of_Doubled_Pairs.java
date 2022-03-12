package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q38_Array_of_Doubled_Pairs {
    
    public boolean canReorderDoubled(int[] arr) {
        
        int n = arr.length ;
        
        if(n % 2 != 0){
            return false ; // pairing for odd length is not possible.
        }
        
        HashMap<Integer,Integer> map = new HashMap<>() ; // storing frequency
        
        for(int ele : arr)
            map.put(ele, map.getOrDefault(ele,0) + 1) ;
        
        Integer[] ar = new Integer[n] ;  // storing in Integer class so that we can sort the array element in our own way.
        
        for(int i = 0 ; i < n ; i++){
            ar[i] = arr[i] ; 
        }
        
        Arrays.sort(ar, (a,b) -> { // sorting on abs value so that negative value will also be able to work properly
           return Math.abs(a) - Math.abs(b);
        }) ;
        
       // System.out.println( Arrays.deepToString(ar) ) ;
        
        for(Integer ele : ar){
            if(map.get(ele) == 0 ) continue ; // means current element is paired up with someone already.
            int dbele = 2*ele ; // double of ele
            
            if(map.getOrDefault(dbele,0) == 0 ) {
                return false ; // when double of ele is not present or double of ele is not free(already paired up with someone) 
            }
            
            // else we got our pair so using it by reducing the frequency
            
            map.put(ele, map.get(ele) - 1) ;
            map.put(dbele,map.get(dbele) -  1) ;
            
        }
        
        return true; 
    }


}
