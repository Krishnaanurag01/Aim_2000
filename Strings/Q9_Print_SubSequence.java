package Strings;

import java.util.Scanner;

public class Q9_Print_SubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printSS(str,"");
        sc.close();
    }
    public static void printSS(String ques , String ans) {
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char fc= ques.charAt(0);
        String s = ques.substring(1);

        printSS(s, ans+"");
        printSS(s, ans+fc);

    }
}
