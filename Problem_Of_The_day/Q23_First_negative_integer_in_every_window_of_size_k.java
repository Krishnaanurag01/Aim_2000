package Problem_Of_The_day;

import java.util.LinkedList;
import java.util.Queue;

public class Q23_First_negative_integer_in_every_window_of_size_k {


    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> q = new LinkedList<>() ;
        long[] ans = new long[N-K+1] ; // total windows
        int m = 0 ; // pointer for ans array

        for (int i = 0; i < K-1 ; i++) {
            if(A[i] < 0 ) q.add(A[i]) ; // adding k-1 element to the queue .
        }

        for (int i = K - 1 ; i < N ; i++) {
            if(A[i] < 0 ) q.add(A[i]) ; // if element is negative then add it to the queue

            if(!q.isEmpty()){ // if queue is not empty then do this
                ans[m++] = q.peek(); // adding front of queue in ans array
                if(A[i-K+1] == q.peek()){ // if front element of que is equals to the starting element of window then remove it.
                    q.poll() ;
                }
            }
            else{ // else add 0
                ans[m++] = (long) 0 ;
            }
        }
     
        
        return ans ;
    }
    
}
