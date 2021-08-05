package Arrays;

import java.util.Arrays;

/**
 * TripletSum_Q33
 */
public class TripletSum_Q33 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45 ,6 ,10 ,8};
        System.out.println(existTriplets(arr, arr.length , 52));
    }

    public static boolean existTriplets(int[] arr, int n, int x) {

        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++) {
            if(twoSumAlgo(arr, x-arr[i] , i+1)){
                return true;
            }
        }
        return false;

        
    }

    public static boolean twoSumAlgo(int[] arr , int sum , int i) {
        int j = arr.length-1;
        while (i<j) {

            if(arr[i]+arr[j] < sum){
                i++;
            }
            else if(arr[i]+arr[j]> sum){
            j--;
            }
            else{
                return true;
            }
            
        }
        return false;
        
    }
}