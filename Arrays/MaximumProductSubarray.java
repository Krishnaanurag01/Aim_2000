package Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr={3,12 ,15, 23, 33, -35, 30, -40, -30, -30, -30, 26, 28};
        System.out.println(getMaxSubArray(arr, arr.length));
    }
    // Brute force : o(n2)
    // public static int getMaxSubArray(int[] arr, int n) {
    //     int currentMax = 0;
    //     int maxSum=0;
    //     for (int i = 0; i < n; i++) {
    //         currentMax = arr[i];
    //         for (int j = i+1; j < n; j++) {
    //             currentMax = currentMax*arr[j];   
    //             if(maxSum< currentMax){
    //                 maxSum = currentMax;
    //             }
    //         }
    //     }
        
    //     return maxSum;
    // }


    // modified kadane's algo with 0(n) complexicity.
    public static int getMaxSubArray(int[] arr , int n) {
        
        int currentMax =1;
        int currentMin =1;
        int maxSoFar =0;
        int flag = 0;
        
        // if(n==1)return maxSoFar;
        for (int i = 0 ; i < n; i++) {
            if(arr[i]>0){
                currentMax *= arr[i];
                currentMin  = Math.min(currentMin*arr[i], 1);
                flag = 1;
            }
            else if(arr[i] == 0){
                currentMax = currentMin = 1;
            }
            else{
                int temp = currentMax;
                currentMax  = Math.max(currentMin*arr[i], 1);
                currentMin = temp*arr[i];
            }

            if(maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
            if (flag == 0 && maxSoFar == 0)
            return 0;
        }
        
        
        return maxSoFar;
        
    }
}
