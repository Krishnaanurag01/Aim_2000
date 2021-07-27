package Arrays;

/**
 * CyclicallyRotatingArrayByOne
 */
public class CyclicallyRotatingArrayByOne {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateCyclically(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        
    }
    public static void rotateCyclically(int[] arr) {
        int temp;
        for (int i = arr.length-1; i >0; i--) {
            temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;            
        }
        
    }
}