package Dynamic_Programming_extras;

public class Q40_Boolean_Parenthesization {


    // tabulations:

    public static int count_ways(String s) {

        String str1= "", str2="" ;  //  storing both bool and operation seperately.

        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == 'T' || s.charAt(i) == 'F'){
                str1 += s.charAt(i);
            }
            else{
                str2 += s.charAt(i);
            }
        }


        // System.out.println(str1 +" -> "+str1.length());
        // System.out.println(str2 +" -> "+ str2.length());

    
        int n =  str1.length() ;
        int[][] dpt = new int[n][n] ; // dp true that store the total numbers of way an expression gives true.
        int[][] dpf = new int[n][n] ; // dp false that store the total numbers of way an expression gives false.

        for (int g = 0; g < n ; g++) {
            for (int i = 0 , j = g ; j < n; i++,j++) {

                if( g==0 ){  // using gap technique. when gap is 0 then check is char is true then store 1 in dpt and 0 on dpf
                    dpt[i][j] = str1.charAt(i) == 'T' ? 1 : 0 ;
                    dpf[i][j] = str1.charAt(i) == 'T' ? 0 : 1 ;
                }
                else{
                    for (int k = i ; k < j ; k++) {  // now running loop from i to j-1.
                        char optr = str2.charAt(k); // finding the operator.

                        int ltc = dpt[i][k] ; // this is left true count
                        int rtc = dpt[k+1][j] ; // right true count
                        int lfc = dpf[i][k];  // left false count
                        int rfc = dpf[k+1][j] ; // right false count

                        
                        if(optr == '&'){ // this performs AND
                            dpt[i][j] += ltc*rtc ; // when both side is true then only store true.
                            dpf[i][j] += ltc*rfc + lfc*rtc + lfc*rfc ; // this store false : when left is true and right is false + left false * right true + left false * right false
                        }
                        else if(optr == '|'){ // this performs for OR 
                            dpt[i][j] += ltc*rfc + ltc*rtc + lfc*rtc ; // store true when left true and right false , when left true and right true , left false and right true.
                            dpf[i][j] += lfc*rfc ; // this is for false dp : when both side is false only then count 
                        }
                        else{ // else for XOR 

                            /* for XOR : TRUE , FALSE = TRUE 
                                         FALSE , TRUE = TRUE 
                                         FALSE , FALSE = FALSE
                                         TRUE , TRUE = FALSE */
                                         
                            dpt[i][j] += ltc*rfc + lfc*rtc ;
                            dpf[i][j] += ltc*rtc + lfc*rfc ; 

                        }
                        
                    }

                }
                
            }
        }

        return dpt[0][str1.length()-1] ;
    }




    
    // recursive code.

    static int countWays(int N, String S){
        // code here
        
        StringBuilder sb1 = new StringBuilder() ;
        String bool = "" ;
        StringBuilder sb2 = new StringBuilder() ;
        String oprns = "" ;
        
        for(char ch : S.toCharArray()){  
            if( ch == 'T' || ch == 'F' ){ sb1.append(ch) ; }
            else{ sb2.append(ch) ; }
        }
        
        bool = sb1.toString() ;
        oprns = sb2.toString() ;
        
        
        return helper(0,bool.length() - 1,bool,oprns)[0] ;
    } 
    
    static int[] helper(int si, int ei, String bool, String oprs){
        
        if(si == ei){
            char ch = bool.charAt(si) ;
            // 0th index => count of true, 1st index => count of false.
            return ch == 'T' ? new int[]{1,0} : new int[]{0,1} ; // returning a 2 size array which has the count of true and false.
        }
        
        
        int[] curr = new int[2] ;
        
        for(int k = si ; k < ei ; k++){
            char opr = oprs.charAt(k) ;
            
            int[] left = helper(si,k,bool,oprs) ;
            int[] right = helper(k+1,ei,bool,oprs) ;
             
            if(opr == '|'){
                curr[0] += left[0]*right[0] + left[0]*right[1] + left[1]*right[0] ;
                curr[1] += left[1]*right[1] ;
            }
            else if(opr == '&'){
                curr[0] += left[0]*right[0] ;
                curr[1] += left[1]*right[1] +  left[0]*right[1] + left[1]*right[0]  ;
            }
            else{
                curr[0] += left[0]*right[1] + left[1]*right[0] ;
                curr[1] += left[1]*right[1] + left[0]*right[0] ;
            }
        }
        
        return curr ;
    }



    // memoization approch : 

    static int countWays3(int N, String S){
        // code here
        
        StringBuilder sb1 = new StringBuilder() ;
        String bool = "" ;
        StringBuilder sb2 = new StringBuilder() ;
        String oprns = "" ;
        
        for(char ch : S.toCharArray()){
            if( ch == 'T' || ch == 'F' ){ sb1.append(ch) ; }
            else{ sb2.append(ch) ; }
        }
        
        bool = sb1.toString() ;
        oprns = sb2.toString() ;
        
        Integer[][][] dp = new Integer[bool.length()][bool.length()][2] ;
        return  helper(0,bool.length() - 1,bool,oprns,dp)[0] ;
    } 
    
    static int[] helper(int si, int ei, String bool, String oprs, Integer[][][] dp){
        
        if(si == ei){
            char ch = bool.charAt(si) ;
            // 0th index => count of true, 1st index => count of false.
            return ch == 'T' ? new int[]{1,0} : new int[]{0,1} ;
        }
        
        
        if(dp[si][ei][0] != null ) { // returning if solved already
            return new int[]{dp[si][ei][0],dp[si][ei][1]} ;} 
        
        int[] curr = new int[2] ;  // current count of true and false
        
        for(int k = si ; k < ei ; k++){
            char opr = oprs.charAt(k) ;
            
            int[] left = helper(si,k,bool,oprs,dp) ;
            int[] right = helper(k+1,ei,bool,oprs,dp) ;
             
            if(opr == '|'){
                curr[0] = ( curr[0] + left[0]*right[0] + left[0]*right[1] + left[1]*right[0]) % 1003 ;
                curr[1] = ( curr[1] + left[1]*right[1])%1003 ;
            }
            else if(opr == '&'){
                curr[0] = (curr[0] + left[0]*right[0])%1003 ;
                curr[1] = (curr[1] + left[1]*right[1] +  left[0]*right[1] + left[1]*right[0])%1003  ;
            }
            else{
                curr[0] = (curr[0] + left[0]*right[1] + left[1]*right[0])%1003 ;
                curr[1] = (curr[1] + left[1]*right[1] + left[0]*right[0])%1003 ;
            }
        }
        
        // Storing to dp and returning.
        dp[si][ei][0] = curr[0] ;  
        dp[si][ei][1] = curr[1] ;
        
        return curr  ;
    }
}
