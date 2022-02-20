package Recursion_and_backtracking_level_02;

public class Q3_Max_Score {
    
    public static int solution(String[] words, int[] farr, int[] score, int idx) {

		if(idx == words.length){
			return 0 ;
		}		

		// when current word is not including in our answer.
		int ScoreNotIncl = solution(words,farr,score,idx+1) ;

		// when including current word in our answer.

		int scoreOfWord = 0 ;

		String word = words[idx] ;
		boolean shouldIinclude = true ;

		for(int i = 0 ; i < word.length() ; i++){
			char ch = word.charAt(i) ;

			if(farr[ch - 'a'] == 0){
				shouldIinclude = false ; // we can't include now becuase the frequency of current word char is not available
			}

			farr[ch - 'a']-- ;
			scoreOfWord += score[ch-'a'] ; 
		}

		int scoreWhenInc = 0 ;

		if(shouldIinclude == true){
			scoreWhenInc = scoreOfWord + solution(words,farr,score,idx+1) ;
		}

		for(int i = 0 ; i < word.length() ; i++){
			char ch = word.charAt(i) ;
			farr[ch-'a']++ ; 
		}
		
		return Math.max(scoreWhenInc,ScoreNotIncl);
	}

	

}
