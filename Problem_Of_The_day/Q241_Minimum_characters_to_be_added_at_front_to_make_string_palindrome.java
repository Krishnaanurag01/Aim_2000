package Problem_Of_The_day;

public class Q241_Minimum_characters_to_be_added_at_front_to_make_string_palindrome {

    public static int minChar(String s) {
      
        int n = s.length() - 1;
        int i = 0 ;
        int j = n ;
        int ans = 0 ;
        
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++ ;
                j-- ;
            }
            else{ // when char is not same the we are adding the last char current range in just prev position of 0th index.
                ans++ ;  // and increasing count becuase we have added one char.
                i = 0 ; // again start from 0.
                n-- ; // now as we have added the last char of prev range then it means the last char will must be same so 
                j = n ; // the j is now point to n-1 position.
            }
        }
       
        return ans ;
      }
}
