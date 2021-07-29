package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArrayOfNplusOne {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(getDuplicate(arr));
    }
    public static int getDuplicate(int[] arr) {

        // method 1 : time complexicity = nlogn

        // Arrays.sort(arr);
        // for (int i = 1; i < arr.length; i++) {
        //     if(arr[i]==arr[i-1]){
        //         return arr[i];
        //     }
        // }
        
        // return 0;

        // method 2 : time complexicity o(n)

        // Set<Integer> set = new HashSet<>();
        // for (Integer i : arr) {
        //     if(set.contains(i)){
        //         return i ;
        //     }
        //     set.add(i);            
        // }
        // return 0 ;


        // best suited answer


        // method 4 : works only when all the elements are positive and time complexicity is 0(n)

        // for (int i = 0; i < arr.length; i++) {
        //     int current = Math.abs(arr[i]);
        //     if(arr[current]< 0){
        //         return current;
        //     }
        //     arr[current] = current*-1;
        // }
        // return 0;



        
        // method 3: time comp : o(n)

        int tortoise = arr[0];
        int hare = arr[0];
        do{
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        }while(tortoise != hare);

        hare = arr[0];
        while(tortoise!= hare){
            hare = arr[hare];
            tortoise = arr[tortoise];
        }
        return tortoise;
    }
    
}
