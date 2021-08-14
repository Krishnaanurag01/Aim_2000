package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Q16_Word_Break {
 public static void main(String[] args) {
     ArrayList<String> B = new ArrayList<>(Arrays.asList( "i", "like", "sam",
     "sung", "samsung", "mobile",
     "ice","cream", "icecream",
     "man", "go", "mango" ));

     System.out.println(wordBreak("ilike", B));
 }

 public static int wordBreak(String s, ArrayList<String> wordDict )
 {
  int[] dp = new int[s.length()];
     
     for(int i = 0 ; i < dp.length ; i++){
         for(int j = 0 ; j <= i ; j++){
             String seq = s.substring(j , i+1);
             if(wordDict.contains(seq)){
                 if(j > 0){
                     dp[i] += dp[j-1];
                 }
                 else{
                     dp[i] += 1;
                 }
             }
         }
     }
     
     return dp[dp.length-1]  ;
 }

}
