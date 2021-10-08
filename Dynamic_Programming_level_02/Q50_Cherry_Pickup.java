package Dynamic_Programming_level_02;

public class Q50_Cherry_Pickup {
    

    public static void main(String[] args) {
        
    }

    static int maxcheeries = 0 ;
    public static void top_down(int row , int col , int[][] arr , int ccsf) {
        
        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1 ){
            return ;
        }

        if(row == arr.length-1 && col == arr[0].length-1){
             bottom_up(row,col,arr,ccsf );
        }

        int cherries = arr[row][col];
        arr[row][col] = 0 ;

        top_down(row+1, col, arr, ccsf + cherries);
        top_down(row, col+1, arr, ccsf + cherries);

        arr[row][col] = cherries ;

    }

    private static void bottom_up(int row, int col, int[][] arr, int ccsf) {

        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1 ){
            return ;
        }

        if(row == 0 && col == 0){
            maxcheeries = Math.max(maxcheeries, ccsf) ;
            return;
        }

        int cherries = arr[row][col];
        arr[row][col] = 0 ;

        top_down(row-1, col, arr, ccsf + cherries);
        top_down(row, col-1, arr, ccsf + cherries);

        arr[row][col] = cherries ;
    }


    // using memoization : 

    public static int get_max_cherry(int r1 , int c1 , int r2 , int c2 , int[][] arr , int[][][][] dp) {
        
        if(r1 >= arr.length || r2 >= arr.length || c1 >= arr[0].length || c2 >= arr[0].length || arr[r1][c1] == -1 || arr[r2][c2] == -1){
            return Integer.MIN_VALUE ;
        }


        if(r1 == arr.length -1 && c1 == arr[0].length - 1){
            return arr[r1][c1] ;
        }

        if(dp[r1][c1][r2][c2] != 0){
            return dp[r1][c2][r2][c2] ;
        }


        int cherrish = 0 ;
        if(r1 == r2 && c1 == c2){
            cherrish += arr[r1][c2] ;
        }
        else{
            cherrish += arr[r1][c2] + arr[r2][c2] ;
        }

        int f1 = get_max_cherry(r1+1, c1, r2+1, c2, arr, dp); // v,v
        int f2 = get_max_cherry(r1, c1+1, r2, c2+1, arr, dp); // h,h
        int f3 = get_max_cherry(r1+1, c1, r2, c2+1, arr, dp); // v,h
        int f4 = get_max_cherry(r1, c1+1, r2+1, c2, arr, dp); // h,v

        cherrish += Math.max(Math.max(f1, f2),Math.max(f3,f4)) ;

        dp[r1][c1][r2][c2] = cherrish ;
        return cherrish ;
    }
}
