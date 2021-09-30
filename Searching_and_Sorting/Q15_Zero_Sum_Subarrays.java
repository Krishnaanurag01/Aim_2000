package Searching_and_Sorting;

import java.util.HashMap;


public class Q15_Zero_Sum_Subarrays {
    public static void main(String[] args) {
        int arr[] = {0,0,5,5,0,0};

        System.out.println(getZeroSumSubarray(arr));
    }
    public static int getZeroSumSubarray(int[] arr) {
       int i = 0;
       HashMap<Integer,Integer> map = new HashMap<>() ; 
       map.put(0, 1);

       int sum = 0;
       int ans= 0 ;

       while (i <= arr.length-1) {
        //    i++;
           sum+= arr[i];

           if(map.containsKey(sum)){
               ans += map.get(sum);
               map.put(sum, map.get(sum)+1);
           }
           else{
               map.put(sum, 1);
           }
           i++;
       }
     return ans;
    }

}
