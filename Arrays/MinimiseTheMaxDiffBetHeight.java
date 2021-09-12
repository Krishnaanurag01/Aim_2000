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
        int minEle , maxEle ;
        int result = arr[n-1] - arr[0];
        for (int i = 1; i <arr.length; i++) {
            if(arr[i]>=k){
                maxEle = Math.max(arr[i-1]+k, arr[n-1]-k);
                minEle = Math.min(arr[0]+k, arr[i]-k);
                result = Math.min(result,maxEle-minEle);
            }
        }
        return result;

    }
}