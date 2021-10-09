package Dynamic_Programming_level_02;

public class Q53_Mobile_numeric_keypad {


    public static void main(String[] args) {
        
    }
    
    public static int get_total_possible_numbers(int n) {
        
        int[][] data = { // this stores the all valid direction(up,down,left,right) for each number
            {0,8}, // for 0
            {1,2,4}, // for 1
            {1,2,3,5},//for 2
            {2,3,6},//for 3
            {1,4,5,7},//for 4
            {2,5,4,6,8},//for 5
            {3,6,5,9},// for 6
            {4,8,7},//for 7
            {7,8,5,9,0},//for 8
            {9,8,6}// for 9
        };



        int[][] dp = new int[n+1][10] ; // n is length in row side and and dialer is on column side.

        for (int i = 1 ; i < dp.length; i++) { // for i = 0 means size is 0 so skipped that and starting  from 1
            for (int j = 0; j < dp[0].length; j++) { 
                if(i==1){ // when size is one then we can press only once each number
                    dp[i][j] = 1 ;
                }
                else{

                    // else look the valid direction in data[][] and add their dp value in current dp.
                    for (int k : data[j]) {
                        dp[i][j] += dp[i-1][k] ;
                    }
                }
                
            }
        }

        int sum = 0 ; /// now add all combinations of n length.
        for (int i = 0; i < dp[0].length; i++) {
            sum += dp[n][i] ;
        }

        return sum ;
    }
}
