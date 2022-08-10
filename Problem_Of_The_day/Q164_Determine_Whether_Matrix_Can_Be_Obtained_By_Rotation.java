package Problem_Of_The_day;

public class Q164_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        
        boolean needRotation = false;
        //  comparing both the matrix if they are same intially.
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat.length ; j++){
                if(mat[i][j] != target[i][j]){
                    needRotation = true ;
                    break;
                } 
            }
        }
        
        if(needRotation == false) return true; // if both are same already then return true.
        
        //A matrix can be rotate 3 time before coming to original place.
        for(int rotate = 1;  rotate <= 3; rotate++){
            
            // Step 01 : first changing ij to jI.
            for(int i = 0 ; i < mat.length ; i++){
                for(int j = 0 ; j < i ; j++){
                    int temp = mat[i][j] ;
                    mat[i][j] = mat[j][i] ;
                    mat[j][i] = temp ; 
                }
            }
            
            boolean flag = true ;
            
            // Step 02 : now converting to rotate
            for(int i = 0 ; i < mat.length ; i++){
               int l = 0 ;
               int r = mat[0].length - 1 ;
            
               while( l < r){
                   int temp = mat[i][l] ;
                   mat[i][l] = mat[i][r] ;
                   mat[i][r] = temp ;
                   l++;
                   r--;
               }
             // after the ith row is rotated compare the ith row in both matrix 
                for(int j = 0 ; j < mat[0].length && flag == true; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                    }
                }
            }
            
            
            if(flag) return true;
        }
    
        return false;
    }
}
