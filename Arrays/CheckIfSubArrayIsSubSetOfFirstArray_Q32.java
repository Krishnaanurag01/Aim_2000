package Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CheckIfSubArrayIsSubSetOfFirstArray_Q32 {
    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2,9, 4};
        System.out.println(isSubset(arr1, arr2, arr1.length, arr2.length));
        System.out.println(isSubsetOfArrayOne(arr1, arr2,  arr1.length, arr2.length));
    }

    public static boolean isSubset(int[] arr1 ,int[] arr2 , int n , int m) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr1[i],1);
        }

        boolean isSubset = true;

        for (int i = 0; i < m; i++) {
            if (!map.containsKey(arr2[i])) {
                isSubset = false;
            }            
        }
        
        
        return isSubset;
        
    }

    // using HashSet: o(n) complexicity

    public static boolean isSubsetOfArrayOne(int[] arr1 ,int[] arr2 , int n , int m) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }

        boolean isSubset = true;

        for (int i = 0; i < m; i++) {
            if (!set.contains(arr2[i])) {
                isSubset = false;
            }            
        }
        
        
        return isSubset;
    }

}
