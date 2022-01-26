package Arrays_and_string_level_02;

public class Q76_Word_Search {

    public boolean exist(char[][] board, String word) {
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                
                if(board[i][j] == word.charAt(0) ){
                    
                    boolean ans = helper(board,word,i,j,1) ;

                    if(ans == true) return true ;
                }
            }
        }
        
        return false ;
    }
    
    int[][] direc = {{0,1},{1,0},{-1,0},{0,-1}} ;
    
    public boolean helper(char[][] board , String word , int row , int col , int curr){
        
        if(curr == word.length()) return true ; // base case
        
        char ch = board[row][col] ; // backing up
        board[row][col] = '0' ; // making visited
        
        boolean correct = false ;
        
        for(int i = 0 ; i < 4 ; i++){
            int nextRow = row + direc[i][0] ;
            int nextCol = col + direc[i][1] ;
            
            if(nextRow < board.length && nextRow >= 0 && nextCol >= 0 && nextCol < board[0].length && board[nextRow][nextCol] == word.charAt(curr) ){
               boolean temp = helper(board,word,nextRow,nextCol,curr+1) ;
                
                if(temp) {
                    correct = true ;
                    board[row][col] = ch ;
                    return true ;
                }
            }
        }
        
        board[row][col] = ch ;     // unvisited
        
        return correct;
    }
    
}
