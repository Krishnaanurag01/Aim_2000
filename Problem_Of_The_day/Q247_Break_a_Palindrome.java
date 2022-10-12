package Problem_Of_The_day;

public class Q247_Break_a_Palindrome {

    public String breakPalindrome(String palindrome) {
        
        if(palindrome.length() == 1) return "" ;
        
        int mid_idx = palindrome.length()/2 ; // finding mid index this helps when palindrome is of odd length
        StringBuilder sb = new StringBuilder(palindrome) ;
        boolean replaced = false ;
        
        // now visiting each index.
        for(int i = 0 ; i < sb.length() && replaced == false ; i++){
            if(palindrome.length() % 2 != 0 && i == mid_idx) continue ; // if it is mid index and string is of odd length then changing here will not help us in breaking the palindrom
            
            char ch = sb.charAt(i) ;
            for(char cc = 'a' ; cc < ch ; cc++){ // now finding lesser character
                replaced = true ; // if found then make flag true and break;
                sb.setCharAt(i,cc) ;
                break ;
            }
        }
        
        if(replaced == true) return sb.toString() ; // if change already occur then return
        
        
        // otherwise change the last index character.
        for(char ch = 'a' ; ch < 'z' ; ch++){
            if(palindrome.charAt(palindrome.length() - 1) != ch){
                sb.setCharAt(palindrome.length() - 1, ch ) ;
                break;
            }
        }
        
        
        return sb.toString() ;
    }
}
