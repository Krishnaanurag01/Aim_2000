package Dynamic_Programming_extras;

/**
 * Q71_Count_Submatrices_With_All_Ones
 */
public class Q71_Count_Submatrices_With_All_Ones {

    public int numSubmat(int[][] mat) {
        
        // do preprocessing of consectuive 1's for each row.
        int[][] prepro = new int[mat.length][mat[0].length] ;
        
        for(int i = 0 ; i < mat.length ; i++){
            int conse = 0 ;
            for(int j = mat[0].length-1 ; j >= 0 ; j--){
                
                if(mat[i][j] == 1){
                    conse++ ;
                }
                else{
                    conse = 0 ;
                }
                prepro[i][j] = conse ;
            }
        }
        
        int ans = 0 ;
        
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = mat[0].length-1 ; j >= 0 ; j--){
           
                int min = (int)1e9 ;
               // check consecutive 1's in each row for same column and take the min one.
                for(int k = i ; k < mat.length; k++){
                    min = Math.min(min,prepro[k][j]);
                    ans += min ;
                }
               
            }
        }
        
        return ans ;
    }
}