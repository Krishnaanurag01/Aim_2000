package Problem_Of_The_day;
import java.util.*;

public class Q97_Number_of_Submatrices_That_Sumto_Target {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
     
        // making the prefix matrix.
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[0].length ; j++){
                matrix[i][j] += matrix[i][j-1] ;
            }
        }
        
        int count = 0 ;
        
        // now run loop with every possible continuos columns set. 
        for(int j = 0 ; j < matrix[0].length ; j++){
            for(int j2 = j ; j2 < matrix[0].length ; j2++){
                
                int sum = 0 ;
                HashMap<Integer,Integer> map = new HashMap<>() ;
                map.put(0,1);
                
                for(int i = 0 ; i < matrix.length ; i++){ // subtracting previous col valu by ith iteration
                    sum += matrix[i][j2] - (j > 0 ? matrix[i][j-1] : 0) ;
                    count += map.getOrDefault(sum - target,0) ;
                    map.put(sum, map.getOrDefault(sum,0)+1); 
                }
            }
        }
        
        return count ;
    }
    
}