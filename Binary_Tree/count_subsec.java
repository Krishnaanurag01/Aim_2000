package Binary_Tree;

public class count_subsec {

    // akshita's question

    public static void main(String[] args) {

        int[] A = {2,7} ;
        int[] B = {7,2} ;

        System.out.println( count(A, B, 2, 2));

    }

    public static int count(int[] A , int[] B , int n , int m) {
        
        int[][] dp = new int[n+1][m+1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(i == 0 && j == 0){
                    dp[i][j] = 0 ;
                }
                else if(j == 0){
                    dp[i][j] = 0 ;
                }
                else if(i == 0){
                    dp[i][j] = 0 ;
                }
                else{
                    dp[i][j] =  dp[i][j-1] + dp[i-1][j]  ;

                    if(A[i-1] == B[j-1]){
                        dp[i][j] +=  1 ; 
                    }
                    else{
                        dp[i][j] -= dp[i-1][j-1]  ;
                    }
                }
            }
        }

        return dp[n][m] + 1;
    }
    
}
