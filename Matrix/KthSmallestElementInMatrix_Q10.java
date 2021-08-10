package Matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInMatrix_Q10 {
    public static void main(String[] args) {
        
    }

    public static int getKthSmallestElement(int[][] matrix , int k ) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < k ; i++) {
            queue.add(matrix[i][i])
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(matrix[i][j]);
            }
        }




        return 0 ;
    }
}
