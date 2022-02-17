package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q7_Tower_Of_Hanoi {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        int disks = sc.nextInt() ;
        int t1 = sc.nextInt() ;
        int t2 = sc.nextInt() ;
        int t3 = sc.nextInt() ;

        toh(disks,t1,t2,t3) ;
        sc.close();

    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        
        if(n == 0){
            return ;
        }

        toh(n-1, t1id , t3id , t2id) ; // moving n-1 disk from tower 1 to tower 3 with the help of tower 2
        System.out.println( n + "[" + t1id + " -> " + t2id + "]") ; // now moving the largest disk to tower 2(destination)
        toh(n-1, t3id , t2id , t1id) ; // now moving disk from tower 3 to tower 2.
    }



    // gfg solution  :

    public long toh2(int N, int from, int to, int aux) {
        
        // long move = 0 ;
        
        helper(N, from , to , aux) ;
        
        return (long)Math.pow(2,N)-1 ;
    }
    
    void helper(int n , int t1 ,  int t3 , int t2){
        
        if(n == 0){
            return ;
        }
        
        
        helper(n-1,t1,t2,t3) ;
        System.out.println("move disk " + n + " from rod "+ t1 + " to rod " + t3 ) ;
        helper(n-1,t2,t3,t1) ;
        
    }
    
}
