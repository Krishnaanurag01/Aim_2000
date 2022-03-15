package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q55_Pairs_of_Non_Coinciding_Points {

     // formula for this is : 
    /*
    x1 = x2 ;
    y1 = y2 ;
    x1 = x2 &&& y1 = y2 ;
    */
    static int numOfPairs(int[] X, int[] Y, int N) {
        
        HashMap<Integer,Integer> xmap = new HashMap<>(); // stores the frequency of x point
        HashMap<Integer,Integer> ymap = new HashMap<>(); // stores y point frequency
        HashMap<String,Integer> xymap = new HashMap<>(); // stores xy point frequency
        
        int sum = 0 ;
        
        for(int i = 0 ; i < N ; i++){
            
            int x = X[i] ;
            int y = Y[i] ;
            String xy = x+"*"+y ;
            
            int xfreq = xmap.getOrDefault(x,0) ; // getting the count of equal x
            int yfreq = ymap.getOrDefault(y,0) ; // equal y
            int xyfreq = xymap.getOrDefault(xy,0); // and count of xy which came before
            
            sum += xfreq + yfreq - 2*xyfreq ; // adding x and y and subustracting xy becuase xy comes in both x and y count that's why subtracting 2*xy 
            
            xmap.put(x,xfreq+1) ;
            ymap.put(y,yfreq+1) ;
            xymap.put(xy, xyfreq+1) ;
        }
        
        return sum ;

    }
    
}
