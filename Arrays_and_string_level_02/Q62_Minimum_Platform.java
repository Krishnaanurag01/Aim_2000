package Arrays_and_string_level_02;
import java.util.*;

public class Q62_Minimum_Platform {


    static int findPlatform(int arr[], int dep[], int n)
    {
     
        Arrays.sort(arr) ; // sorting the trains on starting time.
        Arrays.sort(dep) ; // and also sorting the dept time of trains.
        
        int cp = 1 ; // took current platform is 1.
        int max_pl = 1 ; // max platform
        
        int i = 1 ;// starting from 1 as we took cp 1 means 0th train is already standing on 1 platform.
        int j = 0 ;// this denotes the depart index of trains.
        
        while(i < n){
            // arrival time is greater than depart time of j then it means train i will arrive after depart of j train so departing and as we depart so we have left space of 1 platform so decrementing.
            if( j < i && arr[i] > dep[j]){
                cp-- ;
                j++; // moving to next depart of train
            }
            
            cp++ ; // and one train arrives so increasing the platform
            i++ ;
            // updating max platform.
            max_pl = Math.max(cp,max_pl) ;
            
            
        }
        
        return max_pl ;
    }
    
}
