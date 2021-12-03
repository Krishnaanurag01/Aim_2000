package Stack_and_Queue_level01;
import java.util.*;

public class Q7_Maximum_of_all_subarrays_of_size_k {

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>() ;

        Stack<Integer> stack = new Stack<>() ;

        stack.push(n-1) ;
        int[] ng = new int[n] ;
        ng[n-1] = n ;

        for (int i = n-2 ; i >= 0 ; i--) {
            
            while (stack.size() > 0 && arr[stack.peek()] <= arr[i]) {
                stack.pop() ;
            }

            if(stack.empty()){
                ng[i] = n ;
            }
            else{
                ng[i] = stack.peek() ;
            }

            stack.push(i) ;
        }


        int j = 0 ;

        for (int i = 0; i <= ng.length - k ; i++) {
            
            if(j < i){
                j = i ;
            }

            while (ng[j] < i + k) {
                j = ng[j] ; // getting next greater value index .
            }

            ans.add(arr[j]) ; // adding value[j]
        }



        return ans ;
    }
    
}
