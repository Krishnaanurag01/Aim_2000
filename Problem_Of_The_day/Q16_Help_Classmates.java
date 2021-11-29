package Problem_Of_The_day;
import java.util.*;

public class Q16_Help_Classmates {

    public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    if (arr == null || n == 0) {
	        return new int []{};
	    }
	    int [] result = new int [n];
	    Arrays.fill(result, -1);
	    Stack<Integer> stack = new Stack<>();
	    for (int i=0; i<n; i++) {
	        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
	            result[stack.pop()] = arr[i];
	        }
	        stack.push(i);
	    }
	    return result;
	} 
    
}
