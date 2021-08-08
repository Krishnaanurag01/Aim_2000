package Matrix;

public class SearchingIN2DMatrix_Q2 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}} ; 
        // int[][] matrix2 = {{1,3}};
        int target = 3;
        System.out.println(searchElement(matrix, target));
    }
    public static boolean searchElement(int[][] matrix , int target) {
        

        // initializing size.
        int n = matrix.length ;
        // initializing row.
        int i = 0 ;
        //initializing column.
        int j = matrix[0].length-1;

        while(i < n && j>=0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j]<target){
                i++;
            }
            else{
                j--;
            }
        }

        return false;
    }
    
}
