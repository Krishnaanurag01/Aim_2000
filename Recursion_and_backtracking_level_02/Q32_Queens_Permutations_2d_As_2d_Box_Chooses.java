package Recursion_and_backtracking_level_02;
import java.io.*;

public class Q32_Queens_Permutations_2d_As_2d_Box_Chooses {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(row == tq){
          if(qpsf == tq)
          {
            System.out.println(asf) ;
          System.out.println() ;

          }
          return ;
        }

        int ni , nj ;
        String sep  ; // seprator 

        if(col == tq-1){
          ni = row+1 ;
          nj = 0 ;
          sep ="\n" ;
        }
        else{
          ni = row ;
          nj = col+1 ;
          sep = "\t" ;

        }

        for(int i = 0 ; i < queens.length ; i++ ){
          if(queens[i] == false){
            queens[i] = true ;
            queensPermutations(qpsf+1,tq,ni,nj,asf+"q"+(i+1)+sep,queens) ;
            queens[i] = false ;
          }
        }

        queensPermutations(qpsf,tq,ni,nj,asf+"-"+sep,queens) ;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
    
}
