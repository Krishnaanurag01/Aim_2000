package Recursion_and_backtracking_level_02 ;
import java.util.*;

public class Q10_Cryptarithmetic {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
    
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";// finding all the unique char of s1,s2,s3 and mapping -1 initially
        for (int i = 0; i < s1.length(); i++) {
          if (!charIntMap.containsKey(s1.charAt(i))) {
            charIntMap.put(s1.charAt(i), -1);
            unique += s1.charAt(i);
          }
        }
    
        for (int i = 0; i < s2.length(); i++) {
          if (!charIntMap.containsKey(s2.charAt(i))) {
            charIntMap.put(s2.charAt(i), -1);
            unique += s2.charAt(i);
          }
        }
    
        for (int i = 0; i < s3.length(); i++) {
          if (!charIntMap.containsKey(s3.charAt(i))) {
            charIntMap.put(s3.charAt(i), -1);
            unique += s3.charAt(i);
          }
        }
    
        boolean[] usedNumbers = new boolean[10]; // this will help us in identifying whether the number is used before or not
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
        scn.close();
      }

      
      // return the string with its character mapped to integer
      public static int getNum(String s ,HashMap<Character, Integer> charIntMap ){

        String num ="" ;
        for(int i = 0 ; i < s.length() ; i++){
          int n = charIntMap.get(s.charAt(i)) ;
          num += n ; 
        }
    
        return Integer.parseInt(num) ;
      }
      
      public static void solution(String unique, int idx, 
                                  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
                                  String s1, String s2, String s3) {
            
                                    // base condition.
          if(idx == unique.length()){
            int num1 = getNum(s1,charIntMap);
            int num2 = getNum(s2,charIntMap);
            int num3 = getNum(s3,charIntMap);
    
            if(num1+num2 == num3){ // when sum equls then only print the combination of char mapping in lexicography order.
              for(int i = 0 ; i < 26 ; i++){
                char ch = (char) ('a' + i) ;
                if(charIntMap.containsKey(ch)){
                  System.out.print( ch+"-"+charIntMap.get(ch)+" " );
                }
              }
              System.out.println();
            }
    
            return ; // backtracking 
          }
    
     
          // mapping every integer from 0-9 to our unique char
          for(int i = 0 ; i <= 9 ; i++){
            if(usedNumbers[i] == false){ // if not used before then only map with the character
              char ch = unique.charAt(idx) ; 
              charIntMap.put(ch,i) ; // mapped
              usedNumbers[i] = true ; // making visited so that other char could not use this integer again
              solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3) ; //now solving further
              usedNumbers[i] = false ; // making univisited
              charIntMap.put(ch,-1) ; // and also reinitialising with -1 again.
            }
          }
    
      }

    
}