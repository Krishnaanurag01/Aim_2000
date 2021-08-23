package Searching_and_Sorting;

import java.util.HashMap;

import org.graalvm.compiler.hotspot.nodes.aot.InitializeKlassNode;

public class Q14_Zero_Sum_Subarrays {
    public static void main(String[] args) {
        
    }
    public static int getZeroSumSubarray(int[] arr) {
       int i = -1;
       HashMap<Integer,Integer> map = new HashMap<>() ; 
       map.put(0, 1);

       int sum = 0;
       int ans= 0 ;

       while (i < arr.length-1) {
           i++;
           sum+= arr[i];

           if(map.containsKey(sum)){
               ans += map.get(sum);
               map.put(sum, map.get(sum)+1);
           }
           else{
               map.put(sum, 1);
           }
       }
     return ans;
    }

}
