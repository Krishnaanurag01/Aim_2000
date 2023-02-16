package Problem_Of_The_day;
import java.util.*;

public class Q361_Good_Stones {
    public static int goodStones(int n, int[] arr) {
        HashSet<Integer> bad_ones = new HashSet<>() ; // storing the bad ones that form loop so that we won't get stuck in the loop
        
        for(int i = 0 ; i < arr.length ; i++){
            if(bad_ones.contains(i)) continue ;
            HashSet<Integer> visited = new HashSet<>() ;
            // if current is not visited before then try this
            if(formLoop(i,arr,visited, bad_ones)){ // if form when processing
             bad_ones.addAll(visited) ;   // then add all the visited node that are making loop in bad ones
            }
        }
        
        return n - bad_ones.size() ;
    }
    
    static boolean formLoop(int idx, int[] arr, HashSet<Integer> visited, HashSet<Integer> bad_ones){
        
        if(idx >= arr.length || idx < 0) return false ; // if out of bound means no loop
        if(visited.contains(idx) || bad_ones.contains(idx)) return true ; // if already visited or is in badones then forms loop
        visited.add(idx) ;
        if(formLoop(arr[idx] + idx , arr, visited, bad_ones)) return true ; // going to next .
        return false;
    }
}
