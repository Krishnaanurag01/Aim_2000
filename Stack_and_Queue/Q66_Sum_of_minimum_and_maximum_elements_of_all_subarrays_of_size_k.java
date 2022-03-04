package Stack_and_Queue;

import java.util.ArrayList;
import java.util.Stack;

public class Q66_Sum_of_minimum_and_maximum_elements_of_all_subarrays_of_size_k {

    public static int SumOfKsubArray(int arr[] , int k){

        int n = arr.length ;

        int[] ngr = new int[arr.length] ;
        Stack<Integer> st = new Stack<>() ;
        ngr[n-1] = n ;
        st.push(n-1) ;

        for (int i = n-2 ; i >= 0 ; i--) {
            
            while (st.size() > 0 && arr[ st.peek() ] <= arr[i]) {
                st.pop() ;
            }

            if(st.size() == 0 ){
                ngr[i] = 0 ;
            }
            else{
                ngr[i] = st.peek() ;
            }

            st.push(i) ;
        }

        ArrayList<Integer> list = new ArrayList<>() ;

        int j = 0 ;

        for (int i = 0; i <= n - k ; i++) {

            if( j < i ){
                j = i ;
            }

            while (ngr[j] < i + k ) {
                j = ngr[j] ;
            }

            list.add(arr[j]) ;
            
        }

        int[] nse = new int[n] ;
        st = new Stack<>() ;
        nse[0] = -1 ;




        return 0 ;
    }
    
}
