package Arrays;

// this algorithm is used to find the largest sum of subarray.
public class Kadanes_Algorithm_Q18 {
    public static void main(String[] args) {
        int[] arr= {1,2,3,-2,5};
        System.out.println(kadanes_Algo(arr,arr.length));
        
    }
    public static int kadanes_Algo(int[] arr,int n) {
        
        int maxsofar = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax += arr[i];
            if(currentMax < arr[i]){
                currentMax = arr[i];
            } 
            if(currentMax>maxsofar){
                maxsofar = currentMax;
            }
        }
        
        
        return maxsofar;
        
    }
    
}
