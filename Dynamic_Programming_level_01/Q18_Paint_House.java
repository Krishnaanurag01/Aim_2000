package Dynamic_Programming_level_01;

public class Q18_Paint_House {


    public static void main(String[] args) {
        
    }

    // time is : o(n) and space is 0(1).
    public static int getMinpriceTopaint(int[][] prices) {
        

        int r = prices[0][0] ;// stroring house 1 red as default
        int b = prices[0][1] ; // house 1 blue as default
        int g = prices[0][2] ; // house 1 green as default

        for (int i = 1 ; i < prices.length; i++) { // now starting from house 2 to n ( index 1 to n-1)
            int nr = Math.min(b, g) + prices[i][0] ; // nr(new red) : for red finding the min in blue and green and adding current red value.
            int nb = Math.min(r, g) + prices[i][1] ; // nb(new blue) : finding min in red and green and adding current blue price.
            int ng = Math.min(r, b) + prices[i][2] ;// ng(new green) : finding min in red and blue and adding current green price.

            r = nr ; // now storing all the new blue , new red, new green.
            b = nb ;
            g = ng ;
        }
 
        return Math.min(r, Math.min(b, g)) ; // and returing the min of all three.
    }
    
}
