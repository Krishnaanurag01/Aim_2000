package Arrays_and_string;

public class Q60_Battleships_in_a_Board {

    public int countBattleships(char[][] board) {
        
        int count = 0 ;
        int m = board.length ;
        int n = board[0].length ;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                
                
                if(board[i][j] == 'X')  // if current cell has x.
                {
                                    
                    if(i == 0 && j == 0){  // if it is first row and first col then simply increase the count.
                       count++ ;
                    }
                    else if(i == 0 ){ // when at first row then check previous column
                        if(board[i][j-1] != 'X')
                            count++ ;
                    }
                    else if(j == 0 ){ // when first col then check previous row
                        if(board[i-1][j] != 'X')
                            count++ ;
                    }
                    else{
                    
                        // elese check both upper row with same col and same row with previous column.
                        if( board[i][j-1] != 'X' && board[i-1][j] != 'X')
                            count++ ;
                            
                    }
                    
                    
                }
                
            }
        }
        
        return count ;
    }
    
}
