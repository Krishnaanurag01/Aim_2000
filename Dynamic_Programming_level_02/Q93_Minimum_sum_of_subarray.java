package Dynamic_Programming_level_02;

public class Q93_Minimum_sum_of_subarray {


    public static void main(String[] args) {
        
        int arr[] = {3, -4, 2, -3, -1, 7, -5} ;

        minSubArray(arr);
    }

    // Opposite of kadane's algo.

    public static void minSubArray(int[] arr) {
        
        int smallestAns = arr[0] ;
        int cSum = arr[0] ;

        for (int i = 1 ; i < arr.length; i++) {
            cSum += arr[i] ;

            if(cSum > arr[i]){
                cSum = arr[i] ;
            }

            smallestAns = Math.min(smallestAns, cSum) ;
        }

        System.out.println( smallestAns );

    }
    
}
