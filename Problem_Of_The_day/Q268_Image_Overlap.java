package Problem_Of_The_day ;

public class Q268_Image_Overlap {
    
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int maxoverlap = 0 ;
        
        for(int i = -img1.length + 1; i < img1.length ; i++){
            for(int j = -img1.length + 1; j < img1.length ; j++){
                maxoverlap = Math.max(maxoverlap, helper(img1,img2,i,j)) ;
            }
        }
        
        
        return maxoverlap ;
    }
    
    int helper(int[][] a1, int[][] a2, int rowOff, int colOff){
        
        int count = 0 ;
        
        for(int row = 0 ; row < a1.length ; row++){
            for(int col = 0 ; col < a1.length ; col++){
                if( (row + rowOff <  0 || row + rowOff >= a1.length) || (col + colOff < 0 || col + colOff >= a1.length)) continue ;
                
                if(a1[row][col] + a2[row+ rowOff][col + colOff]  == 2) count++ ;
            }
        }
      
        return count ;
    }
}
