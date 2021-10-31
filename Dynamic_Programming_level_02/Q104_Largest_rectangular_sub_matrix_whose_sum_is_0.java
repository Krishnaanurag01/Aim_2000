package Dynamic_Programming_level_02;

import java.util.HashMap;

public class Q104_Largest_rectangular_sub_matrix_whose_sum_is_0 {

    public static void main(String[] args) {

        int[][] matrix = { { 9, 7, 16, 5 }, { 1, -6, -7, 3 },
        { 1, 8, 7, 9 }, { 7, -2, 0, 10 } }; 

        get_largest_matrix_with_sum_zero(matrix);
        
    }

    public static void get_largest_matrix_with_sum_zero(int[][] matrix) { // this function is same as Q103.

        int ans = 0 ;
        int first_row = 0 , last_row = 0 , first_col = 0, last_col = 0  ; // took these variable so that we can print the matrix elements.

        // same loop as Q103
        for (int i = 0; i < matrix.length; i++) {
            
            int[] presum = new int[matrix[0].length] ;

            for (int j = i ; j < matrix.length ; j++) {
                for (int k = 0; k < matrix[0].length ; k++) {
                    presum[k] += matrix[j][k] ; 
                }

                int[] bredthArr = get_bredth(presum) ; // here we are finding the breadth with starting col and ending col.

                if( bredthArr[0]*(j-i+1) > ans ){ // if bredth * length is greater than previous answer then update the answer.

                    ans = bredthArr[0]*(j-i+1) ; // updating the area of rectanlge.(length*breadth).
                    first_row = i ; 
                    last_row = j ;
                    first_col = bredthArr[1];
                    last_col = bredthArr [2] ;
                }
                
            }
        }

        System.out.println( ans );

        printMatrix(matrix , first_row , last_row , first_col , last_col) ;  // this will print the largest sub matrix with 0 sum.
        
    }

    private static void printMatrix(int[][] matrix, int first_row, int last_row, int first_col, int last_col) {

        for (int i = first_row ; i <= last_row; i++) {
            for (int j = first_col;  j <= last_col; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] get_bredth(int[] presum) { // this function is same as Question "Find if there is any subarray with sum equal to 0."

        int ans = 1 ; // gave 1 by default
        HashMap<Integer,Integer> map = new HashMap<>() ; // for storing the index of presum's .
        int sum = 0 ;
        int first_col = 0, last_col = 0 ;

        for (int i = 0; i < presum.length; i++) {
            
            sum += presum[i] ; // adding value with sum.

            if(sum == 0){ /// if sum becomes 0 
               if( ans < i+1){ // and  is of larger size than previous answer then update it.

                ans = i+1 ;
                first_col = 0 ;
                last_col = i ;

               }
            }
            else if(map.containsKey(sum)){  // if sum is already present in hashmap then  it means we got zero from previous presum to current index.
               
                if( ans < i - map.get(sum)){  // if current answer is greater than previous answer then update it.
                    ans =  i - map.get(sum) ; // findig the size.

                    first_col = map.get(sum) + 1;
                    last_col = i ;
                }
                
            }
            else{
                map.put(sum, i) ;  // putting presum with index in map.
            }
            
        }


        // System.out.println(ans);
        return new int[]{ans, first_col , last_col} ; // returning all three through an Array.
    }
    
}
