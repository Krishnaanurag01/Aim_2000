package HashMaps_and_Heaps_Level_02 ;
import java.util.*;

public class Q11_Longest_K_unique_characters_substring {


    // Using Acquire and Release Strategy.


    public int longestkSubstr(String s, int k) {
        
        HashMap<Character,Integer> map = new HashMap<>() ;
        
        int ans = -1 ;  // this is our initial answer.
        int i = 0 ;
         int j = 0 ;
         
         while(true){
             boolean f1 = false ;
             boolean f2 = false ;
             
             while(i < s.length() ){
                 
                 f1 = true ;
                 char ch = s.charAt(i) ; //  acquiring the char and adding to map
                 
                 map.put(ch, map.getOrDefault(ch, 0) + 1 ) ;
                 
                 
                 if(map.size() == k  ){ // if map size becomes equal to k then current j to i length substring is ourn potential answer.

                     ans = Math.max(ans, i - j + 1) ;
                 }
                 
                 // incrementing before becuase in next step we are breaking the iteration and after the break  and release  this acquire operation will add current char again thats why doing this. 
                 i++ ;
                 
                 if(map.size() > k ){
                     break ;
                 }
                 
             }

             // releasing.
             
             while(j < i ){
                 f2 = true ;
                 
                 char ch = s.charAt(j) ;
                 
                 int freq =  map.get(ch) ;
                 
                 if(freq == 1){ 
                     map.remove(ch) ;
                 }
                 else{
                     map.put(ch,freq-1) ;
                 }
                 
                 j++ ;
                 
                 // if after the removal of current char if map size becomes potential then break the loop
                 if(map.size() <= k ){
                     break ;
                 }
                 
                 
             }
             
             if(f1 == false && f2 == false){
                 break ;
             }
         }
         
         return ans ;
    }

    
}