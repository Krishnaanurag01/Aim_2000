package Bit_Manipulation;
import java.util.*;

public class Q2_Print_Value_Of_Rsb_Mask {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        // formula to find the right most set bit is : (n & 2's comp of n) 
        // or we can also use  ( n & -n ) becuase -n is nothing but 2's complement of n
    
        int result = n & -n ;
    
        System.out.println(Integer.toBinaryString(result)); // converting to binary
        scn.close();
      }
    
}
