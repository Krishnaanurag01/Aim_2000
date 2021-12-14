package Stack_and_Queue;

import java.util.* ;

public class Q25_Asteroid_Collision {

    public int[] asteroidCollision(int[] arr) {
        
        Stack<Integer> stack = new Stack<>() ;
        
        for(int val : arr){
            
            if( val > 0 ){
                stack.push(val) ;
            }
            else{
                
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < -val ){
                    stack.pop();
                }
                if(stack.size() > 0 && stack.peek() > 0 && stack.peek() == -val ){
                    stack.pop();
                }
                else if(stack.size() > 0 && stack.peek() > 0 && stack.peek() > -val ){
                    
                }
                else{
                    stack.push(val) ;
                }
                
            }
        }
        
        
        int[] ans = new int[stack.size()] ;
        
        for(int i = stack.size()-1 ; i >= 0  ; i--){
            ans[i] = stack.pop() ;
        }
        
        return ans ;
    }
    
}
