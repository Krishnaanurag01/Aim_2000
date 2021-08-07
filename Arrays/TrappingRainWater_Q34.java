package Arrays;


public class TrappingRainWater_Q34 {
    public static void main(String[] args) {
        int[] arr = {7, 4 ,0 ,9} ;
        System.out.println(getTrappedWaterSize(arr, arr.length));
    }
    public static int getTrappedWaterSize(int[] arr, int n) {

       int[] leftMax = new int[n];
       int[] rightMax = new int[n];

       leftMax[0] = arr[0];
       
       for (int i = 1; i < n; i++) {
           leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }

        rightMax[n-1] = arr[n-1];

       for (int i = n-2 ; i >= 0 ; i--) {
        rightMax[i] = Math.max(arr[i], rightMax[i+1]);
       }

       int trappedWater  = 0;

       for (int i = 0; i < n; i++) {
           trappedWater += Math.min(leftMax[i],rightMax[i]) - arr[i];
           
       }
       return trappedWater;

    }
}
