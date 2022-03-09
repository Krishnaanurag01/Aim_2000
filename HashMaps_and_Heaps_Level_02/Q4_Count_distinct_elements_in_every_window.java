package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q4_Count_distinct_elements_in_every_window {

    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
          HashMap<Integer,Integer> map = new HashMap<>() ;

          for (int i = 0 ; i < k-1 ; i++) {
              int val = A[i] ;
              map.put(val, map.getOrDefault(val, 0) + 1) ;
          }

          ArrayList<Integer> list = new ArrayList<>() ;

          for (int i = k-1 ,  j = 0 ; i < n ; i++, j++) {  
            int val = A[i] ;
            map.put(val, map.getOrDefault(val, 0 )+1) ;
            list.add( map.size() ) ;

            int freq = map.get(A[j]) ;

            if(freq == 1){
                map.remove(A[j]) ;
            }
            else{
                map.put(A[j], freq - 1) ;
            }
            
          }

        return list ;
    }
    
}
