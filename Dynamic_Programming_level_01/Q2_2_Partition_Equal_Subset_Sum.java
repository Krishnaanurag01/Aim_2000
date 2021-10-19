package Dynamic_Programming_level_01;

public class Q2_2_Partition_Equal_Subset_Sum {

    // it uses sub set problem .

    static int equalPartition(int N, int arr[])
    {
        
        int sum = 0 ; // first find the sum .
        
        for( int i = 0 ; i <  arr.length ; i++){
            sum += arr[i] ;
        }
        
        /// if sum is odd then there's no way that we can partition it into two equal parts so simply return false.
        if(sum % 2 != 0 ) return 0 ;
       
        // now using the subset problem as base to find the half of sum (even sum half). if it gives true then it means we have one partition of sum/2 and rest of the elements indirectly makes sum.
       return subSetSum(arr,sum/2) == true ? 1 : 0 ;
    }
    
    // using subset sum as base. check Q2 for explanation.
    public static boolean subSetSum(int[] arr , int sum){
        
        boolean[][] dp = new boolean[arr.length  + 1][sum + 1] ;
        
        for( int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                
                
                if(i == 0 && j == 0){
                    dp[i][j] = true ;
                }
                else if(i == 0){
                    dp[i][j] = false ;
                }
                else if(j==0){
                    dp[i][j] = true ;
                }
                else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true ;
                    }else{
                        int val = arr[i-1] ;
                        if(j >= val ){
                            boolean remaining = dp[i-1][j -val ]  ;
                            dp[i][j] = remaining ;
                        }
                        
                    }
                }
                
                
            }
        }
        
        return dp[dp.length - 1][dp[0].length-1] ;
    }
    
}
