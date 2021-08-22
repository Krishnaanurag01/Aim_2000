package Searching_and_Sorting;

import java.util.HashMap;
import java.util.Map;

public class Q8_Majority_Element {
    public static void main(String[] args) {
        
    }

    // using o(n) time and space complexcity.
    public static int getMajorityElementWhich_is_GreaterThan_NbyK(int[] arr) {                       //Majority element > n/2.
       HashMap<Integer,Integer> map = new HashMap<>();

       for (int i : arr) {
           map.put(i, map.getOrDefault(i, 0 ) + 1);
       }


       for (Map.Entry<Integer,Integer> i : map.entrySet()) {
           if((int)i.getValue() > arr.length/2){
               return (int)i.getKey();
           }
       }


        return -1 ;
    }

    // now doing in o(n) time and o(1) space complexcity. ( *********** Moore's Voting Algorithm *************)

    public static int getMajorityElementUsing_MOORES_VOTING_Algo(int[] arr) {
        
        int value = getMostPotentialValue(arr);
        // now we'll check is the value which get from above function is satisfying our conditions or not. and for that we'll first find frequency of that element.

        int valueFreq = 0 ;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                valueFreq++;
            }

            // if we already have enough frequency to fulfil the conditions then we'll return the value.
            if(valueFreq > arr.length/2){
                return value;
            }
        }
 // otherwise we simply return -1;
        return -1;
    }

    private static int getMostPotentialValue(int[] arr) {
        int val = arr[0]; // take first element .
        int count  = 1 ;  // and intialize count to 1.


        // now start with 1 index.
        for (int i = 1 ; i < arr.length; i++) {
            // check if arr[i] is same or distinct.
            if(val == arr[i]){
                count++; // we'll increase count then.
            }
            else{
                // else we'll map the available count of val with distinct element.
                count--;  // as we mapped one count of val with distinct element so count decreased.
            }

            if(count == 0) {
                // when count becomes zero then it means we have no more available instance of val so we'll make arr[i] new val.
                val = arr[i] ;
                count = 1;
            }
        }

        // after the end of the loop the val variable have most potential element which could be answer. so we'll return it.
        return val;
    }
}
