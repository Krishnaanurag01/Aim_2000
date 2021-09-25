package Matrix;

import java.util.Stack;



public class LargestRectangleHistrogram_Q6 {
    public static void main(String[] args) {
        int heights[] = {0,2,1,4,5,9};
        System.out.println(largestRectangleArea(heights));
    }
    
// check pep coding solution video by sumeet sir.

// Since every bar is pushed and popped only once, the time complexity of this method is O(n). and space is o(n)

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

         // now finding out the right boundries.

        int[] rb = new int[n]; // storing the index of next element which is smaller.
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);// adding the index of last element.
        rb[n-1] = n; // last element index would be array length. // if not found any smaller element in right then store the n as index.
        
        for(int i = n-2 ; i >= 0 ; i--){ // starting from second last as last index is already saved.
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){ // if height of stack.peek is larger or equal to height of current element then we don't have exclude it. we have to find the height of element such that it is smaller. 
            // so we'll pop from stack and look again for smaller height.
                stack.pop();
            }
            
            if(stack.size() == 0){ // when stack is null and we didn't find any element with smaller height then we'll consider n as index.
                rb[i] = n ; // if not found any smaller element in right then store the n as index.
            }
            else{ // otherwise stack.peek is the value whose height is smaller.
                rb[i] = stack.peek();
            }
            stack.push(i); // pushing the current index.
        }
        
        // now finding out the left boundries.
        
        int[] lb = new int[n]; // left boundry , it will store the index of left element whose height is smaller.
        
        stack= new Stack<>();
        stack.push(0); // adding the index of first element by default.
        lb[0] = -1 ; // and the first element will have -1 index becuase itss left is null. // if not found any smaller element in left then store the -1 as index.
        
        for(int i = 1 ; i < n ; i++){ // starting from second element.
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){ /// if height of stack.peek is larger or equal to height of current element then we don't have exclude it. we have to find the height of element such that it is smaller. 
            // so we'll pop from stack and look again for smaller height.
                stack.pop();
            }
            
            if(stack.size() == 0 ){// when stack is null and we didn't find any element with smaller height then we'll consider -1 as index.
                lb[i] = -1;
            }
            else{// otherwise stack.peek is the value whose height is smaller.
                lb[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // now calculating the area.
        
        int maxArea = 0 ; 
        for(int i = 0 ; i<n ; i++){
            int width = rb[i] - lb[i]-1; // calculating the width 
            int area = width*heights[i]; // multipying the height wiht width.
            maxArea = Math.max(maxArea , area); // storing to the ans.
        }
        return maxArea;
    }
}
