package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q15_Get_Keypad_Combination {

    static HashMap<Integer,ArrayList<Character>> map ;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;
        String n = sc.nextLine() ;

        map = new HashMap<>() ;

        for(int i = 0 ; i <= 9 ; i++){
            map.put(i, new ArrayList<Character>()) ;
        }

        map.get(0).add('.'); 
        map.get(0).add(';');

        map.get(1).add('a'); 
        map.get(1).add('b'); 
        map.get(1).add('c');

        map.get(2).add('d'); 
        map.get(2).add('e'); 
        map.get(2).add('f');

        map.get(3).add('g'); 
        map.get(3).add('h'); 
        map.get(3).add('i');

        map.get(4).add('j'); 
        map.get(4).add('k'); 
        map.get(4).add('l');

        map.get(5).add('m'); 
        map.get(5).add('n'); 
        map.get(5).add('o');

        map.get(6).add('p'); 
        map.get(6).add('q'); 
        map.get(6).add('r'); 
        map.get(6).add('s');

        map.get(7).add('t'); 
        map.get(7).add('u');

        map.get(8).add('v'); 
        map.get(8).add('w'); 
        map.get(8).add('x');

        map.get(9).add('y'); 
        map.get(9).add('z'); 

        sc.close();

        printKPC(n,"") ;

        System.out.println( printKPC2(n,"") );
    }

    // method 01 : directly printing,

    public static void printKPC(String str, String asf) {
        
        if(str.length() == 0){ // base case
            System.out.println(asf) ;
            return ;
        }

        char fc = str.charAt(0) ; // backing up the first char
        String rest = str.substring(1) ; // extracting rest char

        for(int i = 0 ; i < map.get(fc-'0').size() ; i++){

            // now getting every char correspond to first char (fc)
            
            char ch = map.get(fc-'0').get(i) ;
            printKPC(rest,asf + ch ); // now finding nex char of next number
        }

    }    

    // method - 02 : returning the arraylist

    public static ArrayList<String> printKPC2(String str, String asf) {
        
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>() ;
            ans.add(asf) ;
            return ans ;
        }

        char fc = str.charAt(0) ;
        String rest = str.substring(1) ;
        ArrayList<String> New_ans = new ArrayList<>() ;

        for(int i = 0 ; i < map.get(fc-'0').size() ; i++){

            char ch = map.get(fc-'0').get(i) ;
            
            ArrayList<String> oldData = printKPC2(rest,asf + ch );

            for (String string : oldData) {
                New_ans.add(string) ;
            }
        }

        return New_ans ;
    }
}
