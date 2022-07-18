package Problem_Of_The_day;

public class Q100_Surrounded_Regions {

    public void solve(char[][] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length] ;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if((i == 0 || j == 0 || i == board.length-1 || j == board[0].length - 1)&& board[i][j] == 'O' && visited[i][j] == false){
                    helper(i,j,board,visited) ;
                }
            }
        }


        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(visited[i][j] == false){
                   board[i][j] = 'X' ;
                }
            }
        }

        
    }
    
    int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}} ;
    
    boolean helper(int i, int j, char[][] board, boolean[][] visited){
        
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length ) return false ;
        if(board[i][j] == 'X' || visited[i][j] ) return true ;
        visited[i][j] = true ;
        
        
        for(int x = 0 ; x < 4 ; x++){
            int row = i + direc[x][0] ;
            int col = j + direc[x][1] ;
            
            helper(row,col,board,visited) ;
        }
        return true ;   
    }
}
