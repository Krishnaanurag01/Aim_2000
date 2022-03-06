package Dynamic_Programming_level_02;

import java.util.*;

public class Q68_Distinct_Echo_Substrings {

    public static void main(String[] args) {

    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();

        HashSet<String> set = new HashSet<>(); // this will store all the distinct strings.

        for (int len = 1; len <= n / 2; len++) { // starting from length 1 as length 0 means nothing till n/2 becuase we have to find similar two parts so two parts(2*n/2) == original path

            int count = 0; // this will count the char of strings

            for (int left = 0, right = len; right < n; left++, right++) {

                if (text.charAt(left) == text.charAt(right)) { // if both char are same then increase the count
                    count++;
                } else { // else make it 0
                    count = 0;
                }

                if (count == len) { // when equals to length
                    set.add(text.substring(left, right + 1)); // add string to set
                    count--; // and do count -- (becuase ex : abc abc this stored now we decrease count so it becomes bc-bc and check for next char if we get same char then it will added in set)
                }
            }
        }

        return set.size(); // return the size of set(has all the distinct strings).
    }

    
    // correct but gives TLE

    public int distinctEchoSubstrings2(String t ) {
        
        HashSet<String> set = new HashSet<>() ;
        
        int[][] dp = new int[t.length() ][t.length() ] ;
        
        for(int g = 0 ; g < t.length() ; g++){
            for(int i = 0 , j = g ; j < dp.length ; i++ , j++){
                
                if(g == 0)
                    continue ;
                
                String s = t.substring(i,j+1) ;
                // System.out.println(s) ;
                
                String s1 = s.substring(0, s.length()/2 ) ;
                
                // System.out.println(s + " s1 -  " + s1) ;
                
                String s2 = s.substring( s.length()/2 , s.length() ) ;
                
                // System.out.println(s + " s1 -  " + s1 + " s2 - " + s2) ;
                
                if(s1.equals(s2)){
                    set.add(s) ;
                }
            }
        }
        
        
        return set.size() ;
    }
}
