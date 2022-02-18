package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q17_Get_Maze_Paths {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;

        System.out.println(getMazePaths(1,1,n,m)) ;
        sc.close();

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sr == dr && sc == dc){
            ArrayList<String> ans = new ArrayList<>() ;

            ans.add("") ;

            return ans ;
        }

        if(sc > dr || sr > dr){
            return new ArrayList<String>() ;
        }
        
        ArrayList<String> hori = getMazePaths(sr,sc+1,dr,dc) ;
        ArrayList<String> verti = getMazePaths(sr+1,sc,dr,dc) ;

        ArrayList<String> ans = new ArrayList<>() ;
        
        for(String s : hori){
            ans.add( "h"+ s) ;
        }
        
        
        for(String s : verti){
            ans.add( "v"+ s) ;
        }
        

        return ans;
    }
    
}
