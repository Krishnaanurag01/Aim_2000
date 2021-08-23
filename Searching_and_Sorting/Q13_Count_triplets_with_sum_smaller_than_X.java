package Searching_and_Sorting;

import java.util.Arrays;


public class Q13_Count_triplets_with_sum_smaller_than_X  {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 7};
        System.out.println(tripletsWithLessThan_X_Sum(arr, 12));
        System.out.println(GettripletsWithLessThan_X_Sum(arr, 12));
        
    }

    // used two sum problem. time comp : o(n2) and space is constant.
    public static int tripletsWithLessThan_X_Sum(int[] arr , int X) {
        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
                count+=twosum(i+1,arr,X,arr[i]);
            
        }


        return count;
    }
    private static int twosum(int i, int[] arr, int x,int firstValue) {

        int end = arr.length-1 ;
        int count = 0 ;

        while (i < end) {
            if(arr[i]+arr[end] + firstValue >= x){
              end--;
            }
            else{

                count +=end-i;
                i++;
            }
        }
        return count;
    }

    // same concept in iterative way and complexcity.

    public static long GettripletsWithLessThan_X_Sum(int[] arr , int sum ) {

        long count = 0 ;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-2; i++) {
            
            int j = i+1 , k = arr.length-1;

            while (j < k) {
                if(arr[i] + arr[j] + arr[k] >= sum){
                    k--;
                }
                else{
                    count += k - j ; // doing this will give all posible values i and j(this will vary only).
                    j++; // then searching again with next i .
                }
                
            }
        }
        return count;
        
    }
}
