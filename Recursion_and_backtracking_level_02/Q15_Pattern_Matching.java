package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q15_Pattern_Matching {
    public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//write your code here

		if(pattern.length() == 0){
			if(str.length() == 0){

				HashSet<Character> set = new HashSet<>() ;
				for(char ch : op.toCharArray()){
					if(set.contains(ch) == false)
					{
						System.out.print(ch +" -> "+ map.get(ch)+", ");
						set.add(ch) ;
					}
				}
				System.out.println(".");
			}

			return ;
		}

		char ch = pattern.charAt(0) ; // using the first character of pattern
		String rop = pattern.substring(1) ; // now extracting the rest of the string in pattern as we used the first character

		if(map.containsKey(ch)){ // checking if the char is already available in map then check if it's value mapped with the same data or not.
			String pmword = map.get(ch) ; // previously stored data

			if(str.length() >= pmword.length()){ // if the length of string text is greater or equal then only we can extract the data which we stored before in map
				String left = str.substring(0,pmword.length()) ; // so extrracting the string 
				String right = str.substring(pmword.length()) ;// this is rest of the string

				if(pmword.equals(left)){ // if the previously stored data and current data is same then it means we mapped data correctly.
					solution(right,rop,map,op) ;
				}
			}

		}
		else{ // when char is not used before

			for(int i = 0 ; i < str.length() ; i++){ // so checking each substring and trying to generate answer from it.
				String prefix = str.substring(0,i+1) ; // new data
				String right = str.substring(i+1) ; // rest of the data

				map.put(ch,prefix) ; // storing in map
				solution(right,rop,map,op) ; // now moving forward and looking for next data
				map.remove(ch); // unvisiting 
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
        scn.close();
	}
}
