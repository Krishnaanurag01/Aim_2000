package Recursion_and_backtracking_level_02;

import java.util.Scanner;

public class Q6_Gold_Mine_2_ {
    
    static int max = 0;
	public static void getMaxGold(int[][] grid){
		//write your code here
		  
        
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] != 0 && grid[i][j] > 0 ){
                    
                    int ans = helper(grid,i,j) ;
                    max = Math.max(ans,max) ;
                }
            }
        }
    
		
	}

	 public static int helper(int[][] grid, int i , int j){
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] < 0 ){
            return 0 ;
        }
        
        int val = grid[i][j] ;
        grid[i][j] = - val ; // making visited so that we won't come to this cell again
        
        int t = helper(grid,i-1,j) ;      // going up
        int d = helper(grid,i+1,j) ;      // going down
        int l = helper(grid,i,j-1) ;      // going left
        int r = helper(grid,i,j+1) ;      // going right

        return ( val + t+d+l+r) ; // returning total
        
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
        scn.close();
	}
		

}
