package Matrix;

import java.util.Stack;



public class LargestRectangleHistrogram_Q6 {
    public static void main(String[] args) {
        int heights[] = {0,2,1,4,5,9};
        System.out.println(largestRectangleArea(heights));
    }
    
// check pep coding solution video by sumeet sir.

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

         // now finding out the right boundries.

        int[] rb = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        rb[n-1] = n;
        
        for(int i = n-2 ; i >= 0 ; i--){
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            
            if(stack.size() == 0){
                rb[i] = n ;
            }
            else{
                rb[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // now finding out the left boundries.
        
        int[] lb = new int[n];
        
        stack= new Stack<>();
        stack.push(0);
        lb[0] = -1 ;
        
        for(int i = 1 ; i < n ; i++){
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            
            if(stack.size() == 0 ){
                lb[i] = -1;
            }
            else{
                lb[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // now calculating the area.
        
        int maxArea = 0 ; 
        for(int i = 0 ; i<n ; i++){
            int width = rb[i] - lb[i]-1;
            int area = width*heights[i];
            maxArea = Math.max(maxArea , area);
        }
        return maxArea;
    }
}
