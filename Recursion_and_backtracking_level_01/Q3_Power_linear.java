package Recursion_and_backtracking_level_01 ;
import java.util.*;

public class Q3_Power_linear {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int x = sc.nextInt() ;
        int n = sc.nextInt() ;

        System.out.println( power(x,n) ) ;
        sc.close();
    }

    // time comp : O(n)
    public static int power(int x, int n){

        if( n == 0){
            return 1;
        }

        return x*power(x,n-1);
    }


}