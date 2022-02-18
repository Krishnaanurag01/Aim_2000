package Recursion_and_backtracking_level_01;
import java.util.*;

public class Q16_Get_Stair_Paths {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;

        System.out.println(getStairPaths(n)) ;

        sc.close();

    }

    public static ArrayList<String> getStairPaths(int n) {

        if(n == 0){ // when reach the ground then return list with empty string ("") that denotes a path can lead us a way to 0
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("") ;
            return ans ;
        }

        if( n < 0 ){ // else return empty list
            return new ArrayList<String>() ;
        }

        ArrayList<String> ans1 = getStairPaths(n-1) ; // jumping 1 stair
        ArrayList<String> ans2 = getStairPaths(n-2) ; // jumping 2 stairs
        ArrayList<String> ans3 = getStairPaths(n-3) ; // jumping 3 stairs

        ArrayList<String> paths = new ArrayList<>() ; // ans list
       
       for(String path : ans1){ // adding 1 to our path
           paths.add(1+path) ;
       }

       for(String path : ans2){ // same for 2
           paths.add(2+path) ;
       }

       for(String path : ans3){ // same for 3
           paths.add(3+path) ;
       }


        return paths;
    }
    
}
