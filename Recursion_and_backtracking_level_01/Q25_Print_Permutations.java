package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q25_Print_Permutations {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in) ;

        String s = sc.nextLine() ;

        printPermutations(s,"") ;

        sc.close();
    }

    public static void printPermutations(String str, String asf) {
        
        if(str.length() == 0){
            System.out.println(asf) ;
            return ;
        }

        // take every character as first character once and extract rest of the string.
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i) ;
            String rest = str.substring(0,i) + str.substring(i+1) ;
            printPermutations(rest,asf+ch) ;
        }
    }
    
}
