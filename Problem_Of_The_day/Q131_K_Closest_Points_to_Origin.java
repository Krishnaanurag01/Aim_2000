package Problem_Of_The_day;
import java.util.*;

public class Q131_K_Closest_Points_to_Origin {

    public int[][] kClosest(int[][] points, int k) {
        
        // sorting based on the euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2). ignoring the root factor only.
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> (int)(Math.pow(a[0],2) + Math.pow(a[1],2)) - (int)(Math.pow(b[0],2) + Math.pow(b[1],2)) ) ;
        
        for(int[] point : points){
            pq.add(point) ;
        }
        
        int[][] ans = new int[k][2] ;
        
        int i = 0 ;
        while(k-- > 0 ){
            ans[i] = pq.poll() ;
            i++ ;
        }
        
        return ans ;
    }
}
