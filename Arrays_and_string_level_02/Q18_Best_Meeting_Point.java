package Arrays_and_string_level_02;
import java.util.*;

public class Q18_Best_Meeting_Point {
    
    public static int minTotalDistance(int[][] grid) {
       
        ArrayList<Integer> xcod = new ArrayList<>() ; // it will contain all the x cordinates
        
        ArrayList<Integer> ycod = new ArrayList<>() ; // it will contain all the y cordinates
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[i][c] == 1){ // finding x cordinates
                    xcod.add(i) ; // adding row value(x cord) .
                }
            }
        }
        
        for(int c = 0 ; c < grid[0].length ; c++){
            for(int i = 0 ; i < grid.length ; i++){
                if(grid[i][c] == 1){ // finding the y cordinates
                    ycod.add(c) ; // adding col value(y cord)
                }
            }
        }
        
        int x = xcod.get(xcod.size() / 2 ) ; // this is meadian of x cordinates
        int y = ycod.get(ycod.size() / 2 ) ; // meadian of y cordinates
        
        int distance  = 0 ; // now calulating the distance by subtracting each x and y cordinates from their median.
        
        for(int i : xcod){ 
            distance += Math.abs(x - i);
        }
        
        
        for(int i : ycod){
            distance += Math.abs(y - i);
        }
        
        
        return distance ;
        
     }

}
