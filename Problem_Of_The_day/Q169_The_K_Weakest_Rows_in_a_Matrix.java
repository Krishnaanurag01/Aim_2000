package Problem_Of_The_day;
import java.util.*;

public class Q169_The_K_Weakest_Rows_in_a_Matrix {

    class comp implements Comparator<int[]>{
        public int compare(int[] o1, int[] o2){
            if(o1[1] != o2[1]){
                return o1[1] - o2[1] ;
            }
            return o1[0] - o2[0] ;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> pq= new PriorityQueue<>(new comp()) ;
        
        for(int i = 0 ; i < mat.length ; i++){
            
            int[] arr = mat[i] ;
            int low = 0 ;
            int high = mat[0].length - 1;
            
            while(low <= high){
                int mid = low + (high - low)/2 ;
                if(arr[mid] < 1){
                    high = mid - 1 ;
                }
                else{
                    low = mid + 1 ;
                }
            }
            
            
            int count = low + 1 ;
            
            pq.add( new int[]{i,count}) ;
        }
        
        int ans[] = new int[k] ;
        
        int m = 0 ;
        while(k-- > 0){
            ans[m++] = pq.poll()[0] ;
        }
        
        
        return ans ;
    }
}
