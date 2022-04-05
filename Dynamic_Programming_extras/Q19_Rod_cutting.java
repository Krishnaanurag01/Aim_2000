package Dynamic_Programming_extras ;

public class Q19_Rod_cutting {

    public static int cutRod(int price[], int n) {
        
        Integer[][] dp = new Integer[n+1][n+1] ;
        return helper(n-1,n,price,dp) ;
	}
    
    static int helper(int idx,int length, int[] price, Integer[][] dp){
        if(idx < 0) return 0 ;
        if(idx == 0){
//             if( idx+1 <= length ) return (length/(idx+1))*price[idx] ;
            return length*price[0] ; // if rod is remaining in 1 length then we are dividing in 1 length
        }
       
        if(dp[idx][length] != null) return dp[idx][length] ;
        
        int notCutting = 0 + helper(idx-1,length,price,dp) ; // not taken
        int cutting = (int)-1e8 ;
        int rodLen = idx+1 ; // rod length in current index.
        if(rodLen <= length){ 
            cutting = price[idx] + helper(idx,length-rodLen,price,dp) ; // calling for same index.
        }
        return dp[idx][length] = Math.max(notCutting,cutting) ;
    }

    // tabulations : 

    public static int cutRod2(int price[], int n) {
        
        int[][] dp = new int[n+1][n+1] ;
        
        for(int j = 0 ; j <= n ; j++){
            dp[0][j] = j*price[0] ; /// storing price for every length of rod at first index row
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= n ; j++){
                
              int notCutting = dp[i-1][j]; //not cutting so loook above
              int cutting = (int)-1e8 ;
              int rodLen = i+1 ;
              if(rodLen <= j){ // if rod length is smaller or eqal then take value + remaining length value
                cutting = price[i] + dp[i][j-rodLen];
               }
              dp[i][j] = Math.max(notCutting,cutting) ;
            }
        }
        
        return dp[n-1][n] ;
	}


    // space optimized taking only 1 1d array

    public static int cutRod3(int price[], int n) {
        
        int[] prev = new int[n+1] ; // this is holding prev row data
        int[] curr = new int[n+1] ; // current row data is storing here
        
        for(int j = 0 ; j <= n ; j++){  // first row data 
            prev[j] = j*price[0] ;
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= n ; j++){
                
              int notCutting = prev[j]; // previoous data
              int cutting = (int)-1e8 ;
              int rodLen = i+1 ;
              if(rodLen <= j){
                cutting = price[i] + curr[j-rodLen]; // remainning data in same curr row
               }
              curr[j] = Math.max(notCutting,cutting) ;
            }
            prev = curr ;
        }
        
        return prev[n] ;
	}

    //super space optimized. taking only one 1d array.

    public static int cutRod5(int price[], int n) {
        
        //         int[] prev = new int[n+1] ;
                    int[] curr = new int[n+1] ;
                
                for(int j = 0 ; j <= n ; j++){
                    curr[j] = j*price[0] ;
                }
                
                for(int i = 1 ; i < n ; i++){
        //             int[] curr = new int[n+1] ;
                    for(int j = 0 ; j <= n ; j++){
                        
                      int notCutting = curr[j];
                      int cutting = (int)-1e8 ;
                      int rodLen = i+1 ;
                      if(rodLen <= j){
                        cutting = price[i] + curr[j-rodLen]; // as it's needed only current remain data so we ran jth loop fro 0 to n.
                       }
                      curr[j] = Math.max(notCutting,cutting) ;
                    }
        //             prev = curr ;
                }
                
                return curr[n] ;
            }
   
}