package Stack_and_Queue_level01;

import java.util.Stack;

public class Q6_Histrogram {

    // check explanation in matrix section.
    
    public static long getMaxArea(long hist[], long n) 
    {
        int m = (int) n ;
        Stack<Integer> stack = new Stack<>() ;

        stack.push(m-1) ;

        long[] rse = new long[m] ;
        rse[m-1] = n ;

        for (int i = m-2 ; i >= 0 ; i--) {
            
            while (stack.size() > 0 && hist[stack.peek()] >= hist[i] ) {
                stack.pop() ;
            }

            if(stack.empty()){
                rse[i] = n ;
            }
            else{
                rse[i] = stack.peek() ;
            }

            stack.push(i) ;
        }


        stack = new Stack<>() ;

        long[] lse = new long[m] ;
        lse[0] = -1 ;

        stack.push(0) ;

        for (int i = 1 ; i < m ; i++) {
            
            while (stack.size() > 0 && hist[stack.peek()] >= hist[i] ) {
                stack.pop() ;
            }

            if(stack.empty()){
                lse[i] = -1 ;
            }
            else{
                lse[i] = stack.peek() ;
            }

            stack.push(i) ;
        }


        long result = -1 ;

        for (int i = 0; i < lse.length; i++) {

            long width = rse[i] - lse[i] - 1 ;
            long ans = width*hist[i] ;
            result = Math.max(ans, result) ;
            
        }

        return result ;
    }

}
