package Stack_and_Queue_level01;

import java.util.PriorityQueue;

public class Q30_Trapping_Rain_Water_II {

    static class Pair implements Comparable<Pair>{
        int row ; 
        int col ;
        int height ;

        Pair(int row , int col , int h){
            this.row = row ;
            this.col = col ;
            this.height = h ;
        }

        public int compareTo(Pair obj){ // sort on basis of height. 
            return this.height - obj.height ;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length ; // row
        int n = heightMap[0].length ; // col 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;

        boolean[][] visited = new boolean[m][n] ; // making a visited array.

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                
                if(i == 0 || j == 0 || i == m-1 || j == n-1){ // making border visited 
                    visited[i][j] = true ;
                    pq.add( new Pair(i, j, heightMap[i][j])) ; // and adding by making pair in pq.
                }
            }
        }

        int ans = 0 ;

        int[][] dirc = {{0,1},{0,-1},{1,0},{-1,0}} ; // all adjecent directions.

        while (pq.size() > 0 ) {

            Pair popped = pq.remove() ; // removing pair.

            for (int i = 0; i < dirc.length; i++) {
                int rowDash = popped.row + dirc[i][0] ; // adjecent row
                int colDash = popped.col + dirc[i][1] ; // adjecent col

                // going to adjecent neigbour.

                if(rowDash >= 0 && rowDash < m && colDash >= 0 && colDash < n && visited[rowDash][colDash] == false ){

                    ans += Math.max(0, popped.height - heightMap[rowDash][colDash]) ; // getting answer.

                    if( heightMap[rowDash][colDash] >= popped.height ){  // if height of current element is larger then make pair with current height.

                    pq.add( new Pair(rowDash, colDash, heightMap[rowDash][colDash])) ;
                    }
                    else{ // else make pair with popped element height.
                        pq.add( new Pair(rowDash, colDash, popped.height )) ;
                    }

                    // make it visited.
                    visited[rowDash][colDash] = true ;
                }
            }
        }

        // adding to ans.
        return  ans ;
    }
}
