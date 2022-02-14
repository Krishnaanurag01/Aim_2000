package Dynamic_Programming_level_02;

public class Q4_Maximum_size_square_sub_matrix_with_all_1s {
    public static void main(String[] args) {
        
        
    }

    
    public static int get_largest(int[][] mat,int n , int m){
        
        int[][] dp = new int[n][m] ;
        int ans = Integer.MIN_VALUE ;

        // starting from bottom right.
        
        for(int i = n-1 ; i >=0 ; i--){
            
            for(int j = m-1 ; j>=0 ; j--){
                

                if(i == n-1){  // when at the last row. store the data as it is given
                    dp[i][j] = mat[i][j] ;
                    ans = Math.max(ans,dp[i][j]) ; // updating answer.
                }
                else if(j == m-1){  // when last column store as it is.
                    dp[i][j] = mat[i][j] ;
                    ans = Math.max(ans,dp[i][j]) ;// updating answer.
                }
                else{
                    if(mat[i][j] == 1){ // now check if current mat is 1 then search min in next col , next rows next col and next row current col. and add min with 1 (this is current mat data.)
                    dp[i][j] = Math.min(dp[i][j+1] , Math.min(dp[i+1][j] , dp[i+1][j+1])) + 1 ;
                    ans = Math.max(ans,dp[i][j]) ;// updating answer.
                }
                }
            }
        }
        
        return ans ;
    }


    // method 02 : takes o(1) extra space 👀
    // here using the same given array for storing result(as dp array)

    public int maximalSquare(char[][] matrix) {
        
        int max = 0 ;
        int n = matrix.length ;
        int m = matrix[0].length ;
        
        
        for(int i = n-1 ; i >= 0 ; i-- ){
            for(int j = m-1 ; j>= 0 ; j--){
                 char current = matrix[i][j] ;
                
                if( i == n-1 && j == m-1){ // bottom most and right most cell
                 max = Math.max(max, matrix[i][j] - '0') ;
                    continue ;
                }
                else if( i == n-1){ // when last row
                    max = Math.max(max, matrix[i][j] - '0') ;   
                    continue ;
                }
                else if(j == m-1){ // when last col
                 max = Math.max(max, matrix[i][j] - '0') ;   
                    continue ;
                }
                
                
                if(current == '1'){
                    int r = matrix[i][j+1] -'0' ;
                    int d = matrix[i+1][j+1] - '0';
                    int b = matrix[i+1][j] - '0';
                    
                    if(r >= 1 && d >= 1 && b >= 1 ){
                        int min = Math.min(r,Math.min(d,b)) ;
                        int ch = (min + 1) + '0' ;
                        matrix[i][j] = (char) ch ;
                        max = Math.max(max,min+1) ;
                    }
                    else{
                        max = Math.max(max,1) ;
                    }
                }


            }
        }
        
        return max*max ;
    }
}
