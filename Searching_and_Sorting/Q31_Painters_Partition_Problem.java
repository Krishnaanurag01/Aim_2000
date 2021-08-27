package Searching_and_Sorting;


public class Q31_Painters_Partition_Problem {

    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };

       System.out.println( getMinimumTimeToPaintAllBoards(arr, arr.length,3));
        
    }

    // total same as Book allocation question. for better understanding check Q24 solutions.


    public static int getMinimumTimeToPaintAllBoards(int[] boards , int n , int painters) {

        int low = 0 ;
        int high = 0 ;

        for (int i : boards) {
            low = Math.max(low, i);
            high += i;
        }

        int ans = 0;

        while( low <= high){

            int mid = low + (high - low)/2 ;

            if(isPossible(boards,mid, painters)){
                high = mid - 1 ;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }

    private static boolean isPossible(int[] boards, int mid ,int painters) {

        int sum = 0 ;
        int intialPainterCount = 1;

        for (int i = 0; i < boards.length; i++) {
            
            sum += boards[i];
            if( sum > mid){
                sum = boards[i];
                intialPainterCount++;
            }
        }
        return intialPainterCount<=painters;
    }
    
}
