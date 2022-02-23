package Recursion_and_backtracking_level_02;
import java.util.*;

public class Q16_Word_Break {

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
        scn.close();
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		// write your code here

		if(str.length() == 0 ){ // base case when string is empty
			System.out.println(ans); // printing the answer.
			return ;
		}

		for(int i = 0 ; i < str.length() ; i++){
			String prefix = str.substring(0,i+1) ; // extracting each substring of string  str
			String right = str.substring(i+1) ; // rest of the string
			if(dict.contains(prefix)){ // checking if the substring we extracted is in the given dictionary if yes then move forward
				wordBreak(right,ans+prefix+" ",dict) ; // adding to answer and moving forward with rest of the string.
			}
		}
	}
		
    
}
