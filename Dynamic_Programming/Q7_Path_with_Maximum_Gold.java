package Dynamic_Programming;

public class Q7_Path_with_Maximum_Gold {
    

    public static void main(String[] args) {
        
    }

    public static int getPathWithMaxSum(int[][] arr) {
        
        int n = arr.length ; // row length
        int m = arr[0].length ; // column length
        int[][] dp = new int[n][m] ;

        for (int j = m - 1; j >= 0 ; j--) { // doing last column from 0th to last row then coming back to previous of last column.

            for (int i = n - 1; i >= 0 ; i--) { // traversing row.
            
                if(j == m-1) { // when we are on last column. then we'll store the same value which is on arr because we can't go any further column and so current gold will store.
                    dp[i][j] = arr[i][j] ;
                }
                else if(i == 0 && n == 1){ // when row is first and only one.

                    dp[i][j] =  dp[i][j+1]  + arr[i][j] ; // then add current row, col gold + next col gold.

                }
                else if(i == 0 && n > 1){ // when row is first but more than 1.

                    dp[i][j] = Math.max( dp[i][j+1] , dp[i+1][j+1] ) + arr[i][j] ; // then look next column  with current row and below row. find max and add  current gold.

                }
                else if( i == n-1){ // when row is last then look diagonaly above right and next col.

                    dp[i][j] = Math.max( dp[i][j+1] , dp[i-1][j+1] ) + arr[i][j] ; 

                }
                else{
                    // otherwise look diagonaly right above and below and next column , find max and add current gold.

                    dp[i][j] = Math.max( dp[i][j+1] , Math.max( dp[i+1][j+1] , dp[i-1][j+1] ) ) + arr[i][j] ; 

                }
            }

        }

        int max = dp[0][0] ; // now storing first row and first col total gold.
          
          for(int i = 1 ; i< n ; i++){  // and finding the max gold in first column.
              max = Math.max(max,dp[i][0]);
          }

        return max ;
    }
}
