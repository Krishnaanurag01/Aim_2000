package Arrays;


import java.util.HashMap;


public class CountPairsWithGivenSum_Q23 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 10, 15, -1, 7, 6, 
            5, 4, 2, 1, 1, 1};
        
        System.out.println(getCountOfPairs(arr,11));
        
    }

// brute force. o(n2)
// use neested loop for that.


    // // time complexicity : o(nlogn + n)

    // getting error in this.

    // public static int getCountOfPairsUsingWhile(int[] arr, int k) {
    //     int i = 0;
    //     int j = arr.length-1;
    //     int count = 0;
    //     Arrays.sort(arr); 
    //     while (i < j) {
    //         if(arr[i] + arr[j] > k){
    //             j--;
    //         }
    //         else if(arr[i] + arr[j] < k){
    //             i++;
    //         }
    //         if(arr[i]+ arr[j] == k)
    //         {
    //             count++;
    //             i++;
            
    //         }

    //         }
    //     return count;
    // }



    // time complexicty : o(n)

    public static int getCountOfPairs(int[] arr , int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = k - arr[i];
            if(map.containsKey(element)){
                count += map.get(element);
            }
            if( map.get(arr[i]) == null){
                map.put(arr[i] , 0);
            }
            map.put(arr[i], map.get(arr[i])+1);
        }

        
        return count;
        
    }
}
