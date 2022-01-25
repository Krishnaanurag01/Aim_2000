package Arrays_and_string;
import java.util.*;

public class Q67_Minimum_Number_of_Arrows_to_Burst_Balloons {

    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a,b) ->  Integer.compare( a[1] , b[1] ) ) ; // sorting based on the end point.
        
       
        int count = 1 ; // considering one arrow by default.
        int prevEnd = points[0][1]  ; // and also taking the end point of first balloon 
        
        for(int i = 1 ; i < points.length ; i++){ // now starting from 1 as 0th index balloon is already considered
            if( points[i][0] <= prevEnd){ // if the current balloon's starting point is less then previous end point of balloon then it means then current balloon will also be popped( fired vertically arrow) if we fire the arrow for prev balloon so continue;
                continue ;
            }
            else{
                count++ ; // else increase the arrow count
                prevEnd = points[i][1] ; // and update the end point 
            }
        }
        
        
        return count ;
    }
    
}
