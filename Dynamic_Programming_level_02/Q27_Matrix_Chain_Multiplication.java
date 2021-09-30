package Dynamic_Programming_level_02;

public class Q27_Matrix_Chain_Multiplication {

    public static void main(String[] args) {
        
    }

    public static int least_matrix_multiplication(int[] arr) {

        int n = arr.length ;

        int[][] dp = new int[n-1][n-1] ;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0 , j = g ; j < dp.length; i++,j++) {
                
                if(g == 0){
                    dp[i][j] = 0 ;
                }
                else if(g == 1){
                    dp[i][j] = arr[i] * arr[j] * arr[j+1] ;
                }
                else{

                    int min = Integer.MAX_VALUE ;

                    for (int k = i ; k < j ; k++) {
                        
                        int l = dp[i][k] ;
                        int r = dp[k+1][j] ;
                        int m = arr[i] * arr[k+1] * arr[j+1] ;
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
