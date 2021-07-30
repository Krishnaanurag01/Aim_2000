package Arrays;

import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr= { 1, 20, 6, 4, 5};
        System.out.println(getInversionCount(arr,0,arr.length-1));
        
    }

    // using bubble sort  - o(n2) time complexicity which is not good.

    // public static int getInversionCount(int[] arr) {
    //     int i = 0;
    //     int count = 0;
    //     for (int j = 0; j < arr.length-1; j++) {
    //         boolean isSwapped = false;
    //         for (int j2 = 0; j2 < arr.length-1-j; j2++) {
    //             if(arr[j2] < arr[j2-1]){
    //                 int temp = arr[j2];
    //                 arr[j2] = arr[j2-1];
    //                 arr[j2-1] = temp;
    //                 count++;
    //                 isSwapped = true;
    //             }
    //         }
    //         if (isSwapped == false) {
    //             break;
    //         }
            
    //     }
        
    //     return count;
        
    // }

    public static int getInversionCount(int[] arr ,int low , int high) {
        int count = 0 ;
        if(low < high){

            int mid = (low + high)/2;
            count+=getInversionCount(arr,low,mid);
            count+=getInversionCount(arr,mid+1,high);
            count+=merge(arr, low , mid , high);
        }
        
        
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low , mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
        
        // i is for left array.
        int i = 0 ;
        // j is for right array.
        int j = 0 ;
        // k is for original array.
        int k = low;
        int swap = 0;

        while (i<left.length && j< right.length) {
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                swap += (mid+1)-(1+i); 
            }
        }
        while (i<left.length) {
            arr[k++] = left[i++];
        }
        while (j<right.length) {
            arr[k++] = right[j++];
        }
            
        
        return swap;
    }

    
}
