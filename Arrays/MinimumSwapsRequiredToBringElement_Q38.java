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
    
   int fav = 0;
   int nonFav = 0;
   
   for (int i = 0; i < n ; i++) {
       if(arr[i] <= k) fav++;       
   }
   for (int i = 0; i < fav; i++) {
       if(arr[i] > k) nonFav++;
   }

   int l = 0 , r = fav-1 , result = Integer.MAX_VALUE;

   while (r < n) {
       result = Math.min(result, nonFav);
       r++;
       if(r< n && arr[r] > k) nonFav++;
       if(l < n && arr[l] > k) nonFav--;
       l++;
       
   }

    return result;
    

}

    
}