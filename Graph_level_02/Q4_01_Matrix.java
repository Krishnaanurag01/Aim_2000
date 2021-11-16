package Graph_level_02;

import java.util.LinkedList;

public class Q4_01_Matrix {

    static class Pair{
        int x ;
        int y ;

        Pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }

    static int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    
    public int[][] updateMatrix(int[][] mat) {
     
        LinkedList<Pair> queue = new LinkedList<>();

        for(int i = 0 ; i < mat.length ; i++){
            for (int j = 0; j < mat[0].length; j++) {
                
                if(mat[i][j] == 0){ // adding all the elements if they are 0
                    queue.add(new Pair(i, j));
                }
                else{ /// else if element is not 0 then making it -1 initially.
                    mat[i][j] = -1 ;
                }
            }
        }

        // now using bfs logic.

        while (queue.size() > 0 ) {
             // as all the 0s pair comes in front side od queue.
            Pair rp = queue.removeFirst() ; /// removing the first element of queue.

            for (int i = 0; i < directions.length ; i++) { // now going in all four directions.
                int rowDash = rp.x + directions[i][0] ; // new row
                int colDash = rp.y + directions[i][1] ; // new column

                // if the elememt is less than 0 and in range then store removed pair distance + 1 ( this is the distance of nearest 0th element) and also adding it to the queue so that it can help its adjecent numbers. 
                if(rowDash >= 0 && rowDash < mat.length && colDash >= 0 && colDash < mat[0].length && mat[rowDash][colDash] < 0 ){
                    mat[rowDash][colDash] = mat[rp.x][rp.y] + 1 ;
                    queue.add(new Pair(rowDash, colDash));
                }
            }

        }
        

        return mat;
    }
}
