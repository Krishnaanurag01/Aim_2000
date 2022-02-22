package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q28_Flood_Fill {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s[] = scn.nextLine().split(" ") ;
        int n = Integer.parseInt( s[0] );
        int m = Integer.parseInt( s[1] );
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m] ;
        floodfill(arr, 0, 0, "" , visited);
        scn.close();
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {

        // error conditions:
        if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc] == true){
            return ;
        }

        // when reached the bottom-right most cell then print the path
        if(sr == maze.length-1 && sc == maze[0].length - 1){
            System.out.println(asf) ;
            return ;
        }

        // making it visited so that we won't get suck in loop
        visited[sr][sc] = true ;

        floodfill(maze,sr-1,sc,asf+"t",visited) ;
        floodfill(maze,sr,sc-1,asf+"l",visited) ;
        floodfill(maze,sr,sc+1,asf+"r",visited) ;
        floodfill(maze,sr+1,sc,asf+"d",visited) ;

        // making unvisited so that we can find out other path as well
        visited[sr][sc] = false ;
    }

}
