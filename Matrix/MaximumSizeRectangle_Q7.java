package Matrix;

import java.util.Stack;

public class MaximumSizeRectangle_Q7 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        
        int colSize = matrix[0].length;
        int[] heights = new int[colSize];
        int answer = 0;
        
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < colSize ; j++){
                
                if(matrix[i][j] == '1'){ // if has 1 then increament the height array by 1.
                    heights[j] += 1;
                }
                else{ // otherwise completely delete the element with 0.
                    heights[j] = 0;
                }
            }

            answer = Math.max(answer , largestRectangleArea(heights));
        }
        return answer;
        
    }
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
