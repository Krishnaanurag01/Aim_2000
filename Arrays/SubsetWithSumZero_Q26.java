package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SubsetWithSumZero_Q26 {
    public static void main(String[] args) {
    int[] arr= {4,2,-3,1,6};    
    System.out.print(containSumZero(arr, arr.length));

    // don't use this as it's not efficiet.
    System.out.println(containsZero(arr, arr.length));
    }


    public static boolean containSumZero(int[] arr , int n) {
        // o(n) complexicity.
       int sum = 0 ;
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i < n; i++) {
           set.add(sum);
           sum+= arr[i];
           if(set.contains(sum)) return true;
       }
       return false;
    }

    // brute force : o(n2)

    public static boolean containsZero(int[] arr , int n) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+= arr[j];
                if(sum == 0) return true;
            }
            
        }
        return false;
    }


}
