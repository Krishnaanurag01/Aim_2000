package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q34_Sum_equals_to_Sum {

    // time comp : O(n2) but it is the efficient one.

    public int findPairs(int arr[],int n) 
    { 
      
        HashSet<Integer> set = new HashSet<>() ;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                
                int sum = arr[i] + arr[j] ;
                
                if(set.contains(sum) ) {
                    return 1 ;
                }
                
                set.add(sum ) ;
            }
        }
        
        return 0; 
    }
    
}
