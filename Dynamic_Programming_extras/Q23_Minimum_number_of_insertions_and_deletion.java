package Dynamic_Programming_extras;

public class Q23_Minimum_number_of_insertions_and_deletion {

    // recursive solution.
    
    public int minOperations(String str1, String str2) 
	{ 
	    return helper(str1.length()-1,str2.length()-1, str1,str2) ;
	} 
	
	int helper(int i, int j, String s1, String s2){
	    
	    if(i == -1 && j >= 0) return j + 1 ; // j+1(making 1 based index) needs to be inserted
	    else if(j == -1 && i >= 0 ) return i+1 ; // needs to be deleted
	    else if(i == 0 && j == 0){ // if both at 0th index.
	        return s1.charAt(i) == s2.charAt(j) ? 0 : 2 ; // if they are same then return 0 else we need to delete 0th char and insert then  the matching char  
	    }
	    
	    char ch1 = s1.charAt(i) ;
	    char ch2 = s2.charAt(j) ;
	    
	    if(ch1 == ch2){ // if same then look for prev.
	        return helper(i-1,j-1,s1,s2) ;
	    }
	    
	    int deleted = 1 + helper(i-1,j,s1,s2) ; // else count if we delete the char
	    int inserted= 1 + helper(i,j-1,s1,s2) ; // count if we insert new char
	    
	    return Math.min(deleted,inserted) ; // return min
	}



    // memoization solution : 

    public int minOperations2(String str1, String str2) 
	{ 
	    Integer[][] dp = new Integer[str1.length()][str2.length()] ;
	    return helper(str1.length()-1,str2.length()-1, str1,str2,dp) ;
	} 
	
	int helper(int i, int j, String s1, String s2, Integer[][] dp){
	    
	    if(i == -1 && j >= 0) return j + 1 ; // needs to be inserted
	    else if(j == -1 && i >= 0 ) return i+1 ; // needs to be deleted
	    else if(i == 0 && j == 0){
	        return s1.charAt(i) == s2.charAt(j) ? 0 : 2 ;
	    }
	    
	    if(dp[i][j] != null) return dp[i][j] ;
	    
	    char ch1 = s1.charAt(i) ;
	    char ch2 = s2.charAt(j) ;
	   
	    if(ch1 == ch2){
	        return dp[i][j] = helper(i-1,j-1,s1,s2,dp) ;
	    }
	    
	    int deleted = 1 + helper(i-1,j,s1,s2,dp) ;
	    int inserted= 1 + helper(i,j-1,s1,s2,dp) ;
	    
	    return dp[i][j] = Math.min(deleted,inserted) ;
	}
	


    /// tabulations :

    public int minOperations3(String str1, String str2) 
	{ 
	    int[][] dp = new int[str1.length()+1][str2.length()+1] ;

        // as we were using -1 index in memo so we shifted 1 index here.
	    
        // this is the first base case of memo sol
	    for(int j = 0 ; j <= str2.length() ; j++ ){
	        dp[0][j] = j ;
	    }
	    
        // this is the second base case of memo sol
	    for(int i = 0 ; i <= str1.length() ; i++){
	        dp[i][0] = i ;
	    }
	    
	    for(int i = 1 ; i <= str1.length() ; i++){
	        for(int j = 1 ; j<= str2.length() ; j++){
	            
	            if(i == 1 && j == 1)  // this is the third base case
	            dp[i][j] = str1.charAt(i-1) == str2.charAt(j-1) ? 0 : 2 ;
	            
	            else{
	            char ch1 = str1.charAt(i-1) ;
	            char ch2 = str2.charAt(j-1) ;
	
	            if(ch1 == ch2){ // when not deleted
	              dp[i][j] = dp[i-1][j-1] ;
	              continue ;
	            }
	    
	            int deleted = 1 + dp[i-1][j] ;
	            int inserted= 1 + dp[i][j-1] ;
	    
	            dp[i][j] = Math.min(deleted,inserted) ;
	                
	            }
	        }
	    }
	    return dp[str1.length()][str2.length()];
	} 


    // space optimized solution : 

    public int minOperations4(String str1, String str2) 
	{ 
	    int[] prev = new int[str2.length()+1] ;
	    
	    for(int j = 0 ; j <= str2.length() ; j++ ){ /// this is the first base base case
	        prev[j] = j ;
	    }
	    
	   // for(int i = 0 ; i <= str1.length() ; i++){ // as this is running for all the i so we will handle it in the below main loop
	   //     dp[0] = i ;
	   // }
	    
	    for(int i = 1 ; i <= str1.length() ; i++){
	        int[] curr = new int[str2.length()+1] ;
	        for(int j = 0 ; j<= str2.length() ; j++){
	            
	            if(i == 1 && j == 1) // this is third base case
	            curr[j] = str1.charAt(i-1) == str2.charAt(j-1) ? 0 : 2 ;
	           
	            else if(j==0) curr[j] = i ; // handling the second base case
	           
	            else{            
	            char ch1 = str1.charAt(i-1) ;
	            char ch2 = str2.charAt(j-1) ;
	    
	            if(ch1 == ch2){
	              curr[j] = prev[j-1] ;
	              continue ;
	            }
	    
	            int deleted = 1 + prev[j] ;
	            int inserted= 1 + curr[j-1] ;
	    
	            curr[j] = Math.min(deleted,inserted) ;
	                
	            }
	        }
	         prev = curr ;
	    }
	    
	    
	    return prev[str2.length()];
	} 
	



    // we can also solve this using LCS approch
	
}
