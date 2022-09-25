package Problem_Of_The_day;

public class Q238_Queries_on_a_Matrix {

    public int[][] solveQueries(int n, int[][] Queries) {
        int[][] ans = new int[n][n] ; 
        
        for(int[] q : Queries){
            int a1 = q[0] ;
            int b1 = q[1] ;
            int ci = q[2] ;
            int di = q[3] ;
            
            // going to each row from ai to ci and marking +1 in col1 and -1 on col2 + 1
            for(int i = a1 ; i <= ci ; i++){
                ans[i][b1] += 1 ;
                if(di < n - 1) ans[i][di+1] -= 1 ;
            }
        }
        
        // now summing up
        int sum = 0 ;
        for(int i = 0 ; i < n ; i++){
            sum = 0 ;
            for(int j = 0 ; j < n ; j++){
                sum += ans[i][j] ;
                ans[i][j] = sum ;
            }
        }
        
        return ans ;
    }
}
