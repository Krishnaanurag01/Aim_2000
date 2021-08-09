package Matrix;

import java.util.ArrayList;
import java.util.Collections;



public class PrintingElementOfsortedMatrix_Q5 {
    public static void main(String[] args) {
        int[][] arr = { { 5, 4, 7 },
        { 1, 3, 8 },
        { 2, 9, 6 } };

        printInSortedOrder(arr, 3, 3);
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] +" ");
            }
        }
        
    }
    public static void printInSortedOrder(int[][] Matrix ,int row , int column) {

      ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < column; j++) {
               list.add(Matrix[i][j]);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < column; j++) {
                Matrix[i][j] = list.remove(0);
            }
            
        }
    }
}
