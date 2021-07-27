package Arrays;

import java.util.Arrays;

/**
 * MinimiseTheMaxDiffBetHeight
 */
public class MinimiseTheMaxDiffBetHeight {

    public static void main(String[] args) {
        int[] numbers = {1,5,9,1,2,6,7,1,9,10};
        System.out.println(maxHeightDifference(numbers, numbers.length, 5));
        
    }
    public static int maxHeightDifference(int[] arr , int n , int k) {

        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0 ; i< n ; i++){
            if(arr[i]-k <= 0 ){
                arr[i] +=k;
            }
            else{
                arr[i] -=k;
            }
        }
        // Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        int answer = 0;
        answer = arr[n-1] - arr[0];
        return answer;
    }
}