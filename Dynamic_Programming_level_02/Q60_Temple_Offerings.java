package Dynamic_Programming_level_02;

public class Q60_Temple_Offerings {

    public static void main(String[] args) {
        
    }

    public static int get_min_offering(int[] heights) {
        
        int[] left = new int[heights.length] ; // first finding for left side.
        int[] right = new int[heights.length] ; // then find from right to left

        left[0] = 1 ; // left most should be 1

        for (int j = 1 ; j < right.length ; j++) { // now starting from 1 to n-1 
            if(heights[j] > heights[j-1]){ // check if current height is greater than previous height then add 1 extra offering to current temple
                left[j] = left[j-1] + 1 ;
            }
            else{
                left[j] = 1 ; // else if current height lesser than previous height then store 1
            }
        }


        right[heights.length-1] = 1 ;
        for (int j = right.length - 2 ; j >= 0 ; j--) {
            if(heights[j] > heights[j+1]){// check if current height is greater than previous height then add 1 extra offering to current temple
                right[j] = right[j+1] + 1 ;
            }
            else{
                right[j] = 1 ; // else if current height lesser than previous height then store 1
            }
        }

        int ans = 0 ;

        for (int i = 0; i < right.length; i++) {
            ans += Math.max(left[i], right[i]) ; // add max of (left , right) of each point .
        }

        return ans ;
    }
}
