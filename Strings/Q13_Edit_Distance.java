package Strings;

public class Q13_Edit_Distance {
    public static void main(String[] args) {
        System.out.println(minDistance("geek", "gesek"));
    }

    // /Time Complexity: O(m x n) 
    // Auxiliary Space: O(m x n)
    public static int minDistance(String s, String t) {

        // initializing matrix. 
        int[][] dp = new int[s.length()+1][t.length()+1];
     
     for(int i = 0 ; i < dp.length ; i++){
         for(int j = 0 ; j < dp[0].length ; j++){
             

            // when row is first then the value stored there is column value. and vice versa.
             if(i==0){
                 dp[i][j]=j;
             }
             else if(j==0){
                 dp[i][j]=i;
             }
             else{
                 // checking the last element.
                 if(s.charAt(i-1) == t.charAt(j-1)){
                     // when last element is same then storing data of last  value.
                     dp[i][j] = dp[i-1][j-1];
                 }
                 else{ // its logic in the dsa copy 3rd last page.
                     int f1 = 1 + dp[i-1][j-1] ; //replace
                     int f2 = 1 + dp[i-1][j]; // for delete
                     int f3 = 1 + dp[i][j-1]; // when inserting
                     dp[i][j] = Math.min(f1 , Math.min(f2,f3));
                 }
             }
         }
     }

     // return the bottom last value.
     
     return dp[dp.length-1][dp[0].length-1];
   }
}

