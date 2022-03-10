package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q17_Count_Of_Substrings_Having_At_Most_K_Unique_Characters {

    public static int solution(String s, int k) {
	
		int n = s.length() ;

		HashMap<Character,Integer> map = new HashMap<>() ;

		int i = -1 ;
		int j = -1 ;
		int count = 0 ;

		while(true){ 

			while( i < n -1 ){

                i++; 
				char ch = s.charAt(i) ;

				map.put(ch, map.getOrDefault(ch,0)+1) ;

				if(map.size() <= k ){
					count += i-j ;
				}
				else{
					break ;
				}
			}

            if(i == n-1 && map.size() <= k)
            break ;

			while(j < i-1){
				j++ ;
				char ch = s.charAt(j) ;

				lastRemove(map,ch) ;

				if(map.size() <= k ){
					count += i-j ;
                    break ;
				}
			}
		}
		
		return count;
	}

	static void lastRemove(HashMap<Character,Integer> map , char ch){

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
