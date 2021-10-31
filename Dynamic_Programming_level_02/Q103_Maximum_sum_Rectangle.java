package Dynamic_Programming_level_02;

public class Q103_Maximum_sum_Rectangle {

    public static void main(String[] args) {

        int[][] matrix = new int[][] { { 1, 2, -1, -4, -20 },
        { -8, -3, 4, 2, 1 },
        { 3, 8, 10, 1, 3 },
        { -4, -1, 1, 7, -6 } }; 

        get_maximum_sum_rect(matrix.length, matrix[0].length , matrix);
        
    }

    public static int get_maximum_sum_rect(int m , int c , int[][] matrix) {
        
        int max = Integer.MIN_VALUE ; // this will contain the max answer.

        for (int i = 0; i < m; i++) { // for each row we'll create an array of size arr[col].
            int[] ans = new int[c] ;

            for (int j = i ; j < m ; j++) { // traversing row from i to m
                for (int k = 0; k < c; k++) {  // each row values adding with previous value presum in ans.
                    ans[k] += matrix[j][k] ;
                }

                max = Math.max(max,  kadanes(ans)) ; // and also finding max sum subarray concurrently.
            }
        }

        return max ; 
    }


    // kadanes also :
    
    private static int kadanes(int[] ans) {

        int best_sum = ans[0] ;
        int current_sum = ans[0] ;

        for (int i = 1 ; i < ans.length; i++) {
            current_sum += ans[i] ;

            if(current_sum < ans[i]){
                current_sum = ans[i] ;
            }

            if(best_sum < current_sum ){
                best_sum = current_sum ;
            }
        }


        return best_sum;
    }
    
}
