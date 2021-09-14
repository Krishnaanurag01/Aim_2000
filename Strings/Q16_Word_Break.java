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


//  Expected time complexity: O(s2)

// Expected auxiliary space: O(s) , where s = length of string A

 public static int wordBreak(String s, ArrayList<String> wordDict )
 {
  int[] dp = new int[s.length()];
     
     for(int i = 0 ; i < dp.length ; i++){
         for(int j = 0 ; j <= i ; j++){
             String seq = s.substring(j , i+1);
             if(wordDict.contains(seq)){
                 if(j > 0){ // if its not given then ,when i  = 0  then it gives error.
                     dp[i] += dp[j-1]; // here adding to the ith index becuase there might be possible that it found some other substring too so we'll add into this.
                 }
                 else{
                     dp[i] += 1; // otherwise just add 1.
                 }
             }
         }
     }
     
     return dp[dp.length-1]  ;
 }

}
