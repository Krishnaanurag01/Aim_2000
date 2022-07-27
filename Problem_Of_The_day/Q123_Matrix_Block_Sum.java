package Problem_Of_The_day ;

public class Q123_Matrix_Block_Sum {
    
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int[][] ans = new int[mat.length][mat[0].length] ;
        
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                for(int x = -k ; x <= k ; x++){ // going -k to +k in row and for each element adding element value in left side (so that on sum it will be included in the range) and subtracting at j+k+1 right index(so that it won't get included in outer side)
                    
                    if(i+x >= 0 && i+x < mat.length){ 
                        
                        int left = Math.max(j-k,0) ;
                        int right = j+k+1 ;
                        
                        ans[i+x][left] += mat[i][j] ;
                        if(right < mat[0].length)
                        ans[i+x][right] -= mat[i][j] ;
                        
                    }
                }
            }
        }
        
        
        // now summing up
        int sum = 0 ;
        for(int i = 0 ; i < mat.length ; i++){
            sum = 0 ;
            for(int j = 0 ; j < mat[0].length ; j++){
                sum += ans[i][j] ;
                ans[i][j] = sum ;
            }
        }
        
        return ans ;
    }
}
