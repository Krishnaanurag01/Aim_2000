package Problem_Of_The_day;
import java.util.*;

public class Q159_Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> st = new Stack<>() ; // here we will insert temp with index 
        
        for(int i = temperatures.length - 1 ; i >= 0 ; i--){
            int val = temperatures[i] ; // backing up current temp so that we can store answer in the same array
            while(st.size() > 0 && st.peek()[0] <= val){
                st.pop();
            }
            
            if(st.size() == 0){
                temperatures[i] = 0 ; // storing answer in same array
            }
            else{
                temperatures[i] = st.peek()[1] - i ;
            }
            
            st.push(new int[]{val, i }) ;
        }
        return temperatures ;
    }
}
