package Arrays;

public class MovingNegativeNumbersOneSide {
    public static void main(String[] args) {
        int[] arr= {0,-1,2,-4,-5,6,-6,2,-4};
        movingNegative(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }

        
    }
    public static void movingNegative(int[] arr ) {
        int l = 0;
        int temp;
        int r = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                temp = arr[l];
                arr[l]=arr[i];
                arr[i] = temp;
                l++;               
            }

        }
        
    }
    
}
