package Problem_Of_The_day;

import java.util.Arrays;

public class Q33_Rotate_by_90_degree {
    

    public static void main(String[] args) {
        
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        } ;

        rotate(matrix);
    }


    static void rotate(int matrix[][]) 
    {
        
        for(int i = 0 ; i < matrix.length ; i++){
            for (int j = 0; j < i ; j++) {
                int temp = matrix[i][j] ;
                matrix[i][j] = matrix[j][i] ;
                matrix[j][i] = temp ;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            
            int st = 0 ;
            int ei = matrix.length - 1 ;

            while (st < ei) {
                int temp = matrix[st][j] ;
                matrix[st][j] = matrix[ei][j] ;
                matrix[ei][j] = temp ;

                st++ ;
                ei--;
            }
        }




       System.out.println( Arrays.deepToString(matrix) );
    }
}
