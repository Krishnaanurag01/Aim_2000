package Bit_Manipulation;

import java.util.Scanner;

public class Q4_Josephus_Special {

    public static int solution(int n){
    
        int hp2 = getHp2(n) ; // getting the highest power of 2.
        int l = n - hp2 ; // and getting the rest of n after substracting the highest power. eg : n = 9 then hp2 = 2^3 and l = will be 1
        
        return 2*l + 1 ; // this is formula
      }
    
      // returning the highest power of 2.
      static int getHp2(int n){
        int i = 1 ;
        while( i * 2 <= n)
        {
          i = i * 2 ;
        }
        return i ;
      }
    
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
        scn.close();
      }
    
}
