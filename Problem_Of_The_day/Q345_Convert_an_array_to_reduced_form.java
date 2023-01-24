package Problem_Of_The_day;
import java.util.*;

public class Q345_Convert_an_array_to_reduced_form {
    
    void convert(int[] arr, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]) ;
        
        for(int i = 0 ; i < n ; i++){
            pq.add(new int[]{i, arr[i]}) ;
        }
        
        int i = 0 ;
        while(pq.size() >0){
            arr[pq.poll()[0]] = i++ ;
        }
    }
}
