package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q9_Display_Array_reverse {
    
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        int[] arr = new int[n] ;

        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt() ;
        }

        displayArrReverse(arr,arr.length-1) ;

        sc.close();
    }

    // way 1 :
     
    public static void displayArrReverse(int[] arr, int idx) {
        if(idx < 0){
            return ;
        }

        System.out.println(arr[idx]) ;

        displayArrReverse(arr,idx - 1) ;

    }

    // way 2 :

    public static void displayArrReverse2(int[] arr, int idx) {
        if(idx == arr.length){
            return ;
        }

        displayArrReverse(arr,idx + 1) ;
        System.out.println(arr[idx]) ;


    }

}
