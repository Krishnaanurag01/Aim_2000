package Bit_Manipulation;
import java.util.*;

public class Q24_Solve_7n_By_8 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       
        
        // (n << x) => n ^ (2^x)
        // (n << x) => n/2^x 

        // so converting 7n/8 => (8n-n)/8
        // 3 is power of => 2^3
       System.out.println( (( (n << 3 ) - n ) >> 3 ) ) ;

       scn.close();
      }
    
}
