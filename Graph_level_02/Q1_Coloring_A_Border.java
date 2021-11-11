package Graph_level_02;

public class Q1_Coloring_A_Border {

    public static void main(String[] args) {
        
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        

        dfs(grid,row,col,grid[row][col]); // helper function.

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] < 0 ){ // if the value is negative then paint it with the given colour.
                    grid[i][j] = color ;
                 }
            }
        }


        return grid ; // returning the grid.
    }

    static int[][] colour_arr = { {0,1} ,{1,0},{0,-1},{-1,0} } ;  // all four directions, horizontal and vertical.

    private void dfs(int[][] grid, int row, int col, int clr) {

        grid[row][col] = -clr ; // making negative ( given constraint that every element is positive ) so making negative will work as visited array.

        int count = 0 ; // hold the count of all directions with same colour ( connected component).

        for (int i = 0; i < 4 ; i++) { // now going in all four directions.

            int rowDash = row + colour_arr[i][0]; // new row 
            int colDash = col + colour_arr[i][1]; // new column

            // if out of bound or if the element colour is different then skip.
            if(rowDash < 0 || colDash < 0 || rowDash >= grid.length || colDash >= grid[0].length || Math.abs( grid[rowDash][colDash] ) != clr){
                continue ;
            }

            count++ ; // if we come here then it means we come to one direction so count it.

            if(grid[rowDash][colDash] == clr){ // this denotes that element is not visited as it is not negative so call dfs for that component.
                dfs(grid, rowDash, colDash, clr);
            }
       
        }

        
        if(count == 4){ // if all four direction have same colour ( means connected component ) then this element can't be coloured as it does not come in any border.
            grid[row][col] = clr ; // so change the colour to the original || means we are making the visited ( negated clr ) colour back to unvisited.
        }

    }
    
}
