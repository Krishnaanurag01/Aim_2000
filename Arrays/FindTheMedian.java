package Arrays;

import java.util.Arrays;

public class FindTheMedian {
    public static void main(String[] args) {
        int[] arr = {56 , 67, 30 ,79};
        System.out.println(getMedian(arr, arr.length));
    }
    public static int getMedian(int[] arr , int n) {
        int medianIs = 0 ;

        Arrays.sort(arr);
        if(n % 2 != 0){
            // means array is of odd size.
            medianIs  = arr[n/2];

        }else{
            medianIs = (arr[n/2] + arr[n/2-1])/2;
        }


        return medianIs ;
    }
}
