package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q8_Display_Array {
    
    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        int[] arr = new int[n] ;

        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt() ;
        }

        displayArr(arr,0) ;

        sc.close();

    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return  ;
        }

        System.out.println(arr[idx]) ;
        displayArr(arr,idx+1) ;
    }



}
