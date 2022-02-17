package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q4_Power_logarithmic {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;
        int x = sc.nextInt() ;
        int n = sc.nextInt() ;

        System.out.println(power(x,n)) ;
        sc.close();
    }

    // time complexity -> log(n)
    public static int power(int x, int n){

        if(n == 0){ 
            return 1 ;
        }

        int cal = power(x,n/2) ; // calculating for n/2 power 
        // product
        int pro = cal*cal ; // n = n/2 * n/2

        if(n % 2 == 1){ // when odd -> multiply once with x 
            pro = pro * x ;
        }

        return pro;
    }
    
}
