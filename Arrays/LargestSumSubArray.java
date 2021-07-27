package Arrays;

import java.util.Arrays;

public class LargestSumSubArray {
    public static void main(String args[]){
        int[] arr = {-2,-1,5,4,6,-4,9};
        System.out.println(maxSoFar(arr));
        

    }
    public static int maxSoFar(int[] arr) {
        int currentMax = arr[0];
        int maxsofar= arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax+=arr[i];
            if(currentMax<arr[i]){
                currentMax = arr[i];
            }
            if(maxsofar<currentMax){
                maxsofar= currentMax;
            }
        }
        return maxsofar;
        
        
    }
    
}
