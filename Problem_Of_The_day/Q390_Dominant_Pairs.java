package Problem_Of_The_day;
import java.util.*;

public class Q390_Dominant_Pairs {

    public static int dominantPairs(int n, int[] arr) {
        int[] sh = new int[n/2] ;
        
        for(int i = n/2 ; i < n ; i++){
            sh[i-n/2] = arr[i]*5 ;
        }
        
        Arrays.sort(sh) ;
        int count = 0 ;
        
        for(int i = 0 ; i < n/2 ; i++){
            int val = arr[i] ;
            int l = 0 ;
            int r = n/2 -1 ;
            
            while(l <= r){
                int mid = l + ( r - l)/2 ;
                if(sh[mid] <= val){
                    l = mid + 1 ;
                }
                else{
                    r = mid - 1 ;
                }
            }
            
           count += l ;
         }
         
         
         return count ;
    }
}
