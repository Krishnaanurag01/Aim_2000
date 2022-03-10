package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q12_Count_Of_Substrings_With_Exactly_K_Unique_Characters {

    // Using Aquire and Release strategy.

    public static int solution(String s, int k){
	    
	    HashMap<Character,Integer> mapb = new HashMap<>() ;
	    HashMap<Character,Integer> maps = new HashMap<>() ;
	    
	    int is = -1 ; // for small map
	    int ib = -1  ; // for big map
	    int j = -1 ; // for releasing
	    
	    int ans = 0 ;
	    
	    while(true){
	        boolean f1 = false ; 
	        boolean f2 = false ; 
	        boolean f3 = false ;
	        
            // aquring in big map.

	        while(ib < s.length() - 1 ){
	            f1 = true ;
	            ib++ ;
	            char ch = s.charAt(ib) ;
	            
	            mapb.put(ch,mapb.getOrDefault(ch,0)+1) ;
	            
                // if map contains k+1 char then remove the last inserted char and also decrease the last incremented pointer.

	            if(mapb.size() == k + 1 ){
	                removeLast(mapb,ch) ;
	                ib-- ;
	                break ;
	            } 
	            
	        }
	        
            // aquiring in small map.

	        while(is < ib ){
	            f2 = true ;
	            is++ ;
	            char ch = s.charAt(is) ;
	            
	            maps.put(ch,maps.getOrDefault(ch,0)+1) ;
	            
                // small map must contains only k-1 char, if it has k char then remove last inserted char and also decrease the freq
	            if(maps.size() == k ){
	                removeLast(maps,ch) ;
	                is-- ;
	                break ;
	            } 
	           
	        }
	        
	        // releasing.
	        
	        while( j < is ){
	            f3 = true ;
	            
	            j++ ;
	            char ch = s.charAt(j) ;
	            
                // if big map has k chars and small map has k-1 char then count the length and add it ans
	            if(mapb.size() == k && maps.size() == k-1){
	                ans += (ib-is) ;
	            }

                // removing the character from start
	            
	             removeLast(maps,ch) ;
	             removeLast(mapb,ch) ;
	            
                 // if size decreases the break.
	             if(mapb.size() < k || maps.size() < k-1){
	               break ;
	            }
	        }
	        
	        
	        if(f1 == false && f2 == false && f3 == false){
	            break ;
	        }
	        
	        
	    }

		return ans;
	}
	
	
	static void removeLast(HashMap<Character,Integer> map, char ch){
	    int freq = map.get(ch) ;
	    
	    if(freq == 1){
	        map.remove(ch) ;
	    }
	    else{
	        map.put(ch,freq-1) ;
	    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
        scn.close();
	}
    
}
