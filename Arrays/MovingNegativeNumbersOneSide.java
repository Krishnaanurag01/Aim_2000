package Arrays;

import java.util.Arrays;

public class MovingNegativeNumbersOneSide {
    public static void main(String[] args) {
        int[] arr= {-8 ,9 ,5 ,10, 2, 6, -7, 7};
        // movingNegative(arr);
        without_changing_order(arr);
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }

        
    }
    // public static void movingNegative(int[] arr ) {
    //     int l = 0;
    //     int temp;
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i]<0){
    //             temp = arr[l];
    //             arr[l]=arr[i];
    //             arr[i] = temp;
    //             l++;               
    //         }

    //     }
        
    // }


    public static void without_changing_order(int[] arr) {
        
        int end = arr.length-1 ;
        int temp ;
        int[] tempArr = new int[arr.length]; 
        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] < 0 ){
                tempArr[end] = arr[i];
                end--;
            }
            else{
                tempArr[j]= arr[i];
                j++;
            }
            
        }

        arr = Arrays.copyOfRange(tempArr,0,arr.length);
        for (int i : arr) {
            System.out.print(i+" ");
            
        }
    }
    
}
