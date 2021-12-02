package Stack_and_Queue_level01;

import java.util.Stack;

public class Q5_Stock_span_problem {

    public static int[] calculateSpan(int price[], int n)
    {

        //
        Stack<Integer> stack = new Stack<>() ;
        int[] ans = new int[n] ;

        ans[0] = 1 ;
        stack.add(0) ;
        
        for(int i = 1 ; i < n ; i++){
            
            while(stack.size() > 0 && price[i] >= price[stack.peek()] ){
                stack.pop() ;
            }
            
            if(stack.size() == 0){
                ans[i] = i + 1 ;
            }
            else{
                ans[i] = i - stack.peek() ;
            }
            
            stack.push(i) ;
        }

      
        return ans ;
    }
    
}
