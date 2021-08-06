package Arrays;

import java.util.Stack;



public class PalindromicArray_Q39 {
    public static void main(String[] args) {

        int[] arr = {111,121,666};
        System.out.println(isPalindrome(arr, arr.length));
        
    }
    public static int isPalindrome(int[] arr , int n) {

        for (int i : arr) {

            // method -01

            // String number = String.valueOf(i);
            // char[] arrr = number.toCharArray();
            // int k =0 ;
            // int j = number.length()-1;
            // // while (k < j ) {
            // //     if(arrr[k] == arrr[j]){
            // //         k++;
            // //         j--;
            // //     }
            // //     else{
            // //         return 0 ;
            // //     }
                
            // // }


            // method -02 with   **************  less space complexicity  *********************

             String number = String.valueOf(i);
            int k =0 ;
            int j = number.length()-1;
            while (k < j ) {
                if(number.charAt(k) == number.charAt(j)){
                    k++;
                    j--;
                }
                else{
                    return 0 ;
                }
                
            }


        }
     return 1;   
    }
}
