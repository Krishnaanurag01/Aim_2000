package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q58_Tricky_Sorting_Cost {

    static int sortingCost(int N, int arr[]){
        // code here
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        
        int maxC = 1 ; //maxConsecutive
        
        // finding the max consecutive element. this max consecutive element need not to be swapped so find maxC and rest of the element will take 1 step to sorted.
        
        for(int i : arr){
            
            map.put(i, map.getOrDefault(i-1,0)+1) ; // checking if i-1 exist, if yes then add 1(for current i) + i-1 freq gives = total consecutive element
            maxC = Math.max(maxC,map.get(i)) ;
        }
        
        return N-maxC ; // returning the rest of element as all of them will take 1 step each to be sorted.
    }
    
}
