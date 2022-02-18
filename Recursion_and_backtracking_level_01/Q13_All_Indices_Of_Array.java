package Recursion_and_backtracking_level_01;
import java.io.*;

public class Q13_All_Indices_Of_Array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        
        if(idx == arr.length){ 
            return new int[fsf] ; // make and return an array of size fsf(found so far -> freq of x).
        }

        if(arr[idx] == x){ // when current elemen equals to x

          int[] ans = allIndices(arr,x,idx+1,fsf+1) ; // look next with idx+1 and fsf+1
          ans[fsf] = idx ; // store cuurent index on current fsf
          return ans ;
        }
        else{
          int[] ans = allIndices(arr,x,idx+1,fsf) ;// look next with index +1 only as current element is not equals to x so we will not increase the freq of fsf
          return ans ;
        }
    }
    
}
