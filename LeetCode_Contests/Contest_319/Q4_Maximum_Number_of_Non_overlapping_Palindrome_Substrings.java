package LeetCode_Contests.Contest_319;

public class Q4_Maximum_Number_of_Non_overlapping_Palindrome_Substrings {

    public int maxPalindromes(String s, int k) {
        
        // we have asked to find a palindrome string of size k or greater but instead of finding palindrome of size more than k we will just find such strins of size k (when odd) and k + 1 (when even). 
        // agar hum kisi larger size ( ? > k + 1) palindrome ko pick karenge toh ho sakta us palindrome k andar 1 se jyda k ya k + 1 size ka substring ho jo palindrome ho toh isliy hum bas k ya k + 1 palindrome dhundenge 
            
            
        int count = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){  // searching each substring
                
                if( j - i + 1 > k + 1) continue ; //  base size wale ko skip it.
                if(j - i + 1 == k + 1 || j - i + 1 == k ){ // agar size k or k +1 tabhi check karo  
                    
                    
                    // now checking if current substirng is palindrome or not.
                    int m = i ;
                    int n = j ; 
                    boolean flag = true ;
                    
                    while(m <= n){
                        if(s.charAt(m) != s.charAt(n)){
                            flag = false;
                            break ;
                        }
                        m++ ;
                        n-- ;
                    }
                    
                    if(flag) {                     
                        i = j  ; // as mentioned we can not take overlapped string isliy next palindrome string should start from next char after current string end.
                        count++ ;
                        break ;
                    }
                }
            }
        }
        
        return count ;
    }
}
