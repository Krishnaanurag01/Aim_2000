package Dynamic_Programming;

import java.util.Scanner;

public class Q19_Paint_House_2_Many_Colors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int houses = sc.nextInt() ;
        int colours = sc.nextInt() ;

        int[][] house_with_colours = new int[houses][colours] ;

        for (int i = 0; i < house_with_colours.length; i++) {
            for (int j = 0; j < house_with_colours[0].length; j++) {
                house_with_colours[i][j] = sc.nextInt() ; // this will store the price for every colour on every house.
            }
        }

        // now finding minimum price to paint all houses.

        get_min_price_to_paint(house_with_colours) ;

        sc.close(); 

    }

    // method 01 : time is O(n3) and space is O(n2).

    private static void get_min_price_to_paint(int[][] houses) {

        int[][] dp = new int[houses.length][houses[0].length] ;

        for (int j = 0; j < dp[0].length; j++) { // storing the price of every colour of first house as it is in dp.
            dp[0][j] = houses[0][j] ;
        }

        for (int i = 1 ; i < dp.length; i++) { // now startin from second house.
            for (int j = 0; j < dp[0].length; j++) { // each colour price.
                
                int min = Integer.MAX_VALUE ; // finding min price in previous row such that no two colours are adjecent.

                for (int k = 0; k < dp[0].length; k++) { // finding min.
                    if(k != j ){
                        min = Math.min(min, dp[i-1][k]) ;
                    }
                }

                dp[i][j] = houses[i][j] + min ; // now adding the given colour price with min.


            }
        }

        int ans = Integer.MAX_VALUE ; // finding the minimum in last row.

        for (int j = 0; j < dp[0].length; j++) {
            ans = Math.min( dp[ dp.length-1 ][ j ] , ans ) ;
        }

        System.out.println(ans);


    }
    


    // method 02 : takes O(n2) time and o(n2) space .

    public static void get_Min_price(int[][] houses) {
        
        int[][] dp = new int[houses.length][houses[0].length ]; 

        // in this method we simply store least and second least of each row. which will help me in not using the third row for finding min again and again.

        int least = Integer.MAX_VALUE ;  // least. 
        int sleast = Integer.MAX_VALUE ; // second least.

        for (int j = 0; j < dp[0].length; j++) { // storing the price of every colour of first house as it is in dp.
            dp[0][j] = houses[0][j] ; 

            if(dp[0][j] <= least){ // finding least and second least of first row. if value is less than least then least will be updated with that value and second least will be updated with least value.
                sleast = least ;
                least = dp[0][j] ;
            }
            else if( dp[0][j] <= sleast){ // here when only value is less then sleast then updating it.
                sleast = dp[0][j] ;
            }
        }




        for (int i = 1 ; i < dp.length; i++) {

            int nleast = Integer.MAX_VALUE ; // these two will find the new least and second least concurrently.
            int nsleast = Integer.MAX_VALUE ;
            
            for (int j = 0; j < dp[0].length; j++) {
                
                if( least == dp[i-1][j]){ // if our previous value is least one then add second least with colour price.
                    dp[i][j] = sleast + houses[i][j] ;
                }
                else{
                    dp[i][j] = least + houses[i][j] ; // otherwise simply add colour price with least.
                }

                // now finding new least and new second least of current row.

                if(dp[i][j] <= nleast){
                    nsleast = nleast ;
                    nleast = dp[i][j] ;
                }
                else if( dp[0][j] <= nsleast){
                    nsleast = dp[i][j] ;
                }
            
            }

            least = nleast ; // updating least and sleast with new least and sleast.
            sleast = nsleast ;
        }

        // now least will be our answer ( as it store the minimum value of last row.)
        System.out.println(least);
    }
}
