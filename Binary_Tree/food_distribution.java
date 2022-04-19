package Binary_Tree;

import java.util.Scanner;

public class food_distribution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;

        int p = sc.nextInt() ;
        int q = sc.nextInt() ;

        helper(p,q) ;
        sc.close();
    }

    private static int helper(int p, int q) {

        if( p > q){
            return 0 ;
        }
        else if( p == q){
            return q ;
        }

        // int selfCount = q-1 ; 


        return 0 ;
    }
    
}
