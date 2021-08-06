package Arrays;

import java.util.HashMap;

import java.util.Map;


/**
 * ElementsAppearedNdividedByK_Times_Q30
 */
public class ElementsAppearedNdividedByK_Times_Q30 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1};

        //gives o(n) time complexicity.
        getElementsThatAppearedNbyK_times(arr, 4);

        //gives o(n2) complexicity.
        // getElements(arr, arr.length, 4);
    }

    // time complexicity : o(n)
    public static void getElementsThatAppearedNbyK_times(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int x = arr.length/k ;
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        for (Map.Entry e : map.entrySet()) {
            int temp = (Integer)e.getValue();
            if(temp > x){
                System.out.println(e.getKey());
            }
        }
    }


    // // brute force approach : o(n2)

    // public static void getElements(int[] arr , int n , int k) {
    //     // int[] temp = new int[]

    //     Set<Integer> set = new HashSet<>();

    //     for (int i = 0; i < arr.length; i++) {
    //         int elementIS = arr[i];
    //         int count = 0;
    //         for (int j = 0; j < arr.length; j++) {
    //             if(arr[j] == elementIS){
    //                 count++;
    //             }
    //         }
    //         if(count > n/k){
    //             set.add(arr[i]);
    //         }
    //     }

    //     for (Integer integer : set) {
    //         System.out.print(integer+" ");
    //     }
    // }
}