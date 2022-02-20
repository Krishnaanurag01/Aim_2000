package Problem_Of_The_day;
import java.util.*;

public class Q49_Find_rectangle_with_corners_as_1 {
    

    // time comp : O(n*m*m)
    static boolean ValidCorner(int matrix[][]) 
    { 
        int n = matrix.length; // row size
        int m = matrix[0].length; // col size
       
       HashMap<Integer, HashSet<Integer>> map = new HashMap<>() ; // this will store each column with pairs
       
       for(int i = 0 ; i < n ; i++){
           for(int j = 0 ; j < m ; j++){
               if(matrix[i][j] == 1){ // when current cell is 1
                   
                   for(int k = j+1 ; k < m ; k++ ){ // check in the same row with differentt col
                       
                       if(matrix[i][k] == 1 ){
                        
                        if(map.containsKey(j) && map.get(j).contains(k)){ // if the new col with same row has value 1 and map already have this column saved as pair then it means it is forming a rectangle
                            return true ;
                        }
                        else if(map.containsKey(j)) { // else if we have key initialized then store current col in map
                            
                            map.get(j).add(k) ;
                            
                        }
                        else{ // else first initialize j column and then store differen 1's of same row  
                            
                            HashSet<Integer> set = new HashSet<>() ;
                            set.add(k) ;
                            map.put(j,set) ;
                            
                        }
                           
                           
                       }
                   }
                   
               }
           }
       }
       
       
       return false;
}


}
