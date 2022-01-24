package Arrays_and_string ;
import java.util.*;

public class Q65_Interval_List_Intersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int[]> ans = new ArrayList<>() ;
        
        int ptr1 = 0 ;
        int ptr2 = 0 ;
        
        while( ptr1 < firstList.length && ptr2 < secondList.length ){
            int gSP = Math.max(firstList[ptr1][0], secondList[ptr2][0]); // greatest starting point.
            int sEP = Math.min(firstList[ptr1][1], secondList[ptr2][1]); // smallest ending point.
            
            if(gSP <= sEP ){ // if the starting point is smaller or equal to ending point then it is valid intersection. so add it to the ans list.
                ans.add( new int[]{gSP,sEP} ) ;
            }

            // here we are checking the smaller ending point list.
            // if the firstList[ptr1] has smaller ending point then it means we have to increment the index of firstList else go with the secondList.
            if(firstList[ptr1][1] <= secondList[ptr2][1]){
                ptr1++ ;
            }
            else{
                ptr2++ ;
            }
            
        }
        
        // returning as string.
        return ans.toArray(new int[ans.size()][]) ;
        
    }
    
}
