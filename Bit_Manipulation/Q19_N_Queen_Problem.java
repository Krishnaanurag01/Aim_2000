package Bit_Manipulation;
import java.util.*;

public class Q19_N_Queen_Problem {

    static ArrayList<ArrayList<Integer>> ans ;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        
        ans = new ArrayList<>() ;
        
        boolean[][] board = new boolean[n][n] ;
        int cols = 0 ; // helps in identifying the column.
        int ndiag = 0 ; // helps in identifying the normal diagonal
        int rdiag = 0 ; // helps in identifying the reverse diagonal
        
        solve(board,0,cols,ndiag,rdiag,new ArrayList<>()) ;
        
        return ans;
    }
    
    
    static void solve(boolean[][] board, int row , int cols,int ndiag,int rdiag, ArrayList<Integer> list){
        
        if(row == board.length){
            ans.add( new ArrayList<>(list) ) ;
            return ; 
        }
        
        
        for(int j = 0 ; j < board.length ; j++){
            
            // checking if jth bit is off in cols and row + j bit is off in normal diagonal and (row-col+length-1) bit is off in reverse diagonal.
            if( ( cols & (1 << j)) == 0 && ( ndiag & ( 1 <<  row + j )) == 0 &&
                ( rdiag & (1 << (row - j + board.length - 1)) ) == 0 )
            {
                // making visited
                board[row][j] = true ;
                cols = cols ^ (1 << j) ;
                ndiag = ndiag ^ (1 << row + j) ;
                rdiag = rdiag ^ ( 1 << ( row - j + board.length - 1)) ;
                
                list.add(j+1) ; // adding to list by making it 1 based indexing
                
                  solve(board,row + 1 ,cols,ndiag,rdiag, list ) ;
                
                  // now removing last inserted and unvisiting
                list.remove( list.size() - 1 ) ;
                board[row][j] = false;
                 cols = cols ^ (1 << j) ;
                ndiag = ndiag ^ (1 << row + j) ;
                rdiag = rdiag ^ ( 1 << row - j + board.length - 1) ;
                
                
            }
            
        }
    }

    // method 02 : takes O(1) solution.

    // same as above, just didn't made the boolean board array as it is no longer required with bit manipulation.

    // static ArrayList<ArrayList<Integer>> ans ;
    // static ArrayList<ArrayList<Integer>> nQueen(int n) {
    //     // code here
        
    //     ans = new ArrayList<>() ;
    
    //     int cols = 0 ;
    //     int ndiag = 0 ;
    //     int rdiag = 0 ;
        
    //     solve(n,0,cols,ndiag,rdiag,new ArrayList<>()) ;
        
    //     return ans;
    // }
    
    
    // static void solve(int board, int row , int cols,int ndiag,int rdiag, ArrayList<Integer> list){
        
    //     if(row == board){
    //         ans.add( new ArrayList<>(list) ) ;
    //         return ; 
    //     }
        
        
    //     for(int j = 0 ; j < board ; j++){
            
    //         if( ( cols & (1 << j)) == 0 && ( ndiag & ( 1 <<  row + j )) == 0 &&
    //             ( rdiag & (1 << (row - j + board- 1)) ) == 0 )
    //         {
               
    //             cols = cols ^ (1 << j) ;
    //             ndiag = ndiag ^ (1 << row + j) ;
    //             rdiag = rdiag ^ ( 1 << ( row - j + board - 1)) ;
                
    //             list.add(j+1) ;
                
    //               solve(board,row + 1 ,cols,ndiag,rdiag, list ) ;
                
    //             list.remove( list.size() - 1 ) ;
              
    //              cols = cols ^ (1 << j) ;
    //             ndiag = ndiag ^ (1 << row + j) ;
    //             rdiag = rdiag ^ ( 1 << row - j + board - 1) ;
                
                
    //         }
            
    //     }
    // }
    
}
