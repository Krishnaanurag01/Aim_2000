package Arrays;

/**
 * MinimumSwapsRequiredToBringElement_Q38
 */
public class MinimumSwapsRequiredToBringElement_Q38 {
public static void main(String[] args) {
    int[] arr = {2, 1, 5, 6, 3};
    System.out.println(swapItByMinimumNumbers(arr, arr.length , 3));
    
}
public static int swapItByMinimumNumbers(int[] arr, int n , int k) {

    // using sliding window technique.
    
   int fav = 0; // this is favourable elemetns.
   int nonFav = 0; // this is non favourable.
   
   for (int i = 0; i < n ; i++) { // first find the all the favourable elements. this will be our window size.
       if(arr[i] <= k) fav++;       
   }
   for (int i = 0; i < fav; i++) { // now find non fav in window size from 0 to fav - 1 element
       if(arr[i] > k) nonFav++;
   }

   int l = 0 , r = fav-1 , result = Integer.MAX_VALUE; // l is left side of window and r is right side of window.

   while (r < n) { // keep moving forward untill window end not becomes equal to n.
       result = Math.min(result, nonFav); // here finding the non fav elements, becuase the number of non favourable element present in our element has to swapped with favourable element so minimum the number of non favourable element minimum the swap required.
       r++; // increasing window right size.
       if(r< n && arr[r] > k) nonFav++; //  check otherwise out of bound will arise. check for non fav.
       if(l < n && arr[l] > k) nonFav--;// if left most is non fav then decrement the count because left side will also move 1 step towards right to maintain the window size.
       l++; // left side moving towards right.
       
   }

    return result; // finally returning the answer.
    

}

    
}