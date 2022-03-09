package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q6_Zero_Sum_Subarrays {

    // same as Q5
    public static long findSubarray(long[] arr ,int n)
    {
        //Your code here
        HashMap<Long,Integer> map = new HashMap<>() ;
        
        map.put((long)0,1) ; // storing sum 0 with count 1 initially
        
        long sum = 0 ;
        long count = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            sum += arr[i] ; 
            
            // checking if current sum is already present or not
            if(map.containsKey(sum)){ // when yes
                int freq = map.get(sum) ; // get the frequency
                
                count+= freq ; // and add to count becuase all the index where this sum is created while make a sub array till now that has sum is 0 
                // and storing current sum with +1 count for current sum
                map.put(sum,freq+1) ;
            }
            else{ // else add it
                map.put(sum,1) ;
            }
        }
        return count ;
    }
    
}
