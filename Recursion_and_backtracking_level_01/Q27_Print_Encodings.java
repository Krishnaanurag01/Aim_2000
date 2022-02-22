package Recursion_and_backtracking_level_01 ;
import java.util.*;
public class Q27_Print_Encodings {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        String s = sc.next() ;


        printEncodings(s,"") ;

        sc.close();
    }

    public static void printEncodings(String str, String psf) {
        
        if(str.length() == 0){
            System.out.println(psf) ;
        }

        int ch = str.charAt(0) - '0' ;

        if(ch == 0){
            return ;
        }
        else if(str.length() == 1){

            char fc = (char)('a' + ch - 1) ;
            String rest = str.substring(1) ;

            printEncodings(rest,psf+fc) ;
        }
        else{

            int bigFnum = Integer.parseInt(str.substring(0,2)) ;
            String rest = str.substring(2) ;

            if(bigFnum <= 26){
                char charIs = (char)( 'a'+bigFnum-1) ;
                printEncodings(rest,psf+charIs) ;
            }


        }
    }
}
