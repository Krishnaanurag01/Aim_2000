package Graph_level_02;
import java.util.*;

// Application of floyd warshall:
public class Q52_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        // making adjency matrix.
        int[][] matrix = new int[n][n] ;
        
        for(int[] m : matrix){
            Arrays.fill(m,(int)1e9) ;
        }
        
        for(int[] e : edges){
            matrix[e[0]][e[1]] = e[2] ;
            matrix[e[1]][e[0]] = e[2] ;
        }
         
        
        for(int k = 0 ; k < n ;k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(matrix[i][k] == (int)1e9 || matrix[k][j] == (int)1e9) continue ;
                    
                    matrix[i][j] = Math.min( matrix[i][j], matrix[i][k] + matrix[k][j] ) ;
                
                }
            }
        }


        // matrix created.
        
        int ans = 0 ;
        int count = (int)1e9 ;

        // now checking distance of every ith vertices with other j vertices.
        for(int i = 0 ; i < n ; i++){
            int temp = 0 ;
            for(int j = 0 ; j < n ; j++){
                if( i != j && matrix[i][j] <= distanceThreshold) temp++ ; // i and j vertice should not be same.
            }

            if(count > temp){  // if count for ith  city is less then update it.
                count = temp ;
                ans = i ;
            }
            else if(count == temp){ // else if count is same choose the city with greater number.
                ans = Math.max(ans,i) ;
            }
        }
        
        return ans ;
    }
}
