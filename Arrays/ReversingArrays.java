package Arrays;

public class ReversingArrays {
    public static void main(String[] args) {
        int[] num = {11,12,13,14,15,16};
        // reverseIterative(num,0,num.length-1);
        reverseRecursivly(num,0,num.length-1);
        for(int i : num){
            System.out.print(i+" ");
        }

    }
    // 1st way iterative way :
    public static void reverseIterative(int[] arr , int start , int end){
        int temp;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    // 2nd way : recursive way.

    public static void reverseRecursivly(int[] arr, int start , int end){
        if (start >= end)return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseRecursivly(arr, start+1, end-1);
    }
}
