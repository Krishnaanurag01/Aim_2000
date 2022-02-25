package Recursion_and_backtracking_level_02;
import java.io.*;
import java.util.*;
public class Q28_Words_K_Length_Words_1 {

    
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

    Character[] arr = new Character[k] ;
    helper(0,ustr,0,k,"",arr) ;
    
  }

  static void helper(int ci , String s ,int  ssf, int k , String asf , Character arr[]){

    if(ci >= s.length() ){
      if(ssf == k){
        for (int i = 0; i < arr.length ; i++) {
      System.out.print(arr[i]);
        }
        System.out.println();
      }

      return ;
    }


    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] == null){
        arr[i] = s.charAt(ci) ;
        helper(ci+1,s,ssf+1,k,asf+(s.charAt(ci)),arr);
        arr[i] = null;
      }
    }

        helper(ci+1,s,ssf,k,asf,arr);


  }

    
}
