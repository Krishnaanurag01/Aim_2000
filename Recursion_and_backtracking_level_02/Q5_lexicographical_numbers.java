package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q5_lexicographical_numbers {

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt() ;

        // step 1 : start with 1 -> 9
		for(int i = 1 ; i <= 9 ; i++){
			helper(i,n) ;
		}

        scn.close();
	}

	static void helper(int i , int n){

		if(i > n){ // if number becomes larger than our limit then return
			return  ;
		}

        /// print the number
		System.out.println(i);

        // now find the next family of current number
		for(int j = 0 ; j <=9 ; j++){ // ex. i is 1 and n is 1000 now this loop create nex family of 1 tha 10 ,11,12,...19 and then they all find their family
			helper(10 * i + j, n) ;
		}
	}
    
}
