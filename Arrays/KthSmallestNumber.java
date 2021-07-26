package Arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {2,5,7,1,9,3};
        System.out.println(kthSmallest(arr, 1));
    }
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);            
        }
        for (int i = k; i < arr.length; i++) {
            if(pq.peek()> arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }


        return pq.peek();
        
    }
}