package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q24_Print_Maze_Paths_With_Jumps {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;

        printMazePaths(1,1,n,m,"") ;

        sc.close(); 
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        if(sr == dr && sc == dc){ // when reach the last row and last col then print the path
            System.out.println(psf) ;
            return ;
        }

        if(sr > dr || sc > dc) // when out of bound the return
        return ;

        for(int i = 1  ; i <= dc - sc ; i++){ // checking for horizontal
            int nc = sc+i ; // new column
            printMazePaths(sr,nc,dr,dc,psf+"h"+i) ;
        }
        for(int i = 1  ; i <= dr - sr ; i++){ // checking for vertical
            int nr = sr+i ; //new row
            printMazePaths(nr,sc,dr,dc,psf+"v"+i) ;
        }

        // for diagonal
        for(int i = 1  ; i <= dr - sr && i <= dc-sc; i++){
            int nr = sr+i ; // new row
            int nc = sc+i ; // new col
            printMazePaths(nr,nc,dr,dc,psf+"d"+i) ;
        }

    
    }

}
