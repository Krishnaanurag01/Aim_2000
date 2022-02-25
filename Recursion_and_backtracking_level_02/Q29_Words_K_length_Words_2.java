package Recursion_and_backtracking_level_02;
import java.util.*;
import java.io.*;

public class Q29_Words_K_length_Words_2 {

    
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

   helper(1,ustr, 0 , k ,"", new HashSet<Character>() );
  }

  static void helper(int ci , String s ,int ssf,  int k ,String asf, HashSet<Character> set){

    if(ci > k){
      System.out.println(asf);
      return ;
    }

    for(int i = 0 ; i < s.length() ; i++){
      char cc = s.charAt(i) ;
      if(set.contains(cc) == false){
        set.add(cc) ;
        helper(ci+1,s,ssf+1,k, asf+cc,set) ;
        set.remove(cc) ;
      }
    }

  }

    
}
