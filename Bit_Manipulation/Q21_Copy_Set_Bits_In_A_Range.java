package Bit_Manipulation;

import java.util.Scanner;

public class Q21_Copy_Set_Bits_In_A_Range {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();
    
        // first creating mask of r-l+1 length
        int mask = ( 1 << (right - left + 1)) ;
        mask-- ; // subtracting 1 will give us desired length of mask consist of 1
    
        mask = a & ( mask << left - 1 ) ; // now shifting left-1 bits
    
        b  = b | mask ; // and copying the set bit
        
        System.out.println(b);
        scn.close();
      }
    
    
}
