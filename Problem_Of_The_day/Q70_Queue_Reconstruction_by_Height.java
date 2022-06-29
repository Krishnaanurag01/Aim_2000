package Problem_Of_The_day;
import java.util.*;

public class Q70_Queue_Reconstruction_by_Height {
    
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0] ) ;
        List<int[]> list = new ArrayList<>() ;
        for(int[] p: people) list.add(p[1],p) ;
        return list.toArray( new int[people.length][2]) ;
    }
}
