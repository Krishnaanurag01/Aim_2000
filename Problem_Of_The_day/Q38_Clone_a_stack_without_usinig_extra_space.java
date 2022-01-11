package Problem_Of_The_day;
import java.util.*;

public class Q38_Clone_a_stack_without_usinig_extra_space {

    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        
        if(st.empty() ){  // if stack becomes empty then return
            return ;
        }

        int d = st.pop() ; // taking the top node
        clonestack(st, cloned); // recursively calling
        cloned.push(d) ; // now adding to cloned one.


    }
    
}
