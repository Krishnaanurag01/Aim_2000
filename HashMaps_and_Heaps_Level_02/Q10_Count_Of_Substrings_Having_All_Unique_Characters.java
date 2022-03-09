package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q10_Count_Of_Substrings_Having_All_Unique_Characters {

    // using acquire and release strategy

    // same as previous questions

    public static int solution(String s) {
		
		int count = 0 ;

		int i = -1 ;
		int j = -1 ;

		HashMap<Character,Integer> map = new HashMap<>() ;

		while(true){
			boolean f1 = false ;
			boolean f2 = false ;

            // acquiring
			while(i < s.length() - 1  ){
				f1 = true ;
				i++ ;

				char ch = s.charAt(i) ;

				map.put(ch, map.getOrDefault(ch,0)+1) ;

				if( map.get(ch) == 2  ){
					break ; // breaking since duplicacy found
				}
				else{
					// add the length of i-j as this length contains same number of substring ex> abc : abc,bc,c
					count += (i-j) ;
				}

			}

            // releasing

			while(j < i ){
				f2 = true ;

				j++ ;
				char ch = s.charAt(j) ;

				map.put(ch,map.get(ch) - 1) ;

				if(map.get(ch) == 1 ){
					int len = i - j ;
					count += len ;
					break ;
				}
				else{
					map.remove(ch) ;
				}


			}

			if(f1 == false && f2 == false){
				break ;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
        scn.close();
	}



}
