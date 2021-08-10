package Matrix;

public class TransposeOfNxNMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{11,12,13},{21,22,23},{31,32,33}};
        makeTranspose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void makeTranspose(int[][] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i ; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
