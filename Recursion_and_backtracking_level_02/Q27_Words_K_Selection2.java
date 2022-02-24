package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q27_Words_K_Selection2 {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in) ;
        String s = sc.nextLine() ;
        int k = sc.nextInt() ;

        // extracting the redundant string
        HashSet<Character> set = new HashSet<>() ;
        String nstr = "" ;
    
        for(int i = 0 ; i < s.length() ; i++){
          char ch = s.charAt(i) ;
          if(!set.contains(ch)){
            nstr += ch ;
            set.add(ch) ;
          }
        }
    
        helper(1,nstr, k, -1 ,"");
        sc.close();
      }

      /*
      cs -> current selection so far
      ts -> total selection 
      ls -> last selected
      asf -> answer so far
      */
     
      static void helper(int cs , String s , int ts , int ls, String asf){
    
        if(cs > ts){
          System.out.println(asf);
          return ;
        }
    
        // adding new char after the selection of previous char
        for(int i = ls + 1 ; i < s.length() ; i++){
          helper(cs+1,s,ts,i,asf+(s.charAt(i))) ;
        }
    
      }
    
}
