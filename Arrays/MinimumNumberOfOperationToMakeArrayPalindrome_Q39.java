package Arrays;

public class MinimumNumberOfOperationToMakeArrayPalindrome_Q39 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 1};
        System.out.println(makePalindromic(arr, arr.length));
    }
    public static int makePalindromic(int[] arr , int n) {
        int i = 0 ;
        int j = n-1;

        // this ans variable return the total number of  steps to make array palindromic.
        int ans = 0;

        while(i < j){
            if(arr[i] == arr[j]){
                i++;
                j--;
            }
            else if(arr[i] < arr[j]){
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
            else{
                j--;
                arr[j] += arr[j+1];
                ans++;
            }
        }
        return ans;
    }
}
