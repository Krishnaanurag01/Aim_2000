package Problem_Of_The_day;
import java.util.*;

public class Q286_Online_Stock_Span {

    class StockSpanner {
        Stack<int[]> st;
        
        public StockSpanner() {
            st = new Stack<>();
        }
        
        public int next(int price) {
            
            int span = 1; // current span
            
            while(st.size() > 0 && price >= st.peek()[0]){ // if price is lower then remove and add it's span into current span
                span += st.pop()[1];
            }
            
            st.push(new int[]{price, span}); // adding current price with span 
            return span;
        }
    }
}
