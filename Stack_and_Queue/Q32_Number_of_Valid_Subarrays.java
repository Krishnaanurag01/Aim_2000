package Stack_and_Queue;
import java.util.*;

public class Q32_Number_of_Valid_Subarrays {

    public static int validSubarrays(int[] nums) {
      
        Stack<Integer> st = new Stack<>() ;
        int ans = 0 ;
        
        
        for(int i = nums.length-1 ; i >=0  ; i--){
            int val = nums[i] ;
             
            // getting smaller element to the right. ( getting index here)
            while(st.size() > 0 && nums[st.peek() ] >= val ) st.pop() ;
            
            int ng = nums.length ; // assigning n by default
            if(st.size() > 0 ) ng = st.peek() ; // of stack has any element left then that index value will override the ng
            
            ans += (ng - i) ; // gettting width
            
            st.push(i) ; // adding to the answer.
        }
        
        
      return ans;
    }
    
}
