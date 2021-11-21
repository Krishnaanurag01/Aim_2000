package Problem_Of_The_day ;

import java.util.*;

/**
 * Q12_Longest_common_prefix
 */
public class Q12_Longest_common_prefix {

    public static void main(String[] args) {
        
    }

    public int[] longestCommonPrefix(String s1, String s2){
      
        // default start and end index would be -1.
        int startIdx = -1 ; 
        int endIdx = -1 ;

        for (int i = 0; i < s1.length() ; i++) {
            
            if(s2.contains(s1.substring(0, i+1))){ // if s2 contains substring of s1 then change start index to 0 andd end index to i.
                startIdx = 0 ;
                endIdx = i ;
            }
            else{ // if it doesn't contain then break the loop immediately.
                break ;
            }
        }

        return new int[]{startIdx,endIdx};
    }
}