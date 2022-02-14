package Arrays_and_string_level_02;

public class Q33_Valid_Palindrome_II {
    
    public boolean validPalindrome(String s) {
        
        int i = 0 ;
        int j = s.length() -1 ;
        
        while(i < j ){  // iterate till we have palindrome characters
            
            if(s.charAt(i) == s.charAt(j)){
                i++ ;
                j-- ;
            }
            else{ // if character is not same then again check for palidrome with i+1 as start and j as end this denotes that we have deleted ith character and checking for i+1 to j 
                // same for j-1 to i.
                
                // if In any case we got true then return true else if both the case return false then return false;
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1) ;
            }
        }
        
        return true ;
    }
    
    
    public boolean isPalindrome(String s, int i , int j ){
        
        while(i < j ){
            if(s.charAt(i) != s.charAt(j)){
                return false ;
            }
            
            i++ ;
                j-- ;
        }
        
        return true ;
    }

}
