package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q12_Last_Index {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }

        int x = sc.nextInt() ;


        System.out.println(lastIndex(arr,0,x)) ;

        sc.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){

        if(idx == arr.length){ // when out of bound return -1
            return -1 ;
        }

        int in = lastIndex(arr,idx+1,x) ; // check in idx + 1 to n 

        if(in != -1){ // if it is not -1 then it surely contain the index of x so return in
            return in ;
        }

        if(arr[idx] == x){ // else if current element is x and in is -1 so return current idx
            return idx ;
        }

        return -1; // else -1 means not found
    }
    
}
