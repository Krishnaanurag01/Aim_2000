package Problem_Of_The_day;
import java.util.*;

public class Q91_Longest_Palindrome {
    
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1) ;
        }
        
        int even = 0 ;
        int odd = 0 ;
        
        for(char entry : map.keySet()){
            int freq = map.get(entry);
            if(freq % 2 == 0) even += freq ; // adding even freq .
            else {
                even += freq - 1 ; // adding even count in even.
                odd += 1;// and adding 1 count that is making this freq odd.
            }
        }
        
        // for a palindrom : either every should be of even size or there can be only 1 odd char.
        return even + (odd > 0 ? 1 : 0) ;
    }
}
