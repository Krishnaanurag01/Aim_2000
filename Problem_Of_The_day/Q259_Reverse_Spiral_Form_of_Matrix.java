package Problem_Of_The_day;

public class Q259_Reverse_Spiral_Form_of_Matrix {

    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // simpley traverse the matrix and store the answer from back side.
        
        int[] ans = new int[R*C] ;
        R = R-1 ;
        C -= 1 ;
        int m = 0 ;
        int n = 0 ;
        int k = ans.length - 1 ;
        
        while(m <= R && n <= C){
            
            for(int j = n ; j <= C; j++){
                ans[k--] = a[m][j] ;
            }
            m++ ;
            
            for(int i = m ; i <= R ; i++){
                ans[k--] = a[i][C] ;
            }
            
            C-- ;
            
            if(R < m) continue ;
            for(int j = C ; j >= n; j--){
                ans[k--] = a[R][j] ;
            }
            
            R-- ;
            
            if(C < n) continue ;
            for(int i = R ; i >= m ; i--){
                ans[k--] = a[i][n] ;
            }
            
            n++;
        }
        
        
        return ans ;
    }
}
