package Problem_Of_The_day ;
import java.util.*;
public class Q366_Minimize_Deviation_in_Array {
    public int minimumDeviation(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);
     
     // as odd * 2 => even so convert all the odd*2 and add in pq
     
        int min = Integer.MAX_VALUE ;
        int res = Integer.MAX_VALUE ;
        
       for (int a : A) {
            if (a % 2 == 1) a *= 2; // agar odd hai toh 2nd operation perform kar k even bna do aur pq me add kar do
            pq.add(a);
            min = Math.min(min, a); // also ek min value ko store kar k rhkho
        }
     
        while (pq.peek() % 2 == 0) { // jab tak max value even hai tb tak usko use karo
            int a = pq.poll();
            res = Math.min(res, a - min); // take the min deviation
            min = Math.min(min, a / 2); // update min
            pq.add(a / 2); // perform 1st operation
        }
     
        return Math.min(res, pq.peek() - min);
    }
}
