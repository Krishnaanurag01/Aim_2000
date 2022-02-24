package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q26_Words_K_Selection_1 {

    
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    // using hashset for removing duplicacy
    HashSet<Character> unique = new HashSet<>();
    String ustr = ""; // this will contain the redundant string
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    // now the problem is nothing but a normal combination problem
    combination(0, ustr, 0, k, "");

    scn.close();
  }


  public static void combination(int i, String ustr, int ssf, int ts, String asf ) {

    if( i == ustr.length() ){
      if(ssf == ts){
        System.out.println(asf);
      }
      return ;
    }

    combination(i+1,ustr,ssf+1,ts,asf+(ustr.charAt(i)));
    combination(i+1,ustr,ssf,ts,asf);

  }

    
}
