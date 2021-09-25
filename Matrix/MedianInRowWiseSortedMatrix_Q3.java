package Matrix;

public class MedianInRowWiseSortedMatrix_Q3 {
    public static void main(String[] args) {
        int R = 3, C = 3 ;
         int[][] M = {{1, 3, 5}, 
                     {2, 6, 9}, 
                     {3, 6, 9}};

        System.out.println(getMedian(M, R, C));

    }

    // applying binary search same as kth smallest element in matrix.
    public static int getMedian(int[][] matrix , int r ,int c) {
        int startValue= 0 , endValue = 2000, midValue;
        int n = r*c ;
        
        while(startValue<= endValue){
            midValue = (startValue+endValue)/2;
            int ans = 0;
            for(int i = 0 ; i< r ; i++){
                
                int l=0 , h = c-1;
                while(l <= h){
                    int m = l+(h-l)/2;
                    if(matrix[i][m]<= midValue) l=m+1;
                    else h = m-1;
                }
                ans+=l;
            }
            if(ans <= n/2) startValue = midValue+1;
            else endValue = midValue -1;
        }
        return startValue;
    }
}
