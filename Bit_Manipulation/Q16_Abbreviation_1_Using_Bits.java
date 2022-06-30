package Bit_Manipulation;

import java.util.Scanner;

public class Q16_Abbreviation_1_Using_Bits {

    public static void solve(String str){
       
        for(int i = 0 ; i < ( 1 << str.length() ) ; i++){ /// running for all the numbers of bit of size str.length for str.size = 3 it will run for 000 to 111
 
            StringBuilder sb = new StringBuilder() ;
            int count = 0 ;

            for(int j = 0 ; j < str.length() ; j++){
 
                int bit = str.length() - 1 - j ; // getting last bit of i for first char of str. and so on.
 
                char ch = str.charAt(j) ;

                // checking if bit(defined above) is on or off.
 
                if( (i & 1 << bit) == 0 ){ // if current bit is zero then add the count if > 0 and char.
 
                if(count > 0){
                    sb.append(count) ;
                    sb.append(ch) ;
                    count = 0 ; // and initializing
                }
                else{
                    sb.append(ch) ; // else directly add it.
                }
 
                }
                else{ // if current bit is 1 then don't add char instead increase the count.
                count++ ;
                }
            }
 
            if(count > 0 ) // if count is greater than 3 then directly add the count as there are no characters left.
            sb.append(count) ;
 
 
            System.out.println(sb); // printing the abbreviation.
        }
     }
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         String str = scn.nextLine();
         solve(str);
         scn.close();
     }
    
}
