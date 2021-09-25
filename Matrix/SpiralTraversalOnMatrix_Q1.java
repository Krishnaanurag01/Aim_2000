package Matrix;

public class SpiralTraversalOnMatrix_Q1 {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15,16}};

       int r = 4, c = 4 ; 
       spirallyTraversing(matrix, r, c);
    }

    // time complexicity : 0(row*column)
    
    public static void spirallyTraversing(int[][] arr, int row , int column) {


        // initializing a row pointer which starts from 0.
        int i = 0 ;

        // initializing a column pointer which starts from 0.
        int j = 0 ;


        while (i < row && j < column) {

            for (int j2 = j ;j2 < column ; j2++) {
                System.out.print(arr[i][j2]+" ");
            }
            i++;                
            System.out.println();

            for (int j2 = i ; j2 < row ; j2++) {
                System.out.print(arr[j2][column-1]+" ");
            }
            column--;              
            System.out.println();
            

            if(i < row){

                
                for (int j2 = column-1 ; j2 >= j; j2--) {
                    System.out.print(arr[row-1][j2]+" ");
                }
                row--;                
            }

            System.out.println();

            if (j < column) {
                
                
                for (int j2 = row-1; j2 >= i; j2--) {
                    System.out.print(arr[j2][j]+" ");
                }
                j++;
            }
            System.out.println();

            
        }
        
    }
}
