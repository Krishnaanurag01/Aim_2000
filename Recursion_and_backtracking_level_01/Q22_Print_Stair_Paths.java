package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q22_Print_Stair_Paths {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        printStairPaths(n,"") ; /// by default path is ""

        sc.close();
    }

    public static void printStairPaths(int n, String path) {

        if ( n < 0){ // if we have been sent out of bound then simply return
            return ;
        }

        if(n == 0){ // if we reach the 0 then print the path
            System.out.println(path);
            return ;
        }

        printStairPaths(n-1,path+ "1") ; // check with 1 step
        printStairPaths(n-2,path+ "2") ; // check with 2 step
        printStairPaths(n-3,path+ "3") ; // check with 3 step

    }

    
}
