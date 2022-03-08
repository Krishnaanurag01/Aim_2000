package HashMaps_and_Heaps_Level_01;
import java.util.*;

public class Q3_Nearly_sorted {

    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        
        PriorityQueue<Integer> q = new PriorityQueue<>() ;
        
        // storing k+1 element first in array
        for(int i = 0 ; i <= k ; i++){
            q.add(arr[i]) ;
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>() ;
        
        // now removing the smallest value each time and adding one to ans

        for(int i = k +1; i < num ; i++){
            ans.add( q.poll() ) ;
            
            q.add(arr[i]) ;
        }
        
        
        // now removing the rest
        while(q.size() > 0 ) 
        ans.add(q.poll()) ;
        
        
        return ans ;
        
    }
    
}
