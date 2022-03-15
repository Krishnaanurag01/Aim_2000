package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q56_Longest_Substring_With_At_Most_TwoDistinct_Characters {

    // Using acquire and release strategy.
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
    
        HashMap<Character,Integer> map = new HashMap<>() ;
    
        int ans = 0 ;
        int start = 0 ;
    
        for(int i = 0 ; i < s.length() ; i++){
    
          char ch = s.charAt(i) ;
    
          map.put(ch, map.getOrDefault(ch,0)+1) ;
    
          while(map.size() > 2){
            char rch = s.charAt(start) ;
            int freq = map.get(rch) ;
    
            if(freq == 1){
              map.remove(rch) ;
            }
            else{
              map.put(rch,freq-1) ;
            }
    
            start++ ;
          }
    
          ans = Math.max(ans,i-start+1) ;
    
        }
    
        return ans ;
    
      }
    
      public static void main(String[] args) throws java.lang.Exception {
    
        Scanner scn = new Scanner(System.in);
    
        int ans = lengthOfLongestSubstringTwoDistinct(scn.nextLine());
        System.out.println(ans);

        scn.close();
      }
    
}
