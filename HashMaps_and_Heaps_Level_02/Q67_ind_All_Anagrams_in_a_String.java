package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q67_ind_All_Anagrams_in_a_String {

    // aquire and release approch.
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>() ;
        if(s.length() < p.length()) return list ;
        
        int len = p.length() ;
        int n = s.length() ;        
        HashMap<Character,Integer> pMap = new HashMap<>() ;
        HashMap<Character,Integer> smap = new HashMap<>() ;

        for(int i = 0 ; i < len ; i++ ){
            char ch1 = p.charAt(i) ;
            char ch2 = s.charAt(i) ;
            pMap.put(ch1, pMap.getOrDefault(ch1,0)+1) ;
            smap.put(ch2, smap.getOrDefault(ch2,0)+1) ;
        }
    
        int j = 0 ;
         
        for(int i = len ; i < n ; i++ ){  
           if( pMap.equals(smap) ) list.add( i - len ) ;
           // aquiring ith char
           char ch = s.charAt(i) ;
           smap.put(ch, smap.getOrDefault(ch,0)+1) ;
            
           // releasing the jth char
           char ch2 = s.charAt(j) ;
           int freq = smap.get(ch2) ;
           
           if(freq == 1) smap.remove(ch2) ;
           else smap.put(ch2,freq-1) ;
           j++ ;
        }
        
        if( pMap.equals(smap) ) list.add( n - len ) ;
        return list ;
    }
}
