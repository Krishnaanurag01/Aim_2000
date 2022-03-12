package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q39_Check_Arithmetic_Progression {

    boolean checkIsAP(int arr[] ,int n)
    {
        if(n <= 1){
            return true ;
        }
        
        HashSet<Integer> set = new HashSet<>() ;
        
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        
        for(int i : arr){
            min = Math.min(min,i) ;
            max = Math.max(max,i) ;
            set.add(i) ;
        }
        
        
        // ap => ai + 0*d + ai + 1*d ....
        
        int d = (max-min)/(n-1) ; // finding the avg distance between each element
        
        for(int i = 0 ; i < n ; i++){
            int ai =  min +  i*d ;
            
            if( !set.contains(ai) ){
                return false ;
            }
        }
        
        return true ;
    }
    
}
