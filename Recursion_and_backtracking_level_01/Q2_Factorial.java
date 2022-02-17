package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q2_Factorial {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        sc.close(); 
        
       System.out.println( factorial(n) ) ;
     }
 
     public static int factorial(int n){
         
         if(n == 0){
             return 1 ;
         }
         
         return n*factorial(n-1);
 
     }

}
