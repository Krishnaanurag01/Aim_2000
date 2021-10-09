package Dynamic_Programming_level_02;

public class Q53_Maximum_Sum_Of_Two_Non_Overlapping_Subarrays {

    public static void main(String[] args) {

        // choose max between when case 1 : x is store from left side and y is stored from y
                              //   case 2 : x is stored from right side and y is stored from left side. 
                              // now return max of both cases.
                              
        // return Math.max(get_max_sum(nums,firstLen,secondLen),get_max_sum(nums,secondLen,firstLen));

    }

    public static int get_max_sum(int[] arr , int x , int y) {
        
        int n = arr.length ;
        int[] dp1 = new int[ n ] ; // this will store sum of x length from left 
        int[] dp2 = new int[ n ] ; // this will store sum of y length from right

        int sum = 0 ;
        for (int i = 0; i < n ; i++) {
            if(i < x){ // if i is less than x then simply store it to the dp1
                sum += arr[i] ;
                dp1[i] = sum ;
            }
            else{ // else if i becomes greater or equal to x then do this
                sum += arr[i] - arr[i-x] ; // removing starting value and adding next value(like sliding window)
                dp1[i] = Math.max( dp1[i-1] , sum ) ; // In this condition we check if previous sum is greater or current sum 
            }
        }

        sum = 0 ;

        for (int i = n-1 ; i >= 0 ; i--) { // now doing for y length from right to left.
             if(i+y >= n ){ // if i+y is greater or equals to n then simply store sum
                sum += arr[i] ;
                dp2[i] = sum ;
            }else{ // else do this , we have two option that is check max between current sum and i+1 sum and choose larger
                sum += arr[i] - arr[i+y] ;
                dp2[i] = Math.max( dp2[i+1] , sum ) ;
            }    
        }

        int ans = 0 ;


        // now checking fromo x-1(index wise)  to n-y(as we need y length subarray from second dp and x length from dp1) thats why starting from x-1 and n-y if we don't do this then we may get sub array of smaller size.
        for (int i = x - 1 ; i < n - y ; i++) {
            ans = Math.max(dp1[i] + dp2[i+1] , ans) ; // comparing answer.
        }

        return ans ;

    }
    
}
