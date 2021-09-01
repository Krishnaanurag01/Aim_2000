package Arrays;



public class RearraningArrayInAlternatePosition_Q25 {
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, -4, -1, 4};
        rearrangeIt(arr,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void rearrangeIt(int[] arr,int n) {
        // we havee to place negative numbers on even position and positive on odd position

        int i = 0 ;// for next negative number
        int j = 0 ;// for next positive number
        int k = 0 ;// for  traversing array
        while (k < n ) {
            if(k % 2 == 0){
                // for even position getting negative numbers.
                if(arr[k]>=0){
                    i=k;
                    while (i<n && arr[i]>= 0) {
                        i++;
                    }
                    if(i>n){
                        break;
                    }
                    else rotateArray(arr, k,i);
                }
            }
            else{
                if(arr[k]<0){
                    j = k;
                    while(j<n && arr[j] < 0){
                        j++;
                    }
                    if(j>n){
                        break;
                    }
                    else rotateArray(arr, k, j);
                }
            }
        k++;
    }
}
    public static void rotateArray(int[] arr , int start , int end) {
        int temp = arr[end];
        for (int i = end-1 ; i >=start; i--) {
            arr[i+1]=arr[i];
            
        }
        arr[start] = temp;        
    }
}
