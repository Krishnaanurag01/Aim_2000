package Problem_Of_The_day;

public class Q294_Maximum_Sub_String_after_at_most_K_changes {

    public int characterReplacement(String s, int k)
    {
        
        // using acquire and release strategy.
        int ans = 0 ;
        int i = -1 ;
        int j = -1 ;
        
        int[] freq = new int[26] ;
        int maxFreq = 0 ;
        
        while(true){
            
            boolean f1 = false;
            boolean f2 = false; 
            
            // acquiring first. 
            while(i < s.length() - 1){
                i++ ;
                char ch = s.charAt(i) ; 
                freq[ch - 'A']++ ;
                // we have to maintain this maxFreq variable so that we can say that size - maxfreq element need to be replaced in order to have every char same
                maxFreq = Math.max(maxFreq, freq[ch - 'A']) ;
                
                int size = i - j  ;

                if(maxFreq + k >= size){ // if it is under constraint then update the answer.
                    ans = Math.max(ans, size) ;
                }
                else{ // else break and release some character then try
                    f1 = true;
                    break ;
                }
                
                f1 = true ;
            }
            
            // release as long as subtring is over constraints
            while( j <= i && j < s.length() - 1 && (i - j ) - maxFreq > k){
                j++ ;
                
                char ch = s.charAt(j) ;
                freq[ch - 'A']-- ;
                
                //now after deletion check max freq.
                maxFreq = 0 ;
                for(int val : freq){
                    maxFreq = Math.max(maxFreq, val) ;
                }

                int size = i - j ;
                if(maxFreq + k >= size){ // updating answer.
                    ans = Math.max(ans, size) ;
                    f2 = true ;
                    break ;
                }
                
                f2 = true ;
            }
            
            if(f1 == false && f2 == false) break ;
        }
        
        return ans ;
    }
}
