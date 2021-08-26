package Searching_and_Sorting;

public class Q24_Book_Allocation_Problem {
 
    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        System.out.println(minimizeMaximumNumberOfPage(arr, 2));
    }
    public static int minimizeMaximumNumberOfPage(int[] books , int student) {
        
        int sum = 0 ;
        int max = 0 ;

        for (int i : books) {
            sum += i ;
            max = Math.max(max, i);
        }

        int low = max ; // max value is our min range because that max value atleast comes to one of the student.
        int high = sum; // we took total sum as max range although sum value will  never be our answwer. just for the binary search we took this value.
        int ans = 0 ;

        while (low <= high) {
            int maxLoad = low +(high - low)/2 ;
            // now we check if  a student can take less than or equal to maxload (it is the total pages a student can read) if not then we need another student to read pages less than or equal to maxLoad after that we check how many student we needed to read all books with maxLoad . if student can bear this load with available students then we try decreasing it . and vice versa.

            if(isPossible(books,maxLoad,student)){
                ans = maxLoad;
                high = maxLoad -1 ;
            }
            else{
                low = maxLoad + 1 ;
            }
            
        }
        return ans;
     }
    private static boolean isPossible(int[] books, int maxLoad, int student) {

        // took 1 student initially.
        int boolStudent = 1; 
        int sum = 0;
        
        for (int i = 0; i < books.length; i++) {

            sum += books[i];
            
            if(sum > maxLoad ){
                // if load is  greater than maxLoad on a single student then we increase the student and start giving loads from onward and so on .
                boolStudent++;
                sum = books[i];
            }
            
        }
        // when required students is greater than available students then we increase load.

        //  required students more means load is very less that's why more peoples are needed , so if we increase the load then each indivisual can read more. 
        return boolStudent <= student ;
    }
}
