package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q10_max_of_an_array {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
 
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }
 
        System.out.println(maxOfArray(arr,0)) ;
        sc.close();
     }
 
     public static int maxOfArray(int[] arr, int idx){
 
         if(arr.length -1 == idx){ /// when reached the last element then return last element
             return arr[idx] ;
         }
 
         int msf = maxOfArray(arr,idx+1) ; // geting max so far of idx  + 1 elemens
 
         if(arr[idx] > msf){ // if current element is greater than max so far then return current element
             return arr[idx] ;
         }
 
         return msf; // else return max so far
     }

}
