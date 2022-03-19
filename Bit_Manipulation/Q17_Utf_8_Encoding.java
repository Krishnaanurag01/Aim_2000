package Bit_Manipulation;

import java.util.Scanner;

public class Q17_Utf_8_Encoding {

    
    public static boolean solution(int[] arr) {
        //write your code here

        int remaining = 0 ;

        for(int val : arr){

            if(remaining == 0){

                if( (val >> 7) == 0b0 ){ // 1st byte 1 length char
                    
                    remaining = 0 ; // because it is a single character
                }
                else if( (val >> 5) == 0b110 ){// 1st byte 2 length char

                    remaining = 1 ; 
                }
                else if( (val >> 4) == 0b1110 ){ // 1st byte 3 length char
                    remaining = 2 ;
                }
                else if( (val >> 3) == 0b11110 ){ //// 1st byte 4 length char
                    remaining = 3 ;
                }

            }
            else{

                // when remaining element required. 
                // as question asked that rest elements should start with 10 so checking below
                if( (val >> 6) == 0b10 ){
                    remaining-- ;
                }
                else{
                    return false ;
                }

            }
        }

// remaining element are left but we don't have any element.
        if(remaining > 0){
            return false ;
        }
        
        return true;
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
        scn.close();
    }
    
}
