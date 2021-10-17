package Dynamic_Programming_level_02;

public class Q51_Knights_Probability_in_Chessboard {

    public static void main(String[] args) {
        
    }

    public static boolean isValid(int n , int ni , int nj) { // this will check wheather the given new row(ni) and new col (nj) is within the range or not.
        
        if(ni >= 0 && ni < n && nj >=0  && nj < n){
            return true ;
        }

        return false ;
    }

    public static double get_probabilty(int n , int r , int c , int steps) {

        double[][] current_dp = new double[n][n] ;
        double[][] next_dp = new double[n][n] ;

        current_dp[r][c] = 1 ; // probability of current place 

        for (int moves = 0 ; moves < steps ; moves++) { // playing steps times.
            for (int i = 0; i < n ; i++) { // row
                for (int j = 0; j < n ; j++) { // co;
                    
                    if(current_dp[i][j] != 0){ // if our current value is not 0 the perform this.
                        int ni = 0 ;
                        int nj = 0 ;

                        // draw 8 directions of knight then you'll get this direction of new row and new col.
                        ni = i-2 ;
                        nj = j+1 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ; // is valid then storing current value / 8 (as knight can go upto 8 moves.)
                        }

                        // doing this for rest of the directions as well.
                        ni = i-1 ;
                        nj = j + 2 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                        ni = i+1;
                        nj = j+2 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                        ni = i+2 ;
                        nj = j +1 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }


                        ni = i+2 ;
                        nj = j-1 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                        ni = i+1;
                        nj = j-2 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                        ni = i-1 ;
                        nj = j-2 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                        ni = i-2 ;
                        nj = j-1 ;
                        if(isValid(n, ni, nj)){
                            next_dp[ni][nj] += current_dp[i][j] / 8.0 ;
                        }

                    }
                }
            }

            // now our next move dp becomes current dp and make next move empty and repeat this process steps times.
            current_dp = next_dp ;
            next_dp = new double[n][n] ;
        }
     
        double sum = 0 ;

        // now caculating the sum.
        for (int k = 0; k < n ; k++) {
            for (int p = 0; p < n ; p++) {
                if(current_dp[k][p]!= 0){
                    sum += current_dp[k][p] ;
                }
            }
        }

        return sum ;
    }
    
}
