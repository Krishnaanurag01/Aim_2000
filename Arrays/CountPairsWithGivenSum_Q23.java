package Arrays;

import java.util.Arrays;

public class CountPairsWithGivenSum_Q23 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,4};
        System.out.println(getCountOfPairs(arr,7));
    }
    public static int getCountOfPairs(int[] arr, int k) {
        int i = 0;
        int j = arr.length-1;
        int count = 0;
        Arrays.sort(arr); 
        while (i<j) {
            if(arr[i] + arr[j] > k){
                j--;
            }
            else if(arr[i] + arr[j] < k){
                i++;
            }
            if(arr[i]+ arr[j] == k)
            {
                count++;
                continue;
            }

            }
        return count;
    }
}
