package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q19_print_subsequence {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;

        String s = sc.nextLine() ;

        printSubsquence(s,"") ;

        sc.close();
    }

    private static void printSubsquence(String s, String ns) {

        if(s.length() == 0){
            System.out.println(ns);
            return ;
        }

        String rest = s.substring(1) ;
        printSubsquence(rest,ns+"");
        printSubsquence(rest, s.charAt(0) + ns);
    }
    
}
