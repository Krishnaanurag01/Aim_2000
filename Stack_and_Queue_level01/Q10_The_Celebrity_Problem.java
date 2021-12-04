package Stack_and_Queue_level01;

import java.util.*;

public class Q10_The_Celebrity_Problem {


    // method 01 : takes O(n) time and O(n) 

    int celebrity(int M[][], int n)
    {
    	// code here 
    	
    	Stack<Integer> stack = new Stack<>() ;
    	for(int i = 0 ; i < M.length ; i++){
    	    stack.push(i) ;
    	}
    	
    	while( stack.size() >= 2 ) {
    	    int i = stack.pop() ;
    	    int j = stack.pop() ;
    	    
    	    if(M[i][j] == 1){
    	        // this means i knows j -> i can't be celebrity
    	        stack.push(j) ;
    	    }
    	    else if(M[j][i] == 1){
    	        // means j knows i -> j can't be celebrity
    	        stack.push(i) ;
    	    }
    	}
    	
    	int potential_ans = stack.pop() ; // it coubld be answer. so checking it below.
    	
    	for(int i = 0 ; i < M.length ; i++){
    	    
    	    if( i != potential_ans){
    	        // this denotes that someone doesn't know potential celebrity and celebrity knows someone so return -1; 
    	        if(M[i][potential_ans] == 0 || M[potential_ans][i] == 1){
    	            return -1;
    	        }
    	    }
    	}
    	
    	return potential_ans;
    	
    }

    // method 02 : takes O(n) time and O(1) space.
    
    public static int getCelebrity(int[][] M) {
        
        int pot = 0 ;

        for (int i = 1 ; i < M.length; i++) {   // this loop is working same as stack of above method.
            if(M[pot][i] == 1){ // if potential celeb knows i then potential celeb (he must not know anyone) changed with i and check for i.
                pot = i ;
            }
        }

        // same as method 1 loop
        for (int i = 0; i < M.length; i++) {
            
            if(i != pot){
                if(M[i][pot] == 0 && M[pot][i] == 1 ){
                    return -1 ;
                }
            }
        }



        return pot ;
    }
    
}
