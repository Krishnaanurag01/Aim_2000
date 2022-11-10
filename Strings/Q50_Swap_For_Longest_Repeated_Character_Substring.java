package Strings;

public class Q50_Swap_For_Longest_Repeated_Character_Substring {

    public int maxRepOpt1(String text) {
        
        int[] freq = new int[26] ;
        int[] left = new int[text.length()] ;
        int[] right = new int[text.length()] ;
        
        int ans = 1 ;
        
        for(int i = 0 ; i < text.length() ; i++){
            freq[text.charAt(i) - 'a']++ ;
            
            if(i == 0 ){
                left[i] = 1 ;
            }
            else{
                if(text.charAt(i) == text.charAt(i-1)){
                    left[i] = left[i-1] + 1 ;
                }
                else{
                    left[i] = 1 ;
                }
            }
        }
        
        
        for(int i = text.length() - 1 ; i >= 0 ; i--){
            if(i == text.length() - 1){
                right[i] = 1 ;
            }
            else{
                if(text.charAt(i) == text.charAt(i+1)){
                    right[i] = right[i+1] + 1 ;
                }
                else{
                    right[i] = 1 ;
                }
            }
        }
        
        
        
        /// now finding the max answer.
        
        for(int i = 1 ; i < text.length() - 1 ; i++){
            
            if(text.charAt(i-1) == text.charAt(i+1) && text.charAt(i) != text.charAt(i-1)){
                if(freq[text.charAt(i-1) - 'a'] == left[i-1] + right[i+1] ){
                    ans = Math.max(ans, left[i-1] + right[i+1]) ;
                }
                else{
                    ans = Math.max(ans, left[i-1] + right[i+1] + 1) ;
                }
            }
            else{
                if(freq[text.charAt(i)  - 'a'] == left[i]) ans = Math.max(ans, left[i]) ;
                
                if(freq[text.charAt(i) - 'a'] != left[i]) ans = Math.max(ans, left[i] + 1) ;
            }
        }
        
        if(freq[text.charAt(text.length() - 1) - 'a']  == left[text.length() - 1]){
            ans = Math.max(ans, left[text.length() - 1]) ;
        }
        else{
            ans = Math.max(ans, left[text.length() - 1] + 1) ;
        }
        
        return ans ;
    }
}
