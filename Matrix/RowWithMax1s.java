package Matrix;

public class RowWithMax1s {
    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };

        System.out.println(getRowWithMaxNum(arr, 4, 4));
    }

    // time complexicity : o(n^2)
    // public static int getRowWithMaxNum(int[][] arr, int r, int m) {
    //     int rowis = 0;
    //     int max1s = 0;
    //     for (int i = 0; i < r; i++) {
    //         int currentMax = 0;
    //         for (int j = 0; j < m; j++) {
    //             if (arr[i][j] == 1) {
    //                 currentMax++;
    //             }
    //         }
    //         if (currentMax > max1s) {
    //             max1s = currentMax;
    //             rowis = i;
    //         }

    //     }

    //     return rowis;

    // }



    // time complexicity : log(n+m)

    public static int getRowWithMaxNum(int[][] arr , int r , int c) {

        int rowis= -1;
        int col = c-1;

        for (int i = 0; i < r; i++) {

            for (int j = col ; j >=0 ; j--) {

                if(arr[i][j] == 1){
                    rowis = i ;
                    col--;
                }
                else break;
                
            }
            
        }

        return rowis;
    }

}
