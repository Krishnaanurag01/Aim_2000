package Problem_Of_The_day;
import java.util.*;

public class Q201_Path_Crossing {

    public boolean isPathCrossing(String path) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>() ;// we will store x as key and y as value.
        int x = 0 ;
        int y = 0 ;
        HashSet<Integer> s = new HashSet<>() ;
        s.add(0) ; // adding y.
        map.put(x,s) ; /// adding y's corresponding to x
        
        for(char ch : path.toCharArray()){
            if(ch == 'N'){ // going right
                y++;
            }
            else if(ch == 'S'){// going left
                y-- ;
            }
            else if(ch == 'E'){ // going up
                x++;
            }
            else{// going down
                x-- ;
            }
            
            if(map.containsKey(x) && (map.get(x).contains(y))) return true ; // when same key value present then true. 
            HashSet<Integer> ys= map.getOrDefault(x,new HashSet<>()) ; // getting the y's corrs. to x direc
            ys.add(y) ;// adding new y 
            map.put(x,ys) ;
        }
        
        return false;
    }
}
