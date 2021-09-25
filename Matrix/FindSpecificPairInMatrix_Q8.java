package Matrix;

public class FindSpecificPairInMatrix_Q8 {
    public static void main(String[] args) {
       int mat[][] = {{ 1, 2, -1, -4, -20 },
             { -8, -3, 4, 2, 1 }, 
             { 3, 8, 6, 1, 3 },
             { -4, -1, 1, 7, -6 },
             { 0, -4, 10, -5, 1 }};

             System.out.println(getMaxDifference(mat));
        
    }
    public static int getMaxDifference(int[][] arr) {
        
        int i =0 ;
        int j = 0;

        int maxValue = 0 ;


        // first finding the max value. and taking index of that.
        for (int j2 = 0; j2 < arr.length; j2++) {
            for (int k = 0; k < arr[0].length ; k++) {
                
                if (maxValue < arr[j2][k]){

                    maxValue = Math.max(maxValue, arr[j2][k]);
                    i = j2;
                    j = k; 
                }
            }
        }

        // System.out.println(maxValue +"=>" +i +" "+ j);

        int ans =0 ;

        // now search again from start to the index of max value and keep checking ans (such that max value - current value ) for each value and update answer if get the larger difference.

        for (int k = 0; k < i; k++) {
            for (int k2 = 0; k2 < j; k2++) {

                ans = Math.max(ans, maxValue - arr[k][k2]);
                
            }
            
        }
        return ans;
    }
}
