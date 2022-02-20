package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q2_N_Queens_Branch_And_Bound {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here
        boolean[] cols = new boolean[n] ; // it identify whether a given column is visited or not
        boolean[] ndiag = new boolean[2*n-1]; // it will identify whether the normal diagonal is visited or not
        boolean[] rdiag = new boolean[2*n-1]; // reverse diagonal visited or not
    
        helper(board,0, cols , ndiag , rdiag, ""); 

        scn.close();
        
      }
    
      static void helper(boolean[][] chess , int row , boolean[] cols , boolean[] ndiag , boolean[] rdiag, String psf ){
    
        if(row == chess.length){
            System.out.println(psf+".") ;
            return ;
        }
    
        for(int i = 0 ; i < chess[0].length ; i++){
    
            // when all 3 are not visited then we can place our queen.
          if(cols[i] == false && ndiag[ row + i ] == false && rdiag[ row - i + chess.length - 1 ] == false){ // here reverse diagonal elment is stored with sum of chess.length -1 so that all the index will remains positive
    
            // making visited so that there will not be any loop
            cols[i] = true ; 
            ndiag[row + i] = true ;
            rdiag[ row - i + chess.length - 1 ] = true ;
    
            // now checking for next row
            helper(chess,row+1,cols,ndiag,rdiag,psf+row+"-"+i+", ");
    
            // and unvisiting
            cols[i] = false ;
            ndiag[row + i] = false ;
            rdiag[ row - i + chess.length - 1 ] = false ;
    
          }
    
        }
    
      }

}
