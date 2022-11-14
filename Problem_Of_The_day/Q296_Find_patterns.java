package Problem_Of_The_day ;
public class Q296_Find_patterns {

    static int numberOfSubsequences(String S, String W){
        
        int count = 0 ;
        char[] arr = S.toCharArray() ;
        
        // we have to find count of W as a subsec in S and every char of S can be used only in one subsequence.
        
        for(int k = 0 ; k < S.length() ; k++){
            if(S.charAt(k) == W.charAt(0)){
                
                int i = k ;
                int j = 0 ;
                
                while(i < S.length() && j < W.length()){
                    char ch1 = arr[i] ; // taking the char from arr
                    char ch2 = W.charAt(j) ;
                    
                    if(ch1 == ch2){ 
                        arr[i] = '#' ; // as we used current s char so changing it to '#' so that we won't use this again.
                        i++ ;
                        j++ ;
                    }
                    else{
                        i++ ;
                    }
                }
                
                if(j == W.length()) count++ ;
                
            }
        }
        
        return count ;
    }
}
