package Stack_and_Queue;

import java.util.Stack;

public class Q51_getMin_of_stack_in_constant_time_and_space {

    int min ;

    public void push(int a,Stack<Integer> s)
    {
        //add code here.
        if(s.isEmpty()){
            s.push(a) ;
            min = a ; 
            return ;
        }

        if(a >= min){ // if value is greater than min the directly push it.
            s.push(a) ;
        }
        else{
            s.push(a + a - min) ; // storing smaller value than a .
            min = a ; // and also updating the min value.
        }



    }
     public int pop(Stack<Integer> s)
        {
            //add code here.
            if(s.size() == 0) return -1 ;

            if(s.peek() >= min ){
                return s.pop() ; 
            }
            else{ // if stack.peek value is smaller than our min value then this is the value we change with the for v + v - m ;
                // so do this
                int popped_elem = min ; // this was the original value
                min = 2*min - s.pop() ; // this will get us the previous min value.
                return popped_elem ;
            }
    }
    public int min(Stack<Integer> s)
        {
           //add code here.
           if(s.size() == 0){
               return -1 ;
           }
           return min ;
    }
    public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here
           return s.size() == n ;
    }
    public boolean isEmpty(Stack<Integer>s)
        {
            return s.isEmpty() ;
           //add code here.
    }
    
}
