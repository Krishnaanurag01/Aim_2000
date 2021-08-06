package Arrays;

public class ThreeWayPartionting_Q37 {
    public static void main(String[] args) {
        int[] arr = {5,7,1,4,3,6};
        getModifiedArray(arr, arr.length, 2,4);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void getModifiedArray(int[] arr , int n , int a , int b) {
        
        int left = 0 ; 
        int right = n-1;
        for (int i = 0; i <=right; i++) {

            if(arr[i] < a){
                swapIt(arr,i,left);
                left++;
            }
            else if(arr[i] > a){
                swapIt(arr,i,right);
                right--;
                i--;
            }
            
        }
    }
    private static void swapIt(int[] arr, int i, int left) {
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
    }
}
