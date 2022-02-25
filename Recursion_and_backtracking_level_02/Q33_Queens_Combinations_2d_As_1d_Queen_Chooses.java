package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q33_Queens_Combinations_2d_As_1d_Queen_Chooses {

    
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        
        if( qpsf == tq ){
            for(int row = 0 ; row < chess.length ; row++){
                for(int col = 0 ; col < chess.length ; col++){
                    if(chess[row][col] == false){
                        System.out.print("-\t");
                    }else{
                        System.out.print("q\t");
                    }
                }
                System.out.println() ;
            }
                System.out.println() ;


            return ;
        }


        for(int cell = lcno + 1 ; cell < chess.length * chess.length ; cell++){
            // finding the row and col number for current cell in 2d matrix by below formula : 
            int row = cell / chess.length ;
            int col = cell % chess.length ;

            chess[row][col] = true ;
            queensCombinations(qpsf+1,tq,chess,cell) ;
            chess[row][col] = false ; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
    
}
