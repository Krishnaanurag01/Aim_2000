package Problem_Of_The_day;

public class Q224_Count_occurences_of_a_given_word_in_a_2d_array {
    
    public int findOccurrence(char mat[][], String target)
    {
        int count = 0 ;
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                
                if(mat[i][j] == target.charAt(0)){
                   
                   count += helper(i,j,mat,target, 0) ;
                }
            }
        }
        
        return count; 
    }
    
    
    int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}} ;
    
    int helper(int i, int j, char[][] matrix, String target, int idx){
        
        if(i >= matrix.length || i < 0 || j < 0 || j >= matrix[0].length || matrix[i][j] == '#') return  0 ;
        char ch = matrix[i][j] ; 
        if(ch != target.charAt(idx)) return  0 ;
        if(idx >= target.length() - 1) return 1 ;
        
        int count = 0 ;
        matrix[i][j] = '#' ;
        
        for(int[] d : direc){
            int row = i + d[0] ;
            int col = j + d[1] ;
    
            count += helper(row, col, matrix, target, idx+1) ;
        }
        
        matrix[i][j] = ch ;
        
        return count ;
    }
}
