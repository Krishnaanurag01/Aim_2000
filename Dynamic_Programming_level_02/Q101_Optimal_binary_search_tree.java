package Dynamic_Programming_level_02;

public class Q101_Optimal_binary_search_tree {


    public static void main(String[] args) {
        
    }


    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        
        int[][] dp = new int[keys.length][keys.length] ;
        

        // using gap strategy.
        for(int g = 0 ; g < keys.length ; g++){
            for( int i = 0 , j = g ; j < keys.length ; j++,i++){
                
                if(g==0){ // when gap is 0 : we have only one element at level 1 so it's search cost will be it's level(1)*freq[i] .
                    dp[i][j] = freq[i];
                }
                else if(g==1){ // when gap is 1 : we have only two element one at level 1 and another one at level 2 so it's search cost will be either : first_Element*1(level 1) + second_element*2( 2 because it's on second level.)  or second_Element*1(level 1) + first_element*2( 2 because it's on second level.).

                // we'll choose the minimum ans. 

                    int f1 = freq[i];
                    int f2 = freq[j];
                    
                    dp[i][j] = Math.min( f1 + 2*f2 , f2 + 2*f1);

                }
                else{
                    
                    int sum = 0 ; // finding sum of elements from i to j.
                    
                    for( int x = i ; x <=j ; x++){
                        sum += freq[x] ;
                    }
                    
                    int min = Integer.MAX_VALUE ; // this will contain the minimum sum.
                    
                    for( int k = i ; k <= j ; k++){ // now running loop from i to j.
                        // here k means the root element.

                        // when k is root then the left side element will be i to k-1 and right side element will be k+1 to j.
                        
                        int left = k == i ? 0 : dp[i][k-1] ;
                        int right = k ==j ? 0 : dp[k+1][j] ;
                        
                        min = Math.min(left+right+sum,min) ;  // now adding left sum + right sum + total sum of frequency because  the left and right side value is of thier on level and we are adding those value in current level so the left and right side level will be increased by 1 so we are all the frequency of each element ( that us total sum)
                    }
                    
                    dp[i][j] = min ; // storing min.
                }
                
            }
        }
        
    //
        return dp[0][keys.length-1] ;
        
        
    }
    
}
