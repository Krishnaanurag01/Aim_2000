package Matrix;

import java.util.HashMap;

public class Common_elements_in_all_rows_of_a_given_matrix_Q10 {
    public static void main(String[] args) {
        int mat[][] =
    {
        {1, 2, 1, 4, 8},
        {3, 7, 8, 5, 1},
        {8, 7, 7, 3, 1},
        {8, 1, 2, 7, 9},
    };

    printCommonElements(mat);
 
    }
    public static void printCommonElements(int[][] matrix) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        // storing the first row value with frequency 1.
        for (int i = 0; i < matrix[0].length; i++) {
            map.put(matrix[0][i],1);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                
                // if(map.containsKey(matrix[i][j] ))

                if(map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i ){

                    // then i'll increament the common values.
                    map.put(matrix[i][j],map.get(matrix[i][j])+1);

                    // now checking if it is the last row . if it is the last row then we'll print the element which are available in hashmap so far.

                    if( i == matrix.length -1 ){
                        // if it is the last row then printing the elements.

                        System.out.println(matrix[i][j]);
                    }
                }
            }
        }

    }
}
