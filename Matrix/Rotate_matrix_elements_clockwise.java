package Matrix;

import java.util.Arrays;

public class Rotate_matrix_elements_clockwise {


    public static void main(String[] args) {
        
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}} ;

        // Arrays.deepToString(arr) ;

        rotateMatrix(arr.length, arr[0].length, arr) ;

       System.out.println(  Arrays.deepToString(arr) ) ;

    }
    
    static int[][] rotateMatrix(int M, int N, int Mat[][]) {
        
        int row = 0 ;
        int col = 0 ;

        int lastRow = M ;
        int lastCol = N ;
        
        int prev = 0 ; // it's the previous value.

        while (row < lastRow && col < lastCol) {
            
            if(row + 1 == lastRow || col + 1 == lastCol) break ; // this will end the loop if only one element is left. when next row or col is lastrow or lastcol then break it.

            prev = Mat[row+1][col]  ; // taking the previous value.


            // this is spiral traversal with swapping previous value and updating current value with previous value.

            // from 0  -> n (col wise) 
            for (int i = col ; i < lastCol ; i++) {

                int temp = Mat[row][i] ;
                Mat[row][i] = prev ;
                prev = temp ;
            }
            
            row++ ;

            // from  0 -> n (row wise) 

            for (int i = row ; i < lastRow ; i++) {
                
                int temp = Mat[i][lastCol-1] ;
                Mat[i][lastCol-1] = prev ;
                prev = temp ;
                
            }
            lastCol-- ;

            if(col < lastCol){

            for (int i = lastCol-1 ; i >= col ; i--) {
                
                int temp = Mat[lastRow-1][i] ;
                Mat[lastRow-1][i] = prev ;
                prev = temp ;
                
            }
            
            lastRow-- ;

        }
            
            if(row < lastRow ){

            for (int i = lastRow-1 ; i >= row ; i--) {
                
                int temp = Mat[i][col];
                Mat[i][col] = prev ; 
                prev = temp ;
            }
            
            col++ ;
        }



        }


       System.out.println( Arrays.deepToString(Mat) ) ;



        return Mat ;
    }
}
