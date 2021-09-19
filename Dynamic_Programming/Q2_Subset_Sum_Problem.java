package Dynamic_Programming;

public class Q2_Subset_Sum_Problem {

    public static void main(String[] args) {
        
    }


    public static boolean contains_subset_sum(int[] arr , int sum ) {
        
        boolean[][] dp = new boolean[arr.length + 1][sum + 1] ;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if(i == 0 && j==0){ // 0th row 0th col is true. because at the 0th row arr has no element but empty set and empty set sum is 0 so true.
                    dp[i][j] = true ;
                }
                else if(i == 0){  // otherwise when no element in array then whole row becomes false.
                    dp[i][j] = false ; 
                }
                else if( j == 0){ // and every arr has an empty set so true when col is 0.
                    dp[i][j] = true ;
                }
                else{
                  // checking if previous row having current sum,
                  if( dp[i-1][j] == true ){

                    // we can directly assgin true if our previous sum is already true.
                    dp[i][j] = true ;
                  }
                  else{
                      int val = arr[i-1] ; // when we want to search 3rd element in an array then we write as 3-1 index has 3rd element.
                      if(val <= j){ // j is current sum, when j is greater than i then we can use i in calculating sum
                          dp[i][j] = dp[i-1][ j - val ] ; // so we'll check when ( eg : required sum is 10 : and i is 8 then we look if previous row 11-8 = 3 rd column is true.) if it true then store true o\w false.
                      }
                  }


                }                
            }
        }
        return dp[dp.length-1][dp[0].length-1] ; // last row last col will return wheather we can form sum with array.
    }
    
}
