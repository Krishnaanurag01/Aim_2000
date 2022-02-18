package Recursion_and_backtracking_level_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Q14_get_SubSequence {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;

        String s = sc.nextLine() ;

        ArrayList<String> list = getSubSec(s) ;

        System.out.println(list);
        sc.close();
    }

    private static ArrayList<String> getSubSec(String s) {

        if(s.length() == 0){

            ArrayList<String> ans = new ArrayList<>() ;
            ans.add("");
            return ans ;
        }

        char fc = s.charAt(0) ; // backing up first char
        String rest = s.substring(1) ; // rest string

        ArrayList<String> result = getSubSec(rest) ; // find subseq of rest string

        // now current char can be included or excluded with the rest string subseq

        ArrayList<String> newResult = new ArrayList<>() ;

        // when we exclude current first char in our subseq
        for (String str : result) {    
            newResult.add(""+str) ;
        }

        // when we include our first char in our subseq
        for (String str : result) {    
            newResult.add(fc+str) ;
        }

        return newResult;
    }
    
}
