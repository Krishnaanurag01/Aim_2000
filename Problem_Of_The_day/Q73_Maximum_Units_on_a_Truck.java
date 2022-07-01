package Problem_Of_The_day;
import java.util.*;

public class Q73_Maximum_Units_on_a_Truck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1] ) ;
        int res = 0 ;
        for(int i = 0 ; i < boxTypes.length ; i++){
            int box = boxTypes[i][0] ;
            int units = boxTypes[i][1] ;
            
            if(truckSize > box){
                truckSize -= box ;
                res += box * units ;
            }
            else{
                res += truckSize * units ;
                return res ;
            }
        }
        return res ;
    }
}
