package Matrix;

public class Spiral_Matrix_II {
    
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n] ;
        
        int val = 1 ;
        
        int i = 0 ;
        int m = n - 1;
        
        int j = 0 ;
        int k = n - 1 ;
        
        while(val <= n*n){
            
            for(int p = j ; p <= k ; p++){
                ans[i][p] = val ;
                val++ ;
            }
            i++ ;
            
            for(int p = i ; p <= m ; p++){
                ans[p][k] = val ;
                val++ ;
            }
            k-- ;
            
            for(int p = k ; p >= j ; p--){
                ans[m][p] = val ;
                val++ ;
            }
            m--;
            
            
            for(int p = m ; p >= i ; p--){
                ans[p][j] = val ;
                val++ ;
            }
            j++ ;
        }
        
        return ans ;
    }
}
