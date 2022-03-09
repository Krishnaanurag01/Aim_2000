package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q8_Minimum_Window_Substring {

    public static void main(String[] args) {
        
    }

    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> mapForT = new HashMap<>() ;
        // storing every char of t.
        for(char ch : t.toCharArray()){
            mapForT.put(ch, mapForT.getOrDefault(ch,0)+1) ;
        }
        
        
        int i = 0 ;
        int j = 0 ;
        String ans = "" ;
        
        int msc = 0 ; // measured count
        int dsc = t.length() ; // desired count
        
        HashMap<Character,Integer> mfs = new HashMap<>() ; // map for s
        
        while(true){
            boolean f1 = false ;
            boolean f2 = false ;
            
            // using acquire and release technique.

            // acquiring
            while(i < s.length() && msc < dsc ){
                char ch = s.charAt(i) ;
                mfs.put(ch, mfs.getOrDefault(ch,0 ) + 1) ;
                
                if(mfs.getOrDefault(ch,0) <= mapForT.getOrDefault(ch,0) ){
                    msc++ ;
                }
                
                i++ ;
                f1 = true ;
            }
            
            // releasing
            while(j < s.length() && msc == dsc){
                String pans = s.substring(j,i) ;
                
                if(ans.length() == 0){
                    ans = pans ;
                }
                else if(ans.length() > pans.length() ){
                    ans = pans ;
                }
                
                char ch = s.charAt(j) ;
                
                int freq = mfs.get(ch) ;
                
                if(freq == 1){
                    mfs.remove(ch) ;
                }
                else{
                    mfs.put(ch,freq-1) ;
                }
                
                j++ ;
                
                if(mfs.getOrDefault(ch,0) < mapForT.getOrDefault(ch,0) ){
                    msc-- ;
                }
                
                f2 = true ;
            }
            
            
            if(f1 == false && f2 == false){
                break ;
            }
            
        }
        
        return ans ;
        
    }
    
}
