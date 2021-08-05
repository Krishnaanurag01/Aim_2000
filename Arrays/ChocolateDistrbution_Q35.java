package Arrays;

import java.util.Arrays;

public class ChocolateDistrbution_Q35 {
 public static void main(String[] args) {
     int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
     System.out.println(getMinimunDiffBetweenMaxAndMinPackets(arr, 5, 8));

 }   
 public static int getMinimunDiffBetweenMaxAndMinPackets(int[] arr, int students , int n) {

    Arrays.sort(arr);
    int minDifferenceIs = Integer.MAX_VALUE;
    for (int i = 0; i+students-1 < n ; i++) {
        minDifferenceIs  = Math.min(arr[i+students-1]-arr[i], minDifferenceIs);
        
    }
     return minDifferenceIs;
 }
}
