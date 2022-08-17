package Matrix;

public class KthSmallestElementInMatrix_Q10 {
    public static void main(String[] args) {
       int mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }};

    System.out.println(kthSmallest(mat, 7));
    }

    public static int kthSmallest(int[][] matrix, int k) {// we have to find the value which is larger than k-1 numbers.
        if(matrix==null) return 0;

       int startVal = matrix[0][0]; // first value is start value.
       int r = matrix.length; // row
       int c = matrix[0].length; // column
       int endVal = matrix[r-1][c-1]; // last value is end value.
       int midValue;
       
       
       while(startVal <= endVal){ // keep iterating untill the startvalue is not graeater than endval.
       
        midValue = (startVal+endVal)/2; // find the mid value.
       
        int ans = 0;
       
        
        for(int i = 0 ; i < r ;i++){ // now  traversing in each row.  // here we applying the normal binary seach in each row. and calculating the total numbers we get from every row which defines that ans variable have all the values which is less than mid value.
     
            int lo = 0 , high = c-1 ; // took low = 0  and high is last value by default.
     
            int mid ;
     
            while(lo <= high){ /// keep traversng unitll low become greater.
     
                mid = lo + (high-lo)/2; // now finding thw mid  of each row. this mid is our column index.
     
                if(matrix[i][mid] <= midValue) lo = mid+1; // we check if the value at ith row and mid column is less than midValue then it means there might be a chance that increasing the low will give more numbers that is less than equal to midvalue.
     
                else high = mid-1; // else no number is less than or equal to midValue then we look to left side.
     
            }
            ans+=lo;  // after each loop we add the low to the ans. (low will have total number of elements which is less than or equal to mid value.)
        }
           
           if(ans < k ) startVal = midValue+1; // looking for the right side. when ans is less than k means there might be a chance that if we look into the right side then we'll get ans such that its equal to k. or the moment startval become greater than endval then return  it.
           else endVal = midValue-1; // looking in the left side.
       }
       return startVal;
   }


}
