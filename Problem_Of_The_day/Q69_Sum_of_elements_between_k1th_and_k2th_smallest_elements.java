package Problem_Of_The_day;
import java.util.*;;

public class Q69_Sum_of_elements_between_k1th_and_k2th_smallest_elements {
    
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        PriorityQueue<Long> q1 = new PriorityQueue<>(Collections.reverseOrder() ) ;
        PriorityQueue<Long> q2 = new PriorityQueue<>(Collections.reverseOrder() ) ;
        
        for(int i = 0 ; i < A.length ; i++){
            if(q1.size() < K1 ){
                q1.add(A[i]) ;
            }
            else{
                if(q1.peek() > A[i] ){
                    q1.poll() ;
                    q1.add(A[i]) ;
                }
            }
            
            if(q2.size() < K2) {
                q2.add(A[i]) ;
            }
            else{
                if(q2.peek() > A[i] ){
                    q2.poll() ;
                    q2.add(A[i]) ;
                }   
            }
        }
        
        long val1 = q1.peek() ;
        long val2 = q2.peek() ;
        long sum = 0 ;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] > val1 && A[i] < val2) sum +=A[i] ;
        }
        return sum ;
    }

}
