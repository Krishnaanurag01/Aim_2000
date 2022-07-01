package Problem_Of_The_day;

public class Q74_Matrix_Exponentiation {

    int mod = (int)1e9+7 ;
    public int FindNthTerm(int n)
    {
       long[][] matrix = {{1,1},{1,0}} ; // initial matrix
       matrix = sol(matrix,n);
       return (int)matrix[0][0] ; 
    }
    
    long[][] sol(long[][] a, int n){
        if(n == 1) return a ;
        long[][] temp = sol(a,n/2) ; // getting for n/2 power
        
        if(n % 2 == 0) return multiply(temp,temp) ; // if power is even then multiply same temp
        
        return multiply(temp, multiply(temp,a) ) ; // else when power is odd perform extra multiplication with a
    }
    
    private long[][] multiply(long a[][], long b[][]){
        long arr[][] = new long[2][2];
        arr[0][0] = (a[0][0]*b[0][0]+a[0][1]*b[1][0])%mod;
        arr[0][1] = (a[0][0]*b[0][1]+a[0][1]*b[1][1])%mod;
        arr[1][0] = (a[1][0]*b[0][0]+a[1][1]*b[1][0])%mod;
        arr[1][1] = (a[1][0]*b[0][1]+a[1][1]*b[1][1])%mod;
        return arr;
    }

    // mutliplication iteratively
    // int[][] iterative_multiply(int[][] m1, int[][] m2){
    //     int[][] ans = new int[2][2] ;
        
    //     for(int i = 0 ; i < 2 ; i++){
    //         for(int j = 0 ; j < 2 ; j++){
    //             for(int k = 0 ; k < 2 ; k++){
    //                 ans[i][j] += (m1[i][k]*m2[k][j])  ;
    //             }
    //         }
    //     }
    //     return ans ;
    // }
}
