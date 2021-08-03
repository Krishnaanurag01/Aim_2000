package Arrays;

import java.util.Arrays;

/**
 * TripletSum_Q33
 */
public class TripletSum_Q33 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45 ,6 ,10 ,8};
    }

    public static boolean existTriplets(int[] arr, int n) {

        int i = 0;
        int j = n-1;
        int answer = 0;
        Arrays.sort(arr);
        while (i < j) {
            if(arr[i]+arr[j] == n) return true;
            if(arr[i]+arr[j]< n){
                answer =arr[i]+arr[j];
                i++;
            }else{
                j--;
            }
        }
        
    }
}