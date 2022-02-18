package Recursion_and_backtracking_level_01;

import java.util.*;

public class Q18_Get_maze_path_with_jumps {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in) ;
        int n  = sc.nextInt() ;
        int m = sc.nextInt() ;

        System.out.println(getMazePaths(1, 1, n, m));

        sc.close();
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc ==  dc){
            ArrayList<String> temp = new ArrayList<>() ;
            temp.add("") ;
            return temp ;
        }

        if(sr > dr || sc > dc){
            return new ArrayList<String>() ;
        }

        ArrayList<String> ans = new ArrayList<>() ;

        for (int mv = 1 ; mv <= dc-sc ; mv++) {
            ArrayList<String> hori = getMazePaths(sr, sc + mv , dr, dc) ;

            for (String s : hori) {
                String c = "h"+mv ;
                ans.add(c + s) ;
            }
        }

        
        for (int mv = 1 ; mv <= dr - sr ; mv++) {
            ArrayList<String> verti = getMazePaths( sr + mv , sc , dr, dc) ;

            for (String s : verti) {
                String v = "v"+mv ;
                ans.add(v + s) ;
            }
        }

        for (int mv = 1 ; mv <= dr - sr && mv <= dc - sc ; mv++) {
            ArrayList<String> diag = getMazePaths( sr + mv , sc + mv , dr, dc) ;

            for (String s : diag) {
                String v = "d"+mv ;
                ans.add(v + s) ;
            }
        }

        return ans;
    }

}
