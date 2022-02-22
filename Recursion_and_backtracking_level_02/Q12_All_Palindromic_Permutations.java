package Recursion_and_backtracking_level_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// for palindrom of any string -> each character count should be even or only 1 character count can be odd

public class Q12_All_Palindromic_Permutations {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;
        String s = sc.next() ;

        HashMap<Character, Integer> fmap = new HashMap<>() ;

        
        // storing frequency of each char in string s
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            fmap.put(ch, fmap.getOrDefault(ch, 0)+1) ;
        }


        Character oddch = null ; // this will contain the character that has odd freq 
        int oddCount = 0 ; /// total count of char that has freq
        int totalLen = 0 ; // total len of string after dividing the freq in half

        // dividing the freq in half 

        for (Map.Entry<Character,Integer> e : fmap.entrySet()) {
            char ch = e.getKey() ;
            int freq = e.getValue() ;

            if(freq % 2 == 1){ // when freq id odd
                oddch = ch ;
                oddCount++ ;
            }

            fmap.put(ch,freq/2) ;
            totalLen += (freq/2) ; // also calculating the length
        }

        if(oddCount > 1){ // if odd count is more than 1 then we can't form palindrom
            System.out.println("not possible");
        }
        else{
            generatepw(1,totalLen,oddch, fmap,"") ; // else generate ans ( using 1 based indexing)
        }
        sc.close();

    }

    private static void generatepw(int i, int totalLen, Character oddCh, HashMap<Character, Integer> fmap, String s) {

        if(i > totalLen){ // as we consider 1 based indexing for i so when i is greater than its length then this base condition will get applied
            
            String palin = s ; // adding first half
            String rev = new StringBuilder(s).reverse().toString() ; // and second half is its reverse

            if(oddCh != null){ // checking if odd char is avail then adding it in middle
                palin += oddCh ;
            }

            palin += rev ; // adding the reverse part

            System.out.println(palin);
            return ;
        }

        // generating for each char
        for(Map.Entry<Character,Integer> e : fmap.entrySet()  ){
            char ch = e.getKey() ;
            int fre = e.getValue() ;

            if(fre > 0) { // if freq is greater than 1 then

                fmap.put(ch, fre-1) ; // using current char so reducing the freq (work like visited array)
                generatepw(i+1, totalLen, oddCh,fmap, s + ch); // now moving forward
                fmap.put(ch, fre) ; // unvisiting ( storing original freq)
            } 
        }
    }
    
}
