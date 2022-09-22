package Contests;
import java.util.*;

public class Q4_Water_Problem {

    public int minCapacity(int a[], int n){
        
        long low = 0 ; // capacity
        long high = 0 ;
        for(int val : a) high = Math.max(high,val) ;
        
        Arrays.sort(a) ; // sorting because we will transfer water from smaller tank first and at the mean time the leakage will reduce the bigger tank capacity
        long ans = 0 ;
        while(low <= high){
            long mid = low + (high - low)/2 ;
            
            if(isPossible(mid,a)){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        
        return (int)ans ;
    }
    
    boolean isPossible(long cap, int[] a){
        
        int leaked = 0 ;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] - leaked > cap) return false ;
            leaked++ ;
        }
        return true;
    }
}
