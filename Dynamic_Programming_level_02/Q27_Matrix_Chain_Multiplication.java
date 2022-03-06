package Dynamic_Programming_level_02;

public class Q27_Matrix_Chain_Multiplication {

    public static void main(String[] args) {
        
    }

    public static int least_matrix_multiplication(int[] arr) {

        int n = arr.length ;

        // making arr.length - 1 dp as arr contains last index -1 and last index of array is n*m of last matrix. so last index is nothing but dimention of last matrix.
        int[][] dp = new int[n-1][n-1] ;

        for (int g = 0; g < dp.length; g++) { // using gap strategy . 
            // i is row and j is column.
            for (int i = 0 , j = g ; j < dp.length; i++,j++) {
                
                if(g == 0){ // when g = 0 then it means we have only one matrix so there's no need of multiplication.
                    dp[i][j] = 0 ;
                }
                else if(g == 1){ // if g = 1 then multiply first matrix(arr[i]) with second matrix (arr[j]).
                    // here arr[i] is r of first matrix and arr[j] is r of second matrix and arr[j+1] is m of second matrix.
                    // so formula is : r(first matrix row)*r(second matrix row)*m(second matrix column).
                    dp[i][j] = arr[i] * arr[j] * arr[j+1] ;
                }
                else{

                    int min = Integer.MAX_VALUE ; // else take a min.

                    for (int k = i ; k < j ; k++) { // now start from i to j - 1 
                        
                        int l = dp[i][k] ; // left is i to k
                        int r = dp[k+1][j] ; // right is k+1 to j
                        // left's  dimention is i to k ( so i * k+1) 
                        /// rights dimention is k+1 to j ( so k+1 * j+1)

                        // multiplying left * right
                        int m = arr[i] * arr[k+1] * arr[j+1] ; //so formula is : r(first matrix row)*r(second matrix row)*m(second matrix column).
                        int total = l + r + m ;
                        if( total < min ){
                            min = total ;
                        }
                    }

                    dp[i][j] = min ;
                }
            }
        }

        return dp[0][dp.length-1] ;
        
    }
    
}
