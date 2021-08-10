package Matrix;

public class RotateMatrixBy90Degree_Q9 {

    public static void main(String[] args) {
        
        int arr[][] = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };

        rotateItBy90(arr);

        // displaying matrix.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotateItBy90(int[][] matrix ) {
        
        // first transpose the matrix and then reverse it.

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp ;
            }
        }

        // now reverse each column of every row.

        for (int i = 0; i < matrix.length; i++) {
            int left = 0 ;
            int right = matrix[i].length - 1;

            while (left < right) {
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left]  = temp;

                right--;
                left++;
            }
        }
    }
    
}
