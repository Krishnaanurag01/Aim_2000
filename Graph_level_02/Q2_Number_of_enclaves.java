package Graph_level_02;

public class Q2_Number_of_enclaves {

    public int numEnclaves(int[][] grid) {
        
        for( int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){ // if we are at any of the four border then call dfs function.
                    dfs(grid,i,j);
                }
            }
        }
        
        int count = 0 ;
        // now counting all the 1's
        
        for( int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                if(grid[i][j] == 1){
                    count++ ;
                }
            }
        }
        
        return count ;  

    }
    

    // this function helps by making all the " 1's " to " 0 " who are connected with any border " 1 ".
    public void dfs(int[][] arr , int i , int j){
        
        if( i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0){
            return ;
        }
        
        arr[i][j] = 0 ; // making 1 to 0.
        

        // running for all four directions.
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        
    }
    
}
