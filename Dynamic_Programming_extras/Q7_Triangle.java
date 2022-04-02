package Dynamic_Programming_extras;

public class Q7_Triangle {

    public static int minimumPathSum(int[][] triangle, int n) {
        // we have to start from 1st row and 1st col (bottom up approch) becuase in the last row there are multiple cols so we won't be able to choose answer easily.
        return helper( 0, 0 , triangle);
    }
    
    static int helper(int idx,int col, int[][] triangle){
        if(idx == triangle.length - 1 ){ // when on last row 
          return triangle[idx][col] ;   // return it's cell value
        } 
        
       int bottom = helper(idx+1,col,triangle); // going bottom with same col
       int br = helper(idx+1,col+1,triangle); // going bottom with col+1 
        return Math.min(bottom,br) + triangle[idx][col]; // chosing min + cell value.
    }
    
}
