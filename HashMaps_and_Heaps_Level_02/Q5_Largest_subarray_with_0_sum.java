package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q5_Largest_subarray_with_0_sum {


    int maxLen(int arr[], int n)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0,-1) ; // storing  0 as sum with index -1
       int sum = 0 ;
       int ans = 0 ;
       for(int i = 0 ; i < n ; i++){
           sum += arr[i] ;
           
           if(map.containsKey(sum)){ // checking if this sum came before if yes then it means all the element inbetween the previous index and current index making 0. so calculating length and updating ans if new length is larger
               int idx = map.get(sum) ;
               ans = Math.max(ans,i - idx) ;
           } 
           else{ // else directly store in hashmap with key as sum and i as index
               map.put(sum,i) ;
           }
       }
       
       return ans ;
    }
    
}
