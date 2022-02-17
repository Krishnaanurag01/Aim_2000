package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q6_Print_Zigzag {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
 
        pzz(n) ;
        sc.close();
     }
 
     public static void pzz(int n){
         
         if( n == 0 )
         return ;
 
         System.out.print(n +" ") ;
         pzz(n-1) ;
         System.out.print(n +" ") ;
         pzz(n-1) ;
         System.out.print(n+" ") ;
     }

}
