package Problem_Of_The_day;
import java.util.*;

public class Q250_Maximize_the_sum_of_selected_numbers_from_an_array_to_make_it_empty {

    public static int maximizeSum (int arr[], int n) {
        TreeMap<Integer,Integer> map = new TreeMap<>( Collections.reverseOrder() ) ;
        
        for(int val : arr){
            map.put(val, map.getOrDefault(val,0) + 1) ;
        }
        
        int ans = 0 ;
        
        while(map.size() > 0){
            
            // taking the largest element.
            int top = map.firstKey() ;
            int top_freq = map.get(top) ;
            
            ans += top ; //adding to answer.
            
            // now remove one freq of largest element.
            if(top_freq == 1) map.remove(top) ;
            else map.put(top, top_freq - 1) ;
            
            // and also removing 1 freq of largest - 1 element.
            if(map.containsKey(top - 1)){
                int lesser = top - 1 ;
                int freq = map.get(lesser) ;
                if(freq == 1) map.remove(lesser) ;
                else map.put(lesser, freq - 1) ;
            }
        }
        
        return ans ;
    }

    // method 02 : 

    public static int maximizeSum2(int arr[], int n) {
        int max = -1;
         for(int i = 0; i < n; i++) {
             max = Math.max(max, arr[i]);
         }
           
         int []freq = new int[max + 1];
           
         for(int i = 0; i < n; i++) {
             freq[arr[i]]++;
         }
           
         int ans = 0, i=max;
          
         while(i>0) {
             if (freq[i] > 0){
                 ans += i;
                 freq[i-1]--;
                 freq[i]--;
             } else{               
                 i--;
             }           
         }
          
         return ans;
     }
}
