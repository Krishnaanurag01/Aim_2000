package Problem_Of_The_day;

import java.util.Arrays;


public class Q31_Largest_rectangle_of_1s_with_swapping_of_columns_allowed {


    public static void main(String[] args) {
        

        boolean[][] mat = {
            {true , false , true, true},
            {false,false,true,true},
            {true,true,true,false}

        } ;

        maxArea(mat,3,4) ;

        

    }

    static int maxArea(boolean[][] mat, int r, int c) {
       
        int[][] preSum = new int[r][c] ;

        // step 01 : count the consequtive 1's column wise and store in new presum matrix.
        // as we can only swap col thats why we are counting col wise.

        for (int j = 0; j < c ; j++) {
            
            int oneCount = 0 ;

            for (int i = 0; i < r ; i++) {

                if(mat[i][j] == true){
                    oneCount++ ;
                }
                else{
                    oneCount = 0  ;
                }

                preSum[i][j] = oneCount ;
            }
        }

        System.out.println( Arrays.deepToString(preSum) );


        // step 02 : now sort each row of the array in non-increasing order.

        for (int i = 0; i < r; i++) {
            Arrays.sort(preSum[i] );

            int l = 0 ;
            int right = c-1 ;

        // System.out.println( Arrays.deepToString(preSum) );

            while (l < right) {
                int temp = preSum[i][l] ;
                preSum[i][l] = preSum[i][right] ;
                preSum[i][right] = temp ;

                l++ ;
                right-- ;
            }

        }


        // System.out.println( Arrays.deepToString(preSum) );



        // now find the max area by formula : (col+1)*presum[i][j]. for eg : one of the row has value : {3,3,1,0} so we if we cal for 3(1st col) by formula : (1+1(making 1 based indexing)* presum[i][j] => 2*3 => 3 which is max) 

        int max = 0 ;

        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c ; j++) {
                max = Math.max(max, (j+1)*preSum[i][j]) ;
            }
        }

        // System.out.println(max);

        // System.out.println( Arrays.toString(preSum) );

        return max ;
    }
    
}
