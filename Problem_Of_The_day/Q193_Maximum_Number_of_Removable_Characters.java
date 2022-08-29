package Problem_Of_The_day;
import java.util.*;

public class Q193_Maximum_Number_of_Removable_Characters {

    public int maximumRemovals(String s, String p, int[] removable) {
        
        int low = 0 ;
        int high = removable.length - 1 ;
        
        while(low <= high){ // applying binary search on removable array.
            int mid = low + (high-low)/2 ; 
            if(isPossible(s,p,mid,removable)){ // checking can we make p if we remove char till mid index in remov..
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        
        return low ;
    }
    
    boolean isPossible(String s, String p, int mid, int[] removable){
        HashSet<Integer> alreadyRemovedIdx = new HashSet<>() ;
        for(int i = 0 ; i <= mid ; i++){
            alreadyRemovedIdx.add(removable[i]) ; // we are assuming that char till mid idx in remo.. are already removed from s string.
        }
        
        int pIdx = 0 ;
        for(int i = 0 ; i < s.length() && pIdx < p.length() ; i++){
            if(alreadyRemovedIdx.contains(i)) continue ; // means if the current idx is already removed then continue.
            if(p.charAt(pIdx) == s.charAt(i)) pIdx++ ;
        }
        
        return p.length() == pIdx ;
    }


    // method 02 : fastest!!

    
}
