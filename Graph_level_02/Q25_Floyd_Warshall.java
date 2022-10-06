package Graph_level_02;

public class Q25_Floyd_Warshall {
 
    
    public void shortest_distance(int[][] matrix)
    {
       // finding the number of vertices.
       int v = matrix.length ;
       
       for(int k = 0 ; k < v ; k++){ // running k times.
           for(int i = 0 ; i < v ; i++){
               for(int j = 0 ; j < v ; j++){
                   
                // if i to k is -1 ( infinity ) or k to i is -1( infinity ) then continue ;

                   if(matrix[i][k] == -1 || matrix[k][j] == -1 ) continue ; // means there is no edge between i and k or k and j.
                   
                   else if(matrix[i][j] == -1 ){ // else check if previously we had -1 then store directly i to k + k to i.
                       matrix[i][j] = matrix[i][k] + matrix[k][j] ;
                   }
                   else{
                       matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]) ; // else store min.
                   }
               }
           }
       }
       
       
       
    }

}
