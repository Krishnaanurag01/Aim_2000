package Arrays_and_string_level_02;

public class Q32_Valid_Palindrome {

    // method : 01 

    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase() ;
        StringBuilder sb = new StringBuilder() ;
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch) == true){
                sb.append(ch) ;
            }
        }
    
        s = sb.toString() ;
        
        int i = 0 ; 
        int j = s.length() - 1 ;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false ;
            }
            
            i++ ;
            j-- ;
        }
        
        return true; 
    }


    // method 02 : // solved in one traversal

    public boolean isPalindrome2(String s) {
        
        s = s.toLowerCase() ;
        for(int left = 0 , right = s.length() - 1 ; left < right ; left++,right-- ){
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++ ;
            }
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right-- ;
            }
            
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
        }
        
        
        return true ;
        
    }
    
}
