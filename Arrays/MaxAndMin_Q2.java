package Arrays;

public class MaxAndMin_Q2 {
    public static void main(String[] args) {
        int[] numbers= {7,23,11,06,001};
        System.out.println(max(numbers));
        System.out.println(min(numbers));

        
    }
    public static int max(int[] arr) {
        int m = arr[0];
        for(int i = 1; i< arr.length ; i++){
            if(arr[i]>m){
                m=arr[i];
            }
        }
        return m;
    }
        public static int min(int[] arr) {
            int m = arr[0];
            for(int i = 1; i< arr.length ; i++){
                if(arr[i]<m){
                    m=arr[i];
                }
            }
            return m;
            
        }
    }
