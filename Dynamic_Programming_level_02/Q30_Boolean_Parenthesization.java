package Dynamic_Programming_level_02;

public class Q30_Boolean_Parenthesization {

    public static void main(String[] args) {
        count_ways("T|T&F^T");
    }


    public static int count_ways(String s) {

        String str1= "", str2="" ;  // now storing both bool and operation seperately.

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
    
}
