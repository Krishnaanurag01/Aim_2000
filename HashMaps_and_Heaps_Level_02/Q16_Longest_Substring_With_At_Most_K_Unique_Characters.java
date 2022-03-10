package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q16_Longest_Substring_With_At_Most_K_Unique_Characters {

    // same as Q11.

    public static int solution(String s, int k) {
	
		 HashMap<Character,Integer> map = new HashMap<>() ;
        
        int ans = -1 ; 
        int i = 0 ;
         int j = 0 ;
         
         while(true){
             boolean f1 = false ;
             boolean f2 = false ;
             
             while(i < s.length() ){
                 
                 f1 = true ;
                 char ch = s.charAt(i) ;
                 
                 map.put(ch, map.getOrDefault(ch, 0) + 1 ) ;
                 
                 
                 if(map.size() <= k  ){// only difference. here we will also look the answer for at most k size.
                     ans = Math.max(ans, i - j + 1) ;
                 }
                 
                 i++ ;
                 
                 if(map.size() > k ){
                     break ;
                 }   
             }
             
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
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
        scn.close();
	}
    
}
