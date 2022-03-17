package Bit_Manipulation;
import java.util.*;

public class Q1_Basics_Of_Bit_Manipulation {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();
    
        int setMask = (1 << i) ; // creating mask for setting bit
        int unsetMask = ~(1 << j) ; // creating mask for unsetting bit
        int toggleMask = (1 << k) ; // creating mask for toggling
        int checkMask = ( 1 << m) ; //and for checking
    
        System.out.println( n | setMask ); // using or for set operation
        System.out.println( n & unsetMask ); // and for unset
        System.out.println( n ^ toggleMask ); // xor for toggling
        System.out.println( (n & checkMask) == 0 ? "false" : "true"); // and for checking

        scn.close();
      }
    
}
