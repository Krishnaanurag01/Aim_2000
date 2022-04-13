package Dynamic_Programming_extras;
import java.util.*;

public class Q55_Number_of_Paths_with_Max_Score {

    static int mod = (int)1e9 + 7 ;
    static Integer[][][] dp  ;  // making 3d array becuase we storing int[] of size 2 in dimention idx and j.
    public int[] pathsWithMaxScore(List<String> board) {
        
        dp = new Integer[board.size()][board.get(0).length()+1][2] ; // initialization of dp.
        String ls = board.get(board.size()-1) ;
        if(board.get(0).charAt(0) != 'E' || ls.charAt(ls.length()-1) != 'S' ) return new int[]{0,0} ;  // if S or E not present then simply return 0.
        
        return helper(board.size()-1,board.get(0).length()-1, board) ;
    }
    
    static int[] helper(int idx, int j, List<String> board){
        
        if(idx == 0 && j == 0) return new int[]{0,1} ; // when reached the top left corner then return new int with 1 at first index denotes we found one path.
        
        if(dp[idx][j][0] != null) {  // returning if already solved.
            return new int[]{dp[idx][j][0],dp[idx][j][1]} ;
        }

        char ch = board.get(idx).charAt(j) ;
        int[] ans = new int[2] ;
        
        if(ch == 'X' ) { // if found obstacle return with sum -1
            dp[idx][j][0] = -1 ;         
            dp[idx][j][1] = 0 ;
            return new int[]{-1,0} ;
        }
        
        int[] left = new int[2] ; // answer when go left
        int[] up = new int[2] ; // when go up
        int[] ld = new int[2] ; // when go left diagonal

        // getting answers.
        if(j > 0){
           left = helper(idx,j-1,board) ;
        }
        
        if(idx > 0){
           up = helper(idx-1,j,board) ;
        }
        
        if(idx > 0 && j > 0){
           ld = helper(idx-1,j-1,board) ;
        }
        

        // finding the max sum when we answer also have a path to reach top left.
        int maxSum = 0 ;
        
        if(left[1] != 0){ // not equals to zero denotes that we have a path
            maxSum = Math.max(maxSum,left[0]) ;
        }
        
        if(up[1] != 0){
            maxSum = Math.max(maxSum,up[0]) ;
        }
        
        if(ld[1] != 0){
            maxSum = Math.max(maxSum,ld[0]) ;
        }
        
        ans[0] = maxSum ;
        

        // counting total ways of max sum path
        if(left[0] == maxSum ) ans[1] = ( ans[1] + left[1] ) % mod   ;
        if(up[0] == maxSum ) ans[1] = ( ans[1] + up[1]  ) % mod  ;
        if(ld[0] == maxSum ) ans[1] = ( ans[1] + ld[1]  ) % mod  ;

        
        if(Character.isDigit(ch)){ // adding current char if it's digit.
            ans[0] += (ch-'0');
        }
        
        dp[idx][j][0] = ans[0] ;        
        dp[idx][j][1] = ans[1] ;
        
        return ans ;
    }
}
