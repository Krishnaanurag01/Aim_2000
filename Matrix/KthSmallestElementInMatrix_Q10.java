package Matrix;

public class KthSmallestElementInMatrix_Q10 {
    public static void main(String[] args) {
       int mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }};

    System.out.println(kthSmallest(mat, 3));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix==null) return 0;
       int startVal = matrix[0][0];
       int r = matrix.length;
       int c = matrix[0].length;
       int endVal = matrix[r-1][c-1];
       int midValue;
       
       while(startVal <= endVal){
           midValue = (startVal+endVal)/2;
           int ans = 0;
           
           for(int i = 0 ; i < r ;i++){
           int lo = 0 , high = c-1 ;
               int mid ;
               while(lo <= high){
                   mid = lo + (high-lo)/2;
                   if(matrix[i][mid] <= midValue) lo = mid+1;
                   else high = mid-1;
               }
               ans+=lo;
           }
           
           if(ans < k ) startVal = midValue+1;
           else endVal = midValue-1;
       }
       return startVal;
   }


}
