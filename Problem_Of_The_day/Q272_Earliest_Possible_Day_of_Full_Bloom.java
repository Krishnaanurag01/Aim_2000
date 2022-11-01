package Problem_Of_The_day;
import java.util.*;

public class Q272_Earliest_Possible_Day_of_Full_Bloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length ;
        Pair[] arr = new Pair[n] ;
        
        // making a pair array.
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Pair(plantTime[i], growTime[i]) ;
        }
        
        Arrays.sort(arr, (a,b) -> b.gt - a.gt ) ; // sorting based on grow time in descending order.
        
        int start = 0 ;
        int ans = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            start += arr[i].pt ; // now planting 
            ans = Math.max(ans, start + arr[i].gt) ; // ans is planttime + growtime.
        }
        
        return ans ;
    }
    
    class Pair{
        int pt ;
        int gt ;
        
        Pair(int x, int y){
            pt = x;
            gt = y ;
        }
    }
}
