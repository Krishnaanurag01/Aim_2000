package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q1_Abbreviation_Using_Backtracking {
    
    public static void solution(String str, String asf,int count, int pos){
        
        if(pos == str.length() ){ // when traversed all the char of str

            if(count == 0){ // check if count is zero then simply print he answer so far.
                System.out.println(asf) ;
            }
            else{ // else print asf + count.
                System.out.println(asf + count) ;
            }
            return ;
        }


        // if we include current char
        if(count> 0) // and count is greater then 0 then do following
        solution(str, asf + count + str.charAt(pos), 0, pos+1  ) ;
        else // when count is zero then do following
        solution(str, asf + str.charAt(pos), 0, pos+1  ) ;

        // if we exclude current char
        solution(str, asf , count + 1 , pos+1  ) ;

        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
        scn.close();
    }
    

}
