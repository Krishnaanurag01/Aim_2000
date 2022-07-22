package Problem_Of_The_day;
import java.util.*;

public class Q112_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        int ans = 0 ;
        int maxfreq = 0 ;
        
        // aquire and release strategy.
        int i = -1 ;
        int j = -1 ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        while(true){
            boolean f1 = false ;
            boolean f2 = false ;
            
            // aquiring
            while(i < s.length() - 1){
                i++ ;
                char ch = s.charAt(i) ;
                map.put(ch,map.getOrDefault(ch,0)+1) ;
                
                maxfreq = Math.max(maxfreq,map.get(ch)) ;
                
                int len = i - j ;
                
                if(len - maxfreq > k){

                    f1 = true ;
                    break ;
                }

                ans = Math.max(ans, len) ;      
                f1 = true ;
            }
            
            // releasing
            while(j < s.length() - 1 ){
                j++;
                char ch = s.charAt(j) ;
                int freq = map.get(ch) ;
                
                if(freq == 1){
                    map.remove(ch) ;
                }
                else{
                    map.put(ch,freq-1) ;
                }
                
                int len = i - j ;
                if(freq == maxfreq){ // agar jis char ko humne delete kia uski freq maxfreq thi then only search the next maxfreq otherwise maxfreq remains same as there is no change in freq of max char.
                   maxfreq = getMax(map) ;
                }
                
                if(len - maxfreq <= k){
                    ans = Math.max(ans,len) ;
                    f2 = true ;
                    break ;
                }
                f2 = true ;
            }
            
            if(f1 == false && f2 == false) break;
        }
        
        return ans ;
    }
    
    // this is used to find the max freq after removal of any character
    int getMax(HashMap<Character,Integer> map)
    {
       int ans = 0 ;
        for(int value : map.values()){
            ans = Math.max(ans,value) ;
        }
        return ans ;
    }
}
