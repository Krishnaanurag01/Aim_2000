package Recursion_and_backtracking_level_01;

import java.util.Scanner;

public class Q23_Print_Maze_Paths {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        int m = sc.nextInt() ;

        printMazePaths(1,1,n,m,"");

        sc.close();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if(sr == dr && sc == dc){
            System.out.println(psf);
        }

        if( sr > dr || sc > dc){
            return ;
        }

        printMazePaths(sr,sc+1,dr,dc,psf+"h");
        printMazePaths(sr+1,sc,dr,dc,psf+"v");

    }
    
}
