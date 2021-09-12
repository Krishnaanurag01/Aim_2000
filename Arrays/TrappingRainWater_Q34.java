package Arrays;


public class TrappingRainWater_Q34 {
    public static void main(String[] args) {
        int[] arr = {7, 4 ,0 ,9} ;
        System.out.println(getTrappedWaterSize(arr, arr.length));
    }
    public static int getTrappedWaterSize(int[] arr, int n) {

       int[] leftMax = new int[n];
       int[] rightMax = new int[n];

       leftMax[0] = arr[0]; // storing the first value of array.
       
       for (int i = 1; i < n; i++) { // now store max in left[i] check if arr[i] is max of left[i-1] is max and store it.
           leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }

        rightMax[n-1] = arr[n-1];  // storing the last value  of array.

       for (int i = n-2 ; i >= 0 ; i--) { // store right max.
        rightMax[i] = Math.max(arr[i], rightMax[i+1]);
       }

       int trappedWater  = 0;

       for (int i = 0; i < n; i++) {
           trappedWater += Math.min(leftMax[i],rightMax[i]) - arr[i]; // get the min value in left or right and then minus with arr[i] that will be trapped water.
           
       }
       return trappedWater;

    }
}
